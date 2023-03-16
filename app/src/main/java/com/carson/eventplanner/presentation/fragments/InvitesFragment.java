package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.EventInvitation;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventInvitationAdapter;

import java.util.List;

public class InvitesFragment extends ACCIFragment {

    public InvitesFragment(MainActivity mainActivity) {
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
        return inflater.inflate(R.layout.fragment_invites, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar));

        RecyclerView rvInvites = view.findViewById(R.id.rv_invites);
        rvInvites.setLayoutManager(new LinearLayoutManager(getAppCompact()));
        /*List<EventInvitation> myEvents = new ArrayList<>();
        myEvents.add(new Event("golf with friends"));
        myEvents.add(new Event("music in the park"));
        myEvents.add(new Event("game night"));*/
        /*List<EventInvitation> userInvites = getAppCompact().getActiveUser().getInvites();
        EventInvitationAdapter eventInvitationAdapter = new EventInvitationAdapter(userInvites, R.layout.item_invite);
        rvInvites.setAdapter(eventInvitationAdapter);*/
    }
}