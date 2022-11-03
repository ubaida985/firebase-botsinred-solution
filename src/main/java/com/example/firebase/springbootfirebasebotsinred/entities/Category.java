package com.example.firebase.springbootfirebasebotsinred.entities;

import java.util.HashMap;
import java.util.Objects;

public class Category {

    String categoryName;
    HashMap<String, Integer> pills;
    public Category() {
    }

    public Category(String categoryName, HashMap<String, Integer> pills) {
        this.categoryName = categoryName;
        this.pills = pills;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public HashMap<String, Integer> getPills() {
        return pills;
    }

    public void setPills(HashMap<String, Integer> pills) {
        this.pills = pills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryName.equals(category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

    @Override
    public String toString() {
        return "{" +
                "categoryName:\"" + categoryName + "\"" +
                ", pills:\"" + pills.toString() +
                "\"}";
    }
}
