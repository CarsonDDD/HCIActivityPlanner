package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.MainActivity;

public class CreateEventFragment extends Fragment {

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
        View view =  inflater.inflate(R.layout.fragment_create_event, container, false);
        // Publish logic.
        // Grab all input from display and create event
        Button publish = view.findViewById(R.id.btn_publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    Toast.makeText(getContext(), "Invalid event name", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add event to user
                Event createdEvent = new Event(title, date, time, location, desc, isPublic);
                createdEvent.createEvent( ((MainActivity)getActivity()).getActiveUser());

                // CLOSE OUT OF SCREEN
                ((MainActivity)getActivity()).changeFragment(new EventListFragment());
            }
        });

        // Toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_escape:
                        ((MainActivity)getActivity()).undoFragment();
                        break;
                }
                return true;
            }
        });

        ((MainActivity)getActivity()).addHamburger(toolbar);

        return view;
    }
}