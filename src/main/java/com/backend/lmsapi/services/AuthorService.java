package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.dto.AuthorDto;
import com.backend.lmsapi.dto.ResponseAuthor;
import com.backend.lmsapi.model.Author;

import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    List<ResponseAuthor> getAllAuthor();
    ResponseAuthor getAuthor(String id);
    Author addAuthor(AuthorDto authorDto);
    Author updateAuthor(ResponseAuthor responseAuthor);
    String deleteAuthor(String id);
}
