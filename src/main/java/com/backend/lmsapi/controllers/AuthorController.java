package com.backend.lmsapi.controllers;

import com.backend.lmsapi.dto.AuthorDto;
import com.backend.lmsapi.dto.ResponseAuthor;
import com.backend.lmsapi.services.AuthorService;

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
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public ResponseEntity<?> getAllAuthor(){
        return new ResponseEntity<>(authorService.getAllAuthor(), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAuthor(@RequestParam String id) {
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.addAuthor(authorDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateAuthor(@RequestBody ResponseAuthor responseAuthor) {
        return new ResponseEntity<>(authorService.updateAuthor(responseAuthor), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@RequestParam String id){
        return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.OK);
    }
}
