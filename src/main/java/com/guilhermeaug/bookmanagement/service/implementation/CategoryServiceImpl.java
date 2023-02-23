package com.guilhermeaug.bookmanagement.service.implementation;

import com.guilhermeaug.bookmanagement.dto.request.CategoryRequestDto;
import com.guilhermeaug.bookmanagement.model.CategoryModel;
import com.guilhermeaug.bookmanagement.repository.CategoryRepository;
import com.guilhermeaug.bookmanagement.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryModel save(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = new CategoryModel();
        BeanUtils.copyProperties(categoryRequestDto, categoryModel);
        return repository.save(categoryModel);
    }

    @Override
    public List<CategoryModel> getAll() {
        return repository.findAll();
    }
}
