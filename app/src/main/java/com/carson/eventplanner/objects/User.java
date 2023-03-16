package com.carson.eventplanner.objects;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    //private ImageView pfp;

    private List<User> friends;
    private List<Event> createdEvents;
    private List<Event> joinedEvents;
    private List<Event> invitations;

    public User(String userName) {
        this.userName = userName;
        friends = new ArrayList<User>();
        createdEvents = new ArrayList<Event>();
        joinedEvents = new ArrayList<Event>();
        invitations = new ArrayList<Event>();
    }

    public String getUserName() {
        return userName;
    }

    public void addFriend(User friend){
        friends.add(friend);
    }

    public void createEvent(Event event){
        event.setOrganizer(this);
        createdEvents.add(event);
    }

    public void joinEvent(Event event){
        joinedEvents.add(event);
    }

    public List<Event> getCreatedEvents(){
        return createdEvents;
    }

    public List<Event> getJoinedEvents(){
        return joinedEvents;
    }

    public List<Event> getInvitations(){
        return invitations;
    }
    /*public int getProfileImage() {
        return 0;
    }*/
}
