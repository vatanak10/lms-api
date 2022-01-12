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

    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "issue_date", nullable = false)
    private Date issueDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "status", nullable = false)
    private String status;

    public IssueBook(){}
    public IssueBook(String id, String bookId, String bookTitle, String userId, String userName, Date issueDate, Date returnDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.userId = userId;
        this.userName = userName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
