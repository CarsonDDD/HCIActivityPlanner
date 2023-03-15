package com.carson.eventplanner.presentation;

import androidx.fragment.app.Fragment;

// Dirty way to get parent reference. Dont know how to do this with pre existing android studio things
// Copy from soft eng
public abstract class ACCIFragment extends Fragment{


    // Reference to the app itself for 2 way communication between the fragment and the holder
    private final MainActivity mainActivity;

    public ACCIFragment(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    // Returns the AppCompact holding the fragment
    protected MainActivity getAppCompact(){
        return mainActivity;
    }
}
