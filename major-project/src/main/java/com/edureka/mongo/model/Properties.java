package com.edureka.mongo.model;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class Properties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String family;
    private String[] continents;
    private String added;
    private Boolean visible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String[] getContinents() {
        return continents;
    }

    public void setContinents(String[] continents) {
        this.continents = continents;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Properties [id=" + id + ", name=" + name + ", family=" + family + ", continents="
                + Arrays.toString(continents) + ", added=" + added + ", visible=" + visible + "]";
    }

}
