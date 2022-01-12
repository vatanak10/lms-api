package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.lmsapi.dto.IssueBookDto;
import com.backend.lmsapi.model.Book;
import com.backend.lmsapi.model.IssueBook;
import com.backend.lmsapi.repositories.BookRepository;
import com.backend.lmsapi.repositories.IssueBookRepository;
import com.backend.lmsapi.services.IssueBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueBookServiceDef implements IssueBookService{
    @Autowired
    private IssueBookRepository issueBookRepository;
    private BookRepository bookRepository;

    @Override
    public List<IssueBook> getAllIssueBook() {
        List<IssueBook> issueBooks = issueBookRepository.findAllByStatus("not return");
        List<IssueBook> responseIssueBooks = new ArrayList<>();
        for (IssueBook issueBook: issueBooks){
            responseIssueBooks.add(new IssueBook(
                issueBook.getId(),
                issueBook.getBookId(),
                issueBook.getBookTitle(),
                issueBook.getUserId(),
                issueBook.getUserName(),
                issueBook.getIssueDate(),
                issueBook.getReturnDate(),
                issueBook.getStatus()
            ));
        }
        return responseIssueBooks;
    }
    
    public IssueBook getIssueBook(String id){
        Optional<IssueBook> isIssue = issueBookRepository.findById(id);
        if(!isIssue.isPresent()){
            return null;
        }
        IssueBook yesIssue = isIssue.get();
        return new IssueBook(yesIssue.getId(),yesIssue.getBookId(),yesIssue.getBookId(),yesIssue.getUserId(),yesIssue.getUserName(),yesIssue.getIssueDate(),yesIssue.getReturnDate(),yesIssue.getStatus());     
    }

    @Override
    public IssueBook addIssueBook(IssueBookDto issueBookDto){
        // Optional<Book> isBook = bookRepository.findByIdAndStatus(issueBookDto.getBookId(), "available");
        // if(!isBook.isPresent()) {
        //     return null;
        // }
        // Book book = isBook.get();

        IssueBook issueBook = new IssueBook(UUID.randomUUID().toString(),issueBookDto.getBookId(),"Book Name",issueBookDto.getUserId(),issueBookDto.getUserName(),issueBookDto.getIssueDate(),issueBookDto.getReturnDate(),"issued");
        return issueBookRepository.save(issueBook);
    }

    @Override
    public String deleteIssueBook(String id) {
        Optional<IssueBook> issueBook = issueBookRepository.findById(id);
        if(!issueBook.isPresent()) {
            return "Issue Book cannot found";
        }
        IssueBook res = issueBook.get();
        res.setStatus("returned");
        issueBookRepository.save(res);
        return res.getStatus();
    
    }
}
