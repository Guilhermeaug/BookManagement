package com.guilhermeaug.bookmanagement.controller;

import com.guilhermeaug.bookmanagement.dto.request.CategoryRequestDto;
import com.guilhermeaug.bookmanagement.model.CategoryModel;
import com.guilhermeaug.bookmanagement.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    ResponseEntity<CategoryModel> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.save(categoryRequestDto));
    }

    @GetMapping
    ResponseEntity<List<CategoryModel>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
