package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.ACCIFragment;
import com.carson.eventplanner.presentation.MainActivity;

public class CreateEventFragment extends ACCIFragment {

    public CreateEventFragment(MainActivity mainActivity) {
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
        return inflater.inflate(R.layout.fragment_create_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getAppCompact().setToolbar(view.findViewById(R.id.toolbar), R.menu.menu_escape, false);

        // Publish logic.
        // Grab all input from display and create event
        Button publish = view.findViewById(R.id.btn_publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Scan layout
                // Create event
                // Add event to active user

                //Get user inputted text fields
                EditText titleText = getView().findViewById(R.id.et_title);
                EditText dateText = getView().findViewById(R.id.et_date);
                EditText timeText = getView().findViewById(R.id.et_time);
                EditText locText = getView().findViewById(R.id.et_location);
                EditText descText = getView().findViewById(R.id.et_description);
                ToggleButton publicSwitch = getView().findViewById(R.id.tb_public);

                String title = titleText.getText().toString();
                String date = dateText.getText().toString();
                String time = timeText.getText().toString();
                String location = locText.getText().toString();
                String desc = descText.getText().toString();
                boolean isPublic = publicSwitch.isChecked();

                // TODO: TBA CHECK HERE
                // CURRENTLY THERE IS NO TBA CheckBox Check

                // Check validity
                if(title.isEmpty()){
                    Toast.makeText(getAppCompact(), "Invalid event name", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add event to user
                Event createdEvent = new Event(title, date, time, location, desc, isPublic);
                createdEvent.createEvent(getAppCompact().getActiveUser());

                // CLOSE OUT OF SCREEN
                getAppCompact().switchFragment(new EventListFragment(getAppCompact()));
            }
        });
    }

}