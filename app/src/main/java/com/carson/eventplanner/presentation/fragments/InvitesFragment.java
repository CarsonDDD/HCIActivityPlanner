package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.Invite;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.adapters.InviteAdapter;

import java.util.List;

public class InvitesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_escape, menu);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rvInvites = view.findViewById(R.id.rv_invites);
        rvInvites.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Invite> userInvites = ((MainActivity)getActivity()).getActiveUser().getInvitations();
        InviteAdapter eventAdapter = new InviteAdapter(userInvites, CLICK_EVENT);
        rvInvites.setAdapter(eventAdapter);
    }

    final public InviteAdapter.OnEventClickListener CLICK_EVENT = new InviteAdapter.OnEventClickListener() {
        @Override
        public void onItemClick(Invite invite) {
            ((MainActivity)getActivity()).changeFragment(new EventPageFragment(invite.getEvent()));
        }
    };
}