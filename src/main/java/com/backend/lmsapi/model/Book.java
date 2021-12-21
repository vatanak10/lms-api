package com.backend.lmsapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "created_date", nullable = true)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;
    
    public Book() {}
    public Book(String id, String title, String author, String imgUrl, String status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    public Book(String id, String title, String author, String imgUrl, String status, Date createdDate, Date modifiedDate){
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }    
}
