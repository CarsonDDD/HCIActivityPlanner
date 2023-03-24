package com.carson.eventplanner.objects;

public class Invite {
    Event event;
    User sender;

    public Invite(Event event, User sender){
        this.event = event;
        this.sender = sender;
    }

    public Event getEvent() {
        return event;
    }

    public User getSender() {
        return sender;
    }
}
