package com.edureka.mongo.utility;

import java.util.ArrayList;
import java.util.List;

public class PageSupportor<T> {

    List<T> items;
    private int startIndex;
    private int endIndex;
    private int totalRecords;
    private List<String> errors;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<String> getErrors() {
        if(this.errors == null)
            this.errors = new ArrayList<String>();
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "PageSupportor [items=" + items + ", startIndex=" + startIndex + ", endIndex=" + endIndex
                + ", totalRecords=" + totalRecords + ", errors=" + errors + "]";
    }

}
