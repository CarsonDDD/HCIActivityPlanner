package com.carson.eventplanner.presentation;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.EventCategory;
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.EventCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    // event views
    private RecyclerView rvCategories, rvPopular, rvRecommended, rvUpcoming;

    private RecyclerView rvDrawerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add menu to toolbar
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // set up Hamburger drawer. Icon changing should be done here too
        rvDrawerMenu = findViewById(R.id.rv_drawer_menu);
        rvDrawerMenu.setLayoutManager(new LinearLayoutManager(this));
        List<String> drawerItems = new ArrayList<>();
        drawerItems.add("Settings");
        drawerItems.add("Help");
        drawerItems.add("Feedback");
        DrawerMenuAdapter drawerMenuAdapter = new DrawerMenuAdapter(drawerItems, menuClick);
        rvDrawerMenu.setAdapter(drawerMenuAdapter);

        // Set up the event categories
        rvCategories = findViewById(R.id.rv_event_categories);
        //rvEventCategories.setLayoutManager(new LinearLayoutManager(this));
        List<EventCategory> eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory("Category 1"));
        eventCategories.add(new EventCategory("Category 2"));
        eventCategories.add(new EventCategory("Category 3"));
        EventCategoryAdapter eventCategoryAdapter = new EventCategoryAdapter(eventCategories);
        rvCategories.setAdapter(eventCategoryAdapter);

        // Popular events
        rvPopular = findViewById(R.id.rv_popular_events);
        //rvPopular.setLayoutManager(new LinearLayoutManager(this));
        List<Event> popEventList = new ArrayList<>();
        popEventList.add(new Event("golf with friends"));
        popEventList.add(new Event("music in the park"));
        popEventList.add(new Event("game night"));
        EventAdapter popularEventsAdapter = new EventAdapter(popEventList);
        rvPopular.setAdapter(popularEventsAdapter);

        // Recommended Events
        rvRecommended = findViewById(R.id.rv_recommended_events);
        //rvRecommended.setLayoutManager(new LinearLayoutManager(this));
        List<Event> recommendedList = new ArrayList<>();
        recommendedList.add(new Event("shuffle board"));
        recommendedList.add(new Event("bird watching"));
        recommendedList.add(new Event("Complaining"));
        EventAdapter recommendedEventsAdapter = new EventAdapter(recommendedList);
        rvRecommended.setAdapter(recommendedEventsAdapter);

        // Upcoming Events
        rvUpcoming = findViewById(R.id.rv_upcoming_events);
        //rvUpcoming.setLayoutManager(new LinearLayoutManager(this));
        List<Event> upcomingList = new ArrayList<>();
        upcomingList.add(new Event("golf with friends"));
        upcomingList.add(new Event("music in the park"));
        upcomingList.add(new Event("game night"));
        EventAdapter upcomingEventsAdapter = new EventAdapter(upcomingList);
        rvUpcoming.setAdapter(upcomingEventsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Set up the search bar
        // searchItem is null. Find a fix
        /*MenuItem searchItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle query submission
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle query text change
                return false;
            }
        });*/
        return true;
    }

    // Event handlers for each card click
    final private EventCategoryAdapter.OnItemClickListener categoryClick = new EventCategoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(EventCategory eventCategory) {

        }
    };

    final private DrawerMenuAdapter.OnItemClickListener menuClick = new DrawerMenuAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {

        }
    };
}