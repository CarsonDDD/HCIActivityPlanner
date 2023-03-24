package com.carson.eventplanner.objects;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    //private ImageView pfp;

    private List<User> friends;
    private List<Event> createdEvents;
    private List<Event> joinedEvents;
    private List<Invite> invitations;
    private List<Event> bookMarks;

    public User(String userName) {
        this.userName = userName;
        friends = new ArrayList<User>();
        createdEvents = new ArrayList<Event>();
        joinedEvents = new ArrayList<Event>();
        invitations = new ArrayList<Invite>();
        bookMarks = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void addFriend(User friend){
        friends.add(friend);
    }

    public void createEvent(Event event){
        event.addOrganizer(this);
    }


    public List<Event> getCreatedEvents(){
        return createdEvents;
    }

    public List<Event> getJoinedEvents(){
        return joinedEvents;
    }

    public List<Invite> getInvitations(){
        return invitations;
    }

    public void joinEvent(Event event){
        joinedEvents.add(event);
        event.getAttendees().add(this);
    }

    public List<User> getFriends() {
        return friends;
    }

    public boolean containsBookmark(Event target){
        return bookMarks.contains(target);
    }

    public boolean bookMark(Event currentEvent) {
        if(!containsBookmark(currentEvent)){
            bookMarks.add(currentEvent);
            return true;
        }
        return false;
    }

    public boolean removeBookMark(Event currentEvent) {
        if(containsBookmark(currentEvent)){
            bookMarks.remove(currentEvent);
            return true;
        }
        return false;
    }

    public List<Event> getBookMarks() {
        return bookMarks;
    }

    public void invite(Event darts, User user) {
        user.invitations.add(new Invite(darts, this));
    }
    /*public int getProfileImage() {
        return 0;
    }*/
}
