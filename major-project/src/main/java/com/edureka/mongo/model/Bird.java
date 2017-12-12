package com.edureka.mongo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class has features of Bird.
 * 
 * @author raghunandanG
 *
 */
@Document
public class Bird implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private Integer age;

    private String color;

    private Boolean visible = false;

    private Date added = new Date();

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Bird() {

    }

    @Override
    public String toString() {
        return "Bird [id=" + id + ", name=" + name + ", age=" + age + ", color=" + color + "]";
    }

    public Bird(String id, String name, Integer age, String color) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bird other = (Bird) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

}
