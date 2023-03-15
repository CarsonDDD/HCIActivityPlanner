package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
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
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.EventCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends ACCIFragment {

    // event views
    private RecyclerView rvCategories, rvPopular, rvRecommended, rvUpcoming;

    public DiscoveryFragment(MainActivity mainActivity) {
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
        return inflater.inflate(R.layout.fragment_discovery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        getAppCompact().setToolbar(view.findViewById(R.id.toolbar));

        // Set up the event categories
        rvCategories = view.findViewById(R.id.rv_event_categories);
        List<EventCategory> eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory("Category 1"));
        eventCategories.add(new EventCategory("Category 2"));
        eventCategories.add(new EventCategory("Category 3"));
        EventCategoryAdapter eventCategoryAdapter = new EventCategoryAdapter(eventCategories);
        rvCategories.setAdapter(eventCategoryAdapter);

        // Popular events
        rvPopular = view.findViewById(R.id.rv_popular_events);
        //rvPopular.setLayoutManager(new LinearLayoutManager(this));
        List<Event> popEventList = new ArrayList<>();
        popEventList.add(new Event("golf with friends"));
        popEventList.add(new Event("music in the park"));
        popEventList.add(new Event("game night"));
        EventAdapter popularEventsAdapter = new EventAdapter(popEventList);
        rvPopular.setAdapter(popularEventsAdapter);

        // Recommended Events
        rvRecommended = view.findViewById(R.id.rv_recommended_events);
        //rvRecommended.setLayoutManager(new LinearLayoutManager(this));
        List<Event> recommendedList = new ArrayList<>();
        recommendedList.add(new Event("shuffle board"));
        recommendedList.add(new Event("bird watching"));
        recommendedList.add(new Event("Complaining"));
        EventAdapter recommendedEventsAdapter = new EventAdapter(recommendedList);
        rvRecommended.setAdapter(recommendedEventsAdapter);

        // Upcoming Events
        rvUpcoming = view.findViewById(R.id.rv_upcoming_events);
        //rvUpcoming.setLayoutManager(new LinearLayoutManager(this));
        List<Event> upcomingList = new ArrayList<>();
        upcomingList.add(new Event("golf with friends"));
        upcomingList.add(new Event("music in the park"));
        upcomingList.add(new Event("game night"));
        EventAdapter upcomingEventsAdapter = new EventAdapter(upcomingList);
        rvUpcoming.setAdapter(upcomingEventsAdapter);

    }

    // Event handlers for each card click
    final private EventCategoryAdapter.OnItemClickListener categoryClick = new EventCategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(EventCategory eventCategory) {

        }
    };
}