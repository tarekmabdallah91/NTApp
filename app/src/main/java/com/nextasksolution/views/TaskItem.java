package com.nextasksolution.views;

public class TaskItem {

    private String title;
    private String id;
    private String date;
    private String status;
    private String type;

    public TaskItem() {
    }

    public TaskItem(String title, String id, String date, String status, String type) {
        this.title = title;
        this.id = id;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
