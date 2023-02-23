package com.guilhermeaug.bookmanagement.repository;

import com.guilhermeaug.bookmanagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
}
