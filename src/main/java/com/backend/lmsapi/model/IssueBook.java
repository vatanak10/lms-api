package com.backend.lmsapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_issuebook")
@Getter
@Setter
public class IssueBook extends BaseEntity implements Serializable{
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bookId", nullable = false)
    private String bookId;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Column(name = "issueDate", nullable = false)
    private Date issueDate;

    @Column(name = "returnDate", nullable = false)
    private Date returnDate;

    @Column(name = "status", nullable = true)
    private String status;


    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



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



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public IssueBook(){}

    public IssueBook(String id, String name, String bookId, String bookName, Date issueDate, Date returnDate,
            String status) {
        this.id = id;
        this.name = name;
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    
}
