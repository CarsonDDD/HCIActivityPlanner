package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.SearchView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.EventCategory;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.EventCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    // inflate toolbar with menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_discovery, container, false);

        // Set up the event categories
        RecyclerView rvCategories = view.findViewById(R.id.rv_event_categories);
        List<EventCategory> eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory("Concerts"));
        eventCategories.add(new EventCategory("Outdoors"));
        eventCategories.add(new EventCategory("Creative"));
        eventCategories.add(new EventCategory("Learning"));
        eventCategories.add(new EventCategory("Dinner and Show"));
        EventCategoryAdapter eventCategoryAdapter = new EventCategoryAdapter(eventCategories);
        rvCategories.setAdapter(eventCategoryAdapter);

        // set up events
        // Random selection from list
        List<Event> popEventList = ((MainActivity)getActivity()).allEvents.subList(0,4);

        List<Event> upcomingList = ((MainActivity)getActivity()).allEvents.subList(0,4);

        List<Event> recommendedList = ((MainActivity)getActivity()).allEvents.subList(3,7);


        RecyclerView rvPopular = view.findViewById(R.id.rv_popular_events);
        EventAdapter popularEventsAdapter = new EventAdapter(popEventList, R.layout.item_event, ((MainActivity)getActivity()).CLICK_EVENT);
        rvPopular.setAdapter(popularEventsAdapter);

        RecyclerView rvRecommended = view.findViewById(R.id.rv_recommended_events);
        EventAdapter recommendedEventsAdapter = new EventAdapter(recommendedList, R.layout.item_event, ((MainActivity)getActivity()).CLICK_EVENT);
        rvRecommended.setAdapter(recommendedEventsAdapter);

        // Upcoming Events
        RecyclerView rvUpcoming = view.findViewById(R.id.rv_upcoming_events);
        EventAdapter upcomingEventsAdapter = new EventAdapter(upcomingList, R.layout.item_event, ((MainActivity)getActivity()).CLICK_EVENT);
        rvUpcoming.setAdapter(upcomingEventsAdapter);

        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_notifications:
                        Toast.makeText(getContext(), "Notifications", Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).changeFragment(new InvitesFragment());

                        break;
                    case R.id.action_addevent:
                        Toast.makeText(getContext(), "Add Event!", Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).changeFragment(new CreateEventFragment());
                        break;
                }
                return true;
            }
        });

        return view;
    }

    // Event handlers for each card click
    final private EventCategoryAdapter.OnItemClickListener categoryClick = new EventCategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(EventCategory eventCategory) {

        }
    };
}