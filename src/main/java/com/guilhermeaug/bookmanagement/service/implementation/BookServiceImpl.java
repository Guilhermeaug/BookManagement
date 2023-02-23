package com.guilhermeaug.bookmanagement.service.implementation;

import com.guilhermeaug.bookmanagement.dto.request.BookRequestDto;
import com.guilhermeaug.bookmanagement.model.BookModel;
import com.guilhermeaug.bookmanagement.model.CategoryModel;
import com.guilhermeaug.bookmanagement.repository.BookRepository;
import com.guilhermeaug.bookmanagement.repository.CategoryRepository;
import com.guilhermeaug.bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookModel save(BookRequestDto bookRequestDto) {
        BookModel book = new BookModel();
        BeanUtils.copyProperties(bookRequestDto, book);

        var categoriesModel = bookRequestDto.categories().stream().map(category -> {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setTitle(category);
            return categoryModel;
        }).collect(Collectors.toSet());

        Set<CategoryModel> categoriesSet = new HashSet<>();
        for (CategoryModel categoryModel : categoriesModel) {
            var categoryFromDb = categoryRepository.findByTitle(categoryModel.getTitle());
            if (categoryFromDb.isPresent()) {
                categoriesSet.add(categoryFromDb.get());
            } else {
                categoryModel = categoryRepository.save(categoryModel);
                categoriesSet.add(categoryModel);
            }
        }
        book.setCategories(categoriesSet);

        return bookRepository.save(book);
    }

    @Override
    public List<BookModel> getAll() {
        return bookRepository.findAll();
    }
}
