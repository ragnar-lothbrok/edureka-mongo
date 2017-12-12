package com.edureka.mongo.model;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    private String type;
    private String description;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
