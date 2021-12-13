package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.backend.lmsapi.dto.BookDto;
import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.model.Book;
import com.backend.lmsapi.repositories.BookRepository;
import com.backend.lmsapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceDef implements BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<ResponseBook> getAllBook() {
        List<Book> books = bookRepository.findAllByStatus("available");
        List<ResponseBook> responseBook = new ArrayList<>();
        for (Book book: books) {
            responseBook.add(new ResponseBook(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getImgUrl(),
                book.getStatus()
            ));
        }
        return responseBook;
    }


    // Insert command guide https://www.postgresqltutorial.com/postgresql-insert/
    @Override
    public Book addBook(BookDto bookDto){
        Book book = new Book(UUID.randomUUID().toString(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getImgUrl(), "available");
        return bookRepository.save(book);
    }


    @Override
    public Book updateBook(ResponseBook responseBook) {
        Book book = new Book(responseBook.getId(), responseBook.getTitle(), responseBook.getAuthor(), responseBook.getImgUrl(), responseBook.getStatus());
        return bookRepository.save(book);
    }
}
