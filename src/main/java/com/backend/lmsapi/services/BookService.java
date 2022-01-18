package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.dto.BookDto;
import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    List<ResponseBook> getAllBook();
    ResponseBook getBook(String id);
    Book addBook(BookDto bookDto);
    Book updateBook(ResponseBook responseBook);
    String deleteBook(String id);
    Boolean borrowBook(String id);
    Boolean returnBook(String id);
}
