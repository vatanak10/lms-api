package com.backend.lmsapi.controllers;

import com.backend.lmsapi.dto.BookDto;
import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<?> getAllBook() {
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getBook(@RequestParam String id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<?> updateBook(@RequestBody ResponseBook responseBook) {
        return new ResponseEntity<>(bookService.updateBook(responseBook), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam String id){
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
