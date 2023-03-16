package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import android.widget.SearchView;

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
import java.util.Locale;

public class DiscoveryFragment extends ACCIFragment {

    // event views
    private RecyclerView rvCategories, rvPopular, rvRecommended, rvUpcoming, rvFiltered;
    private TextView searchText, noResults;
    List<Event> allEvents = new ArrayList<>();

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
        Event tempEvent;

        //Hide search content
        rvFiltered = view.findViewById(R.id.rv_search_results);
        rvFiltered.setVisibility(View.GONE);
        searchText = view.findViewById(R.id.tv_search_results);
        searchText.setVisibility(View.GONE);
        noResults = view.findViewById(R.id.no_search_results);
        noResults.setVisibility(View.GONE);

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
        List<Event> upcomingList = new ArrayList<>();

        tempEvent = new Event("golf with friends");
        popEventList.add(tempEvent);
        upcomingList.add(tempEvent);
        allEvents.add(tempEvent);

        tempEvent = new Event("music in the park");
        popEventList.add(tempEvent);
        upcomingList.add(tempEvent);
        allEvents.add(tempEvent);

        tempEvent = new Event("game night");
        popEventList.add(tempEvent);
        upcomingList.add(tempEvent);
        allEvents.add(tempEvent);

        EventAdapter popularEventsAdapter = new EventAdapter(popEventList, R.layout.item_event);
        rvPopular.setAdapter(popularEventsAdapter);

        // Recommended Events
        rvRecommended = view.findViewById(R.id.rv_recommended_events);
        //rvRecommended.setLayoutManager(new LinearLayoutManager(this));
        List<Event> recommendedList = new ArrayList<>();
        tempEvent = new Event("shuffle board");
        recommendedList.add(tempEvent);
        allEvents.add(tempEvent);

        tempEvent = new Event("bird watching");
        recommendedList.add(tempEvent);
        allEvents.add(tempEvent);

        tempEvent = new Event("Complaining");
        recommendedList.add(tempEvent);
        allEvents.add(tempEvent);

        EventAdapter recommendedEventsAdapter = new EventAdapter(recommendedList, R.layout.item_event);
        rvRecommended.setAdapter(recommendedEventsAdapter);

        // Upcoming Events
        rvUpcoming = view.findViewById(R.id.rv_upcoming_events);
        //rvUpcoming.setLayoutManager(new LinearLayoutManager(this));
//        List<Event> upcomingList = new ArrayList<>();
//        upcomingList.add(new Event("golf with friends"));
//        upcomingList.add(new Event("music in the park"));
//        upcomingList.add(new Event("game night"));
        EventAdapter upcomingEventsAdapter = new EventAdapter(upcomingList, R.layout.item_event);
        rvUpcoming.setAdapter(upcomingEventsAdapter);


        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //rvFiltered = view.findViewById(R.id.rv_search_results);
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                //rvFiltered.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                List<Event> filtered = new ArrayList<Event>();

                if(!newText.equals("")) {
                    rvFiltered.setVisibility(View.VISIBLE);
                    searchText.setVisibility(View.VISIBLE);

                    for (Event event : allEvents) {
                        if (event.getTitle().toLowerCase().contains(newText)) {
                            filtered.add(event);
                        }
                    }

                    EventAdapter filteredEvents = new EventAdapter(filtered, R.layout.item_event);
                    rvFiltered.setAdapter(filteredEvents);

                    if(filtered.size() != 0) {
                        noResults.setVisibility(View.GONE);
                    }
                    else
                    {
                        noResults.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    rvFiltered.setVisibility(View.GONE);
                    searchText.setVisibility(View.GONE);
                    noResults.setVisibility(View.GONE);
                }

                return true;
            }
        });
    }

    // Event handlers for each card click
    final private EventCategoryAdapter.OnItemClickListener categoryClick = new EventCategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(EventCategory eventCategory) {

        }
    };
}