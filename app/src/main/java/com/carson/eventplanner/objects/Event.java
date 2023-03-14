package com.carson.eventplanner.objects;

public class Event {
    private String title;
    //private String date;

    public Event(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return "April 1, 2020";
    }

    public String getTime(){
        return "5pm";
    }

    /*public int getImageResource() {
        return 0;
    }*/
}
