package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        String[] status = {"available", "issued"};
        List<Book> books = bookRepository.findAllByStatusIn(status);
        List<ResponseBook> responseBook = new ArrayList<>();
        for (Book book: books) {
            responseBook.add(new ResponseBook(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getGenre(),
                book.getAuthor(),
                book.getImgUrl(),
                book.getStatus(),
                book.getPublishedDate()
            ));
        }
        return responseBook;
    }

    @Override
    public ResponseBook getBook(String id) {
        Optional<Book> isBook = bookRepository.findById(id);

        if(!isBook.isPresent()) {
            return null;
        }
        Book yesBook = isBook.get();
        return new ResponseBook(
                yesBook.getId(), 
                yesBook.getTitle(),  
                yesBook.getDescription(),
                yesBook.getGenre(),
                yesBook.getAuthor(), 
                yesBook.getImgUrl(), 
                yesBook.getStatus(),
                yesBook.getPublishedDate()
            );        
    }

    // Insert command guide https://www.postgresqltutorial.com/postgresql-insert/
    @Override
    public Book addBook(BookDto bookDto){
        Date date = new Date();
        Book book = new Book(UUID.randomUUID().toString(), bookDto.getTitle(), bookDto.getDescription(),bookDto.getGenre(), bookDto.getAuthor(), bookDto.getImgUrl(), "available", bookDto.getPublishedDate(), date, date);
        return bookRepository.save(book);
    }


    @Override
    public Book updateBook(ResponseBook responseBook) {
        Optional<Book> oldBook = bookRepository.findByIdAndStatus(responseBook.getId(), "available");
        if(!oldBook.isPresent()) {
            return null;
        }
        Book res = oldBook.get();
        Date date = new Date();
        Book book = new Book(responseBook.getId(), responseBook.getTitle(),responseBook.getDescription(), responseBook.getGenre(), responseBook.getAuthor(), responseBook.getImgUrl(), responseBook.getStatus(), responseBook.getPublishedDate(), res.getCreatedDate(), date);
        return bookRepository.save(book);
    }

    
    @Override
    public String deleteBook(String id) {
        Optional<Book> book = bookRepository.findByIdAndStatus(id, "available");
        if(!book.isPresent()) {
            return "Book cannot found";
        }
        Book res = book.get();
        res.setStatus("deleted");
        bookRepository.save(res);
        return res.getStatus();
    }

    @Override
    public Boolean borrowBook(String id){
        Optional<Book> book = bookRepository.findByIdAndStatus(id, "available");
        if(!book.isPresent()) {
            return false;
        }
        Book res = book.get();
        res.setStatus("issued");
        bookRepository.save(res);
        return true;
    }

    @Override
    public Boolean returnBook(String id){
        Optional<Book> book = bookRepository.findByIdAndStatus(id, "issued");
        if(!book.isPresent()) {
            return false;
        }
        Book res = book.get();
        res.setStatus("available");
        bookRepository.save(res);
        return true;
    }
}
