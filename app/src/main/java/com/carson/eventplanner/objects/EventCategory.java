package com.carson.eventplanner.objects;

public class EventCategory {
    private String title;
    public EventCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return "desc";
    }

    public int getImageResource() {
        return 0;
    }
}
