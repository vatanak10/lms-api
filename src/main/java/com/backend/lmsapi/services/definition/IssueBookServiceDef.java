package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.lmsapi.dto.IssueBookDto;
import com.backend.lmsapi.dto.ResponseIssueBook;
import com.backend.lmsapi.model.IssueBook;
import com.backend.lmsapi.repositories.IssueBookRepository;
import com.backend.lmsapi.services.IssueBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueBookServiceDef implements IssueBookService{
    @Autowired
    private IssueBookRepository issueBookRepository;

    @Override
    public List<ResponseIssueBook> getAllIssueBook() {
        List<IssueBook> issueBooks = issueBookRepository.findAllByStatus("not return");
        List<ResponseIssueBook> responseIssueBooks = new ArrayList<>();
        for (IssueBook issueBook: issueBooks){
            responseIssueBooks.add(new ResponseIssueBook(
                issueBook.getId(),
                issueBook.getName(),
                issueBook.getBookId(),
                issueBook.getBookName(),
                issueBook.getIssueDate(),
                issueBook.getReturnDate(),
                issueBook.getStatus()
            ));
        }
        return responseIssueBooks;
    }
    
    public ResponseIssueBook getIssueBook(String id){
        Optional<IssueBook> isIssue = issueBookRepository.findById(id);
        if(!isIssue.isPresent()){
            return null;
        }
        IssueBook yesIssue = isIssue.get();
        return new ResponseIssueBook(yesIssue.getId(),yesIssue.getName(),yesIssue.getBookId(),yesIssue.getBookName(),yesIssue.getIssueDate(),yesIssue.getReturnDate(),yesIssue.getStatus());
        
    }

    @Override
    public IssueBook addIssueBook(IssueBookDto issueBookDto){
        IssueBook issueBook = new IssueBook(UUID.randomUUID().toString(), issueBookDto.getName(),issueBookDto.getBookId(),issueBookDto.getBookName(),issueBookDto.getIssueDate(),issueBookDto.getReturnDate(),"not return");
        return issueBookRepository.save(issueBook);
    }

    @Override
    public String deleteIssueBook(String id) {
        Optional<IssueBook> issueBook = issueBookRepository.findById(id);
        if(!issueBook.isPresent()) {
            return "Issue Book cannot found";
        }
        IssueBook res = issueBook.get();
        res.setStatus("deleted");
        issueBookRepository.save(res);
        return res.getStatus();
    
    }
}
