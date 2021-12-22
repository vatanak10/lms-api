package com.backend.lmsapi.repositories;

import java.util.Optional;

import com.backend.lmsapi.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;





public interface AuthorRepository extends JpaRepository<Author, String>{
    List<Author> findAllByStatus(String status);
    Optional<Author> findById(String id);
    
}
