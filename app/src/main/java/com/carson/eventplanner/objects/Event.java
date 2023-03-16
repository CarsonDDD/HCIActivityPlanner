package com.carson.eventplanner.objects;

import androidx.annotation.Nullable;

public class Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private boolean isPublic;

    private User organizer;

    // Image later
    private final static String TBA = "TBA";

    public Event(String title) {
        this(title,"","","","", true);
    }

    public Event(String title, String date, String time, String location, String description, boolean isPublic){
        if(title.isEmpty())
            this.title = "Created Event";
        else
            this.title = title;

        if(date.isEmpty())
            this.date = TBA;
        else
            this.date = date;

        if(time.isEmpty())
            this.time = TBA;
        else
            this.time = time;

        if(location.isEmpty())
            this.location = TBA;
        else
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

    public void setOrganizer(User organizer){
        this.organizer = organizer;
    }

    @Nullable
    public User getOrganizer(){
        return organizer;
    }

    public void createEvent(User organizer){
        organizer.createEvent(this);
        this.organizer = organizer;
    }

    /*public int getImageResource() {
        return 0;
    }*/
}
