package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;

import java.util.List;

public class EventListFragment extends Fragment {

    private RecyclerView rvMyEvent, rvJoinedEvents;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // inflate toolbar with menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_event, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myevents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        // User Events
        rvMyEvent = view.findViewById(R.id.rv_myevents);
        rvMyEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*List<Event> myEvents = new ArrayList<>();
        myEvents.add(new Event("golf with friends"));
        myEvents.add(new Event("music in the park"));
        myEvents.add(new Event("game night"));*/
        List<Event> userCreatedEvents = ((MainActivity)getActivity()).getActiveUser().getCreatedEvents();
        EventAdapter myEventsAdapter = new EventAdapter(userCreatedEvents, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvMyEvent.setAdapter(myEventsAdapter);

        // Joined events
        rvJoinedEvents = view.findViewById(R.id.rv_joinedevents);
        rvJoinedEvents.setLayoutManager(new LinearLayoutManager((getActivity())));
        /*List<Event> joinedEvents = new ArrayList<>();
        joinedEvents.add(new Event("Event 1"));
        joinedEvents.add(new Event("Event 2"));
        joinedEvents.add(new Event("Event 3"));*/
        List<Event> userJoinedEvents = ((MainActivity)getActivity()).getActiveUser().getJoinedEvents();
        EventAdapter joinedEventsAdapter = new EventAdapter(userJoinedEvents, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvJoinedEvents.setAdapter(joinedEventsAdapter);
    }

}