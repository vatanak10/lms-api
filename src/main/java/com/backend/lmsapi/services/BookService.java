package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.dto.BookDto;
import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    List<ResponseBook> getAllBook();
    Book addBook(BookDto bookDto);
    Book updateBook(ResponseBook responseBook);
    String deleteBook(ResponseBook responseBook);
}
