package com.backend.lmsapi.repositories;

import java.util.List;
import java.util.Optional;

import com.backend.lmsapi.model.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
    List<Genre> findAllByStatus(String status);
    Optional<Genre> findById(String id);
    
}
