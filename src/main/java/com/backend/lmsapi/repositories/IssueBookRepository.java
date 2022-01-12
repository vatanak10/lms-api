package com.backend.lmsapi.repositories;

import java.util.List;
import java.util.Optional;

import com.backend.lmsapi.model.IssueBook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBookRepository extends JpaRepository<IssueBook, String> {
    List<IssueBook> findAllByStatus(String status);
    Optional<IssueBook> findById(String id);
    Optional<IssueBook> findByBookId(String bookId);
}
