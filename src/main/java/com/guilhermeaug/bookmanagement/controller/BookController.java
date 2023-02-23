package com.guilhermeaug.bookmanagement.controller;

import com.guilhermeaug.bookmanagement.dto.request.BookRequestDto;
import com.guilhermeaug.bookmanagement.model.BookModel;
import com.guilhermeaug.bookmanagement.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookModel> save(@Valid @RequestBody BookRequestDto book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }
}
