package com.guilhermeaug.bookmanagement.service;

import com.guilhermeaug.bookmanagement.dto.request.CategoryRequestDto;
import com.guilhermeaug.bookmanagement.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAll();
    CategoryModel save(CategoryRequestDto categoryRequestDto);
}
