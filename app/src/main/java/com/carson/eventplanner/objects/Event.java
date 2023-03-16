package com.carson.eventplanner.objects;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private boolean isPublic;

    private List<User> organizers;
    private List<User> attendees;

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

        organizers = new ArrayList<>();
        attendees = new ArrayList<>();
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

    public void addOrganizer(User person){
        organizers.add(person);
        person.getCreatedEvents().add(this);
    }

    public List<User> getOrganizers(){
        return organizers;
    }

    public void createEvent(List<User> eventCreators){
        for(User user : eventCreators){
            user.createEvent(this);
            organizers.add(user);
        }
    }

    public void createEvent(User creator){
        List<User> temp = new ArrayList<>();
        temp.add(creator);
        createEvent(temp);
    }

    public void addAttendee(User person){
        attendees.add(person);
        person.getJoinedEvents().add(this);
    }

    public List<User> getAttendees(){
        return attendees;
    }



    /*public int getImageResource() {
        return 0;
    }*/
}
