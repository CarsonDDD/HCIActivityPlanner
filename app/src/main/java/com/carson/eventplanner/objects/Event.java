package com.carson.eventplanner.objects;

public class Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private boolean isPublic;

    // Image later


    public Event(String title) {
        this(title,"TBA","TBA","TBA","An Event!", true);
    }

    public Event(String title, String date, String time, String location, String description, boolean isPublic){
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.isPublic = isPublic;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    /*public int getImageResource() {
        return 0;
    }*/
}
