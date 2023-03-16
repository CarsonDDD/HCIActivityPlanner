package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.FriendAdapter;

import java.util.List;

public class EventFragment extends ACCIFragment {

    Event event;

    public EventFragment(MainActivity mainActivity, Event event) {
        super(mainActivity);
        this.event = event;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar));

        // Organizers
        RecyclerView rvOrgs = view.findViewById(R.id.rv_organizers);
        rvOrgs.setLayoutManager(new LinearLayoutManager(getAppCompact()));
        /*List<Event> myEvents = new ArrayList<>();
        myEvents.add(new Event("golf with friends"));
        myEvents.add(new Event("music in the park"));
        myEvents.add(new Event("game night"));*/
        List<User> organizers = event.getOrganizers();
        FriendAdapter orgAdapter = new FriendAdapter(organizers);
        rvOrgs.setAdapter(orgAdapter);


        TextView tvDate = view.findViewById(R.id.tv_date);
        tvDate.setText(event.getDate());

        TextView tvTime = view.findViewById(R.id.tv_time);
        tvTime.setText(event.getTime());

        TextView tvLocation = view.findViewById(R.id.et_location);
        tvLocation.setText(event.getLocation());

        TextView tvDesciption = view.findViewById(R.id.tv_description);
        tvDesciption.setText(event.getDescription());

        RecyclerView rvAttendees = view.findViewById(R.id.rv_attendees);
        rvAttendees.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        FriendAdapter attendeeAdapter = new FriendAdapter(event.getAttendees());
        rvAttendees.setAdapter(attendeeAdapter);


    }
}