package com.backend.lmsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAuthor {
    private String id;
    private String name;
    private String biography;
    private String imgUrl;
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
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
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ResponseAuthor(){}
    public ResponseAuthor(String id, String name, String biography, String imgUrl, String status) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    
}
