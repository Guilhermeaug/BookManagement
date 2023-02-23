package com.guilhermeaug.bookmanagement.service;

import com.guilhermeaug.bookmanagement.dto.request.BookRequestDto;
import com.guilhermeaug.bookmanagement.model.BookModel;

import java.util.List;

public interface BookService {
    BookModel save(BookRequestDto bookResponseDto);
    List<BookModel> getAll();
}
