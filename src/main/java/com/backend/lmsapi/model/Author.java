package com.backend.lmsapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_author")
@Getter
@Setter
public class Author extends BaseEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "biography", nullable = false)
    private String biography;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "status", nullable = true )
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
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Author(){}
    public Author(String id, String name, String biography, String imgUrl, String status) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.imgUrl = imgUrl;
        this.status = status;
    }

}
