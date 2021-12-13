package com.backend.lmsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBook {

    private String id;
    private String title;
    private String author;
    private String imgUrl;
    

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
    
    public ResponseBook() {}
    public ResponseBook(String id, String title, String author, String imgUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
    }
    
    
}
