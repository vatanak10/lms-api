package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.lmsapi.dto.IssueBookDto;
import com.backend.lmsapi.dto.ResponseBook;
import com.backend.lmsapi.model.IssueBook;
import com.backend.lmsapi.repositories.IssueBookRepository;
import com.backend.lmsapi.services.BookService;
import com.backend.lmsapi.services.IssueBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueBookServiceDef implements IssueBookService{
    @Autowired
    private IssueBookRepository issueBookRepository;
    @Autowired
    private BookService bookService;

    @Override
    public List<IssueBook> getAllIssueBook() {
        List<IssueBook> issueBooks = issueBookRepository.findAllByStatus("issued");
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
        bookService.borrowBook(issueBookDto.getBookId());
        ResponseBook book = bookService.getBook(issueBookDto.getBookId());
        IssueBook issueBook = new IssueBook(UUID.randomUUID().toString(),issueBookDto.getBookId(),book.getTitle(),issueBookDto.getUserId(),issueBookDto.getUserName(),issueBookDto.getIssueDate(),issueBookDto.getReturnDate(),book.getStatus());
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
        bookService.returnBook(res.getBookId());
        return res.getStatus();
    }
}
