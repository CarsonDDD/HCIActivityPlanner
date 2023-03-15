package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carson.eventplanner.R;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;

public class FriendsFragment extends ACCIFragment {

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
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar), R.menu.menu_plus);
    }
}