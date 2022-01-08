package com.backend.lmsapi.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBook {

    private String id;
    private String title;
    private String genre;
    private String author;
    private String imgUrl;
    private String status;
    private Date publishedDate;


    public ResponseBook() {}
    public ResponseBook(String id, String title, String genre, String author, String imgUrl, String status, Date publishedDate) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.imgUrl = imgUrl;
        this.status = status;
        this.publishedDate = publishedDate;
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
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
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
    public Date getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
