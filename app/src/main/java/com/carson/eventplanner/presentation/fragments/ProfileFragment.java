package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;

import java.util.List;

public class ProfileFragment extends ACCIFragment {

    public ProfileFragment(MainActivity mainActivity) {
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar), R.menu.menu_add_event);

        // User Events
        RecyclerView rvCreated = view.findViewById(R.id.rv_created_events);
        rvCreated.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userCreatedEvents = getAppCompact().getActiveUser().getCreatedEvents();
        EventAdapter myEventsAdapter = new EventAdapter(userCreatedEvents, R.layout.item_event_alt, getAppCompact().CLICK_EVENT);
        rvCreated.setAdapter(myEventsAdapter);

        // Joined events
        RecyclerView rvJoined = view.findViewById(R.id.rv_joined_events);
        rvJoined.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userJoinedEvents = getAppCompact().getActiveUser().getJoinedEvents();
        EventAdapter joinedEventsAdapter = new EventAdapter(userJoinedEvents, R.layout.item_event_alt, getAppCompact().CLICK_EVENT);
        rvJoined.setAdapter(joinedEventsAdapter);

        // Bookmarked
        RecyclerView rvBookmarked = view.findViewById(R.id.rv_bookmarked_events);
        rvBookmarked.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        List<Event> userBookedmarkedEvents = getAppCompact().getActiveUser().getBookMarks();
        EventAdapter BookmarkedEventsAdapter = new EventAdapter(userBookedmarkedEvents, R.layout.item_event_alt, getAppCompact().CLICK_EVENT);
        rvBookmarked.setAdapter(BookmarkedEventsAdapter);
    }
}