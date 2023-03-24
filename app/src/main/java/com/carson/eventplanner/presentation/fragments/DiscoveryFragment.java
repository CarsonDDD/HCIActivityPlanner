package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends Fragment {
    RecyclerView rvFiltered;
    TextView searchText;
    TextView noResults;
    
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
        View view =  inflater.inflate(R.layout.fragment_discovery, container, false);



        //Hide search content
        rvFiltered = view.findViewById(R.id.rv_search_results);
        rvFiltered.setVisibility(View.GONE);
        searchText = view.findViewById(R.id.tv_search_results);
        searchText.setVisibility(View.GONE);
        noResults = view.findViewById(R.id.no_search_results);
        noResults.setVisibility(View.GONE);
        
        
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
                        break;
                    case R.id.action_addevent:
                        Toast.makeText(getContext(), "Add Event!", Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).changeFragment(new CreateEventFragment());
                        break;
                }
                return true;
            }
        });

        ((MainActivity)getActivity()).addHamburger(toolbar);

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

                    for (Event event : ((MainActivity)getActivity()).allEvents) {
                        if (event.getTitle().toLowerCase().contains(newText)) {
                            filtered.add(event);
                        }
                    }

                    EventAdapter filteredEvents = new EventAdapter(filtered, R.layout.item_event, ((MainActivity)getActivity()).CLICK_EVENT);
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

        return view;
    }

    // Event handlers for each card click
    final private EventCategoryAdapter.OnItemClickListener categoryClick = new EventCategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(EventCategory eventCategory) {

        }
    };
}