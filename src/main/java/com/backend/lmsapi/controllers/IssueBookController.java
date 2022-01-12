package com.backend.lmsapi.controllers;

import com.backend.lmsapi.dto.IssueBookDto;
import com.backend.lmsapi.services.IssueBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue-book")
public class IssueBookController {
    @Autowired
    private IssueBookService issueBookService;

    @GetMapping()
    public ResponseEntity<?> getAllIssueBook(){
        return new ResponseEntity<>(issueBookService.getAllIssueBook(), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getIssueBook(@RequestParam String id) {
        return new ResponseEntity<>(issueBookService.getIssueBook(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addIssueBook(@RequestBody IssueBookDto issueBookDto) {
        return new ResponseEntity<>(issueBookService.addIssueBook(issueBookDto), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteIssueBook(@RequestParam String id){
        return new ResponseEntity<>(issueBookService.deleteIssueBook(id), HttpStatus.OK);
    }
}
