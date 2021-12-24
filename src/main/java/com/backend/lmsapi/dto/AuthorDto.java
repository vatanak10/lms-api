package com.backend.lmsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private String name;
    private String biography;
    private String imgUrl;
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
    public AuthorDto(){}
    public AuthorDto(String name, String biography, String imgUrl) {
        this.name = name;
        this.biography = biography;
        this.imgUrl = imgUrl;
    } 
    
}
