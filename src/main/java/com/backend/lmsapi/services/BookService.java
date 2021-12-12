package com.backend.lmsapi.services;

import java.util.ArrayList;
import java.util.List;

import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.model.Book;
import com.backend.lmsapi.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    public List<ResponseBook> getAllBook() {
        List<Book> books = bookRepository.findAllByStatus("available");
        List<ResponseBook> responseBook = new ArrayList<>();
        for (Book book: books) {
            responseBook.add(new ResponseBook(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getImg()
            ));
        }
        return responseBook;
    }

    // Insert command guide https://www.postgresqltutorial.com/postgresql-insert/
    // Sometimes the img url is too long, so need to solution to shorten the url in the program
    public boolean addBook(Object obj){

        return true;
    }
}
