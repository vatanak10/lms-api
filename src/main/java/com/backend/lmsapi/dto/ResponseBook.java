package com.backend.lmsapi.dto;

public class ResponseBook {

    private String id;
    private String title;
    private String author;
    private String img;

    public ResponseBook() {}
    public ResponseBook(String id, String title, String author, String img) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.img = img;
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
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
    
}
