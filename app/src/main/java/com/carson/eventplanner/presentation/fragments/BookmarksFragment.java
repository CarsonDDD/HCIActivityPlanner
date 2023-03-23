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
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;

public class BookmarksFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmarks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        ((MainActivity)getActivity()).addHamburger(view.findViewById(R.id.toolbar));

        // Organizers
        RecyclerView events = view.findViewById(R.id.rv_events);
        events.setLayoutManager(new LinearLayoutManager(getActivity()));
        EventAdapter eventInvitationAdapter = new EventAdapter( ((MainActivity)getActivity()).getActiveUser().getBookMarks(), R.layout.item_event_alt,  ((MainActivity)getActivity()).CLICK_EVENT);
        events.setAdapter(eventInvitationAdapter);
    }
}