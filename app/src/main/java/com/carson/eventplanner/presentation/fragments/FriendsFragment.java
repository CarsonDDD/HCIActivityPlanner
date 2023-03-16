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
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.FriendAdapter;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends ACCIFragment {

    private RecyclerView rvFriends;

    public FriendsFragment(MainActivity mainActivity) {
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
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar), R.menu.menu_add_friend);

        // Set up the event categories
        rvFriends = view.findViewById(R.id.rv_friends);
        rvFriends.setLayoutManager(new LinearLayoutManager(getAppCompact()));
        FriendAdapter eventInvitationAdapter = new FriendAdapter(getAppCompact().getActiveUser().getFriends());
        rvFriends.setAdapter(eventInvitationAdapter);
    }
}