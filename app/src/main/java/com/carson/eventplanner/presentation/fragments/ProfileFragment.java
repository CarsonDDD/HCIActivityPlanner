package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;

import java.util.List;

public class ProfileFragment extends Fragment {
    User displayUser;
    boolean isLoggedInUser = true;
    public ProfileFragment(User user) {
        displayUser = user;
        //isLoggedInUser = displayUser.getUserName().equals(((MainActivity)getActivity()).getActiveUser().getUserName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // inflate toolbar with menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        // Only show menu options if its the current users profile.
        if(isLoggedInUser){
            inflater.inflate(R.menu.menu_add_event, menu);
        }
        else{
            // show back button on non current
            ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // User Events
        RecyclerView rvCreated = view.findViewById(R.id.rv_created_events);
        rvCreated.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userCreatedEvents = ((MainActivity)getActivity()).getActiveUser().getCreatedEvents();
        EventAdapter myEventsAdapter = new EventAdapter(userCreatedEvents, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvCreated.setAdapter(myEventsAdapter);

        // Joined events
        RecyclerView rvJoined = view.findViewById(R.id.rv_joined_events);
        rvJoined.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userJoinedEvents = ((MainActivity)getActivity()).getActiveUser().getJoinedEvents();
        EventAdapter joinedEventsAdapter = new EventAdapter(userJoinedEvents, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvJoined.setAdapter(joinedEventsAdapter);

        // Bookmarked
        RecyclerView rvBookmarked = view.findViewById(R.id.rv_bookmarked_events);
        rvBookmarked.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userBookedmarkedEvents = ((MainActivity)getActivity()).getActiveUser().getBookMarks();
        EventAdapter BookmarkedEventsAdapter = new EventAdapter(userBookedmarkedEvents, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvBookmarked.setAdapter(BookmarkedEventsAdapter);

        // Toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_addevent:
                        Toast.makeText(getContext(), "Add Event!", Toast.LENGTH_SHORT).show();
                        ((MainActivity)getActivity()).changeFragment(new CreateEventFragment());
                        break;
                    case R.id.action_calendar:
                        Toast.makeText(getContext(), "Calendar!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        ((MainActivity)getActivity()).addHamburger(toolbar);



        return view;
    }


}