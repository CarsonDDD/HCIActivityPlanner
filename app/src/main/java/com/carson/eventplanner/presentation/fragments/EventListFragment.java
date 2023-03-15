package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.EventCategory;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.EventCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventListFragment extends ACCIFragment {

    private RecyclerView rvMyEvent, rvJoinedEvents;

    public EventListFragment(MainActivity mainActivity) {
        super(mainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myevents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar), R.menu.menu_add_event);

        rvMyEvent = view.findViewById(R.id.rv_myevents);
        rvMyEvent.setLayoutManager(new LinearLayoutManager(getAppCompact()));
        List<Event> myEvents = new ArrayList<>();
        myEvents.add(new Event("golf with friends"));
        myEvents.add(new Event("music in the park"));
        myEvents.add(new Event("game night"));
        EventAdapter myEventsAdapter = new EventAdapter(myEvents, R.layout.item_event_alt);
        rvMyEvent.setAdapter(myEventsAdapter);

        // Popular events
        rvJoinedEvents = view.findViewById(R.id.rv_joinedevents);
        rvJoinedEvents.setLayoutManager(new LinearLayoutManager(getAppCompact()));
        List<Event> joinedEvents = new ArrayList<>();
        joinedEvents.add(new Event("Event 1"));
        joinedEvents.add(new Event("Event 2"));
        joinedEvents.add(new Event("Event 3"));
        EventAdapter joinedEventsAdapter = new EventAdapter(joinedEvents, R.layout.item_event_alt);
        rvJoinedEvents.setAdapter(joinedEventsAdapter);


    }

}