package com.backend.lmsapi.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String description;
    private String genre;
    private String author;
    private String imgUrl;
    private Date publishedDate;
    
    public BookDto() {}
    public BookDto(String title,String description, String genre, String author, String imgUrl, Date publishedDate){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.author = author;
        this.imgUrl = imgUrl;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public Date getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }   
}
