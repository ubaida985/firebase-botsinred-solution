package com.example.firebase.springbootfirebasebotsinred.entities;

import java.util.*;

public class Schedule {

    String userID;
    String scheduleID;
    String time;
    String name;
    ArrayList<Category> categories;
    Date date;
    boolean completed = false;

    public Schedule() {
    }

    public Schedule(String time){
        time = "false";
    }

    public Schedule(String time, String name, ArrayList<Category> categories, Date date, boolean completed) {
        this.time = time;
        this.name = name;
        this.categories = categories;
        this.date = date;
        this.completed = completed;
    }

    public Schedule(String userID, String scheduleID, String time, String name, ArrayList<Category> categories, Date date, boolean completed) {
        this.userID = userID;
        this.scheduleID = scheduleID;
        this.time = time;
        this.name = name;
        this.categories = categories;
        this.date = date;
        this.completed = completed;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedules = (Schedule) o;
        return time.equals(schedules.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
