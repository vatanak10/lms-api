package com.backend.lmsapi.repositories;

import java.util.List;
import java.util.Optional;

import com.backend.lmsapi.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String>{
    List<Book> findAllByStatus(String status);
    List<Book> findAllByStatusIn(String[] status);
    Optional<Book> findByIdAndStatus(String id, String status);
}
