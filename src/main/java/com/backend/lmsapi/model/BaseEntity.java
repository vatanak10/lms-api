package com.backend.lmsapi.model;

import java.util.Date;

import javax.persistence.Column;

public class BaseEntity {
    
    @Column(name = "created_date", nullable = true)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Column(name = "created_by", nullable = true)
    private String createdBy;

    @Column(name = "modified_by", nullable = true)
    private String modifiedBy;

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
