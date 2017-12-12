package com.edureka.mongo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class BirdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String $schema;
    private String title;
    private String description;
    private Boolean additionalProperties;
    
    @DBRef
    @Field("properties")
    private Properties properties;

    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
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

    public Boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BirdBean [id=" + id + ", $schema=" + $schema + ", title=" + title + ", description=" + description
                + ", additionalProperties=" + additionalProperties + ", properties=" + properties + "]";
    }

}
