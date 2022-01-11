package com.backend.lmsapi.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueBookDto {
    private String name;
    private String bookId;
    private String bookName;
    private Date issueDate;
    private Date returnDate;

    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getBookId() {
        return bookId;
    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public Date getIssueDate() {
        return issueDate;
    }


    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }


    public Date getReturnDate() {
        return returnDate;
    }


    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


    public IssueBookDto(){}


    public IssueBookDto(String name, String bookId, String bookName, Date issueDate, Date returnDate) {
        this.name = name;
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
    
}
