package com.carson.eventplanner.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.carson.eventplanner.R;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.MainActivity;
import com.carson.eventplanner.presentation.adapters.FriendAdapter;

import java.util.List;

public class EventPageFragment extends Fragment {

    public Event event;

    public EventPageFragment(Event event) {
        this.event = event;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // inflate toolbar with menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_event, menu);

        // Starting condition for save icon
        if( ((MainActivity)getActivity()).getActiveUser().containsBookmark(event)){
            MenuItem myMenuItem = menu.findItem(R.id.action_save);
            myMenuItem.setIcon(R.drawable.ic_star_filled);
            myMenuItem.setChecked(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event, container, false);

        RecyclerView rvOrgs = view.findViewById(R.id.rv_organizers);
        rvOrgs.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
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

        TextView tvLocation = view.findViewById(R.id.tv_location);
        tvLocation.setText(event.getLocation());

        TextView tvDesciption = view.findViewById(R.id.tv_description);
        tvDesciption.setText(event.getDescription());

        RecyclerView rvAttendees = view.findViewById(R.id.rv_attendees);
        rvAttendees.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        FriendAdapter attendeeAdapter = new FriendAdapter(event.getAttendees());
        rvAttendees.setAdapter(attendeeAdapter);

        Button btnJoin = view.findViewById(R.id.btn_join);
        if(!((MainActivity)getActivity()).getActiveUser().getJoinedEvents().contains(event) && !((MainActivity)getActivity()).getActiveUser().getCreatedEvents().contains(event)){
            btnJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Joined Event!", Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).getActiveUser().joinEvent(event);
                    btnJoin.setVisibility(View.GONE);
                }
            });
        }
        else{
            btnJoin.setVisibility(View.GONE);
        }


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_escape:
                        // Change fragment back to frivolous, right now just always to same spot
                        ((MainActivity)getActivity()).undoFragment();
                        break;
                    case R.id.action_save:
                        //Close your eyes
                        Event currentEvent = event;
                        item.setChecked(!item.isChecked());
                        if (item.isChecked()) {
                            item.setIcon(R.drawable.ic_star_filled);
                            Toast.makeText(getContext(), "Bookmarked Event!", Toast.LENGTH_SHORT).show();

                            ((MainActivity)getActivity()).getActiveUser().bookMark(currentEvent);
                            // save the event
                        } else {
                            item.setIcon(R.drawable.ic_star_border);
                            Toast.makeText(getContext(), "Removed Bookmark.", Toast.LENGTH_SHORT).show();
                            ((MainActivity)getActivity()).getActiveUser().removeBookMark(currentEvent);
                            // remove the saved event
                        }
                        break;
                }
                return true;
            }
        });

        ((MainActivity)getActivity()).addHamburger(toolbar);

        return view;
    }
}