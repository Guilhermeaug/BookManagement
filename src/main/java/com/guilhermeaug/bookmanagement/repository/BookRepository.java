package com.guilhermeaug.bookmanagement.repository;

import com.guilhermeaug.bookmanagement.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
    Optional<BookModel> findBookModelByCategoriesId(Long id);
}
