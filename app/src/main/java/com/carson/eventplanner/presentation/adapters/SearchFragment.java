package com.carson.eventplanner.presentation.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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
import com.carson.eventplanner.presentation.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    RecyclerView rvResults;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // inflate toolbar with menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        rvResults = view.findViewById(R.id.rv_search_results);
        rvResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Event> events = ((MainActivity)getActivity()).allEvents;
        EventAdapter eventAdapter = new EventAdapter(events, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
        rvResults.setAdapter(eventAdapter);

        SearchView searchView = view.findViewById(R.id.sv_event_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                List<Event> filtered = new ArrayList<Event>();

                for(Event event : eventAdapter.getEvents()){
                    if (event.getTitle().toLowerCase().contains(newText)) {
                        filtered.add(event);
                    }
                }

                EventAdapter filteredAdapter = new EventAdapter(filtered, R.layout.item_event_alt, ((MainActivity)getActivity()).CLICK_EVENT);
                rvResults.setAdapter(filteredAdapter);
                return true;
            }
        });
    }


}