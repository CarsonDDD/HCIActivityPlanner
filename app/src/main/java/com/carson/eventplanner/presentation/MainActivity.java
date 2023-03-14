package com.carson.eventplanner.presentation;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.carson.eventplanner.presentation.fragments.BookmarksFragment;
import com.carson.eventplanner.presentation.fragments.CalendarFragment;
import com.carson.eventplanner.presentation.fragments.DiscoveryFragment;
import com.carson.eventplanner.R;
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.fragments.FriendsFragment;
import com.carson.eventplanner.presentation.fragments.InvitesFragment;
import com.carson.eventplanner.presentation.fragments.ProfileFragment;
import com.carson.eventplanner.presentation.fragments.RecommendationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    private RecyclerView rvDrawerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set current fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new DiscoveryFragment());
        fragmentTransaction.commit();


        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add menu to toolbar
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // set up Hamburger drawer. Icon changing should be done here too
        rvDrawerMenu = findViewById(R.id.rv_drawer_menu);
        rvDrawerMenu.setLayoutManager(new LinearLayoutManager(this));
        List<String> drawerItems = new ArrayList<>();
        drawerItems.add("Home");
        drawerItems.add("Invites");
        drawerItems.add("Friends");
        drawerItems.add("Your Events");
        drawerItems.add("Bookmarks");
        drawerItems.add("Recommendations");
        drawerItems.add("Calendar");
        DrawerMenuAdapter drawerMenuAdapter = new DrawerMenuAdapter(drawerItems, menuClick);
        rvDrawerMenu.setAdapter(drawerMenuAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Set up the search bar
        // searchItem is null. Find a fix
        /*MenuItem searchItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle query submission
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle query text change
                return false;
            }
        });*/


        return true;
    }

    private void switchFragment(Fragment newFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, newFragment);
        fragmentTransaction.commit();

        // Highlight current drawer item

        drawerLayout.close();
    }

    final private DrawerMenuAdapter.OnItemClickListener menuClick = new DrawerMenuAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String id) {
            switch (id.toLowerCase()){
                case "home":
                    switchFragment(new DiscoveryFragment());
                    break;
                case "invites":
                    switchFragment(new InvitesFragment());
                    break;
                case "friends":
                    switchFragment(new FriendsFragment());
                    break;
                case "your events":
                    switchFragment(new ProfileFragment());
                    break;
                case "bookmarks":
                    switchFragment(new BookmarksFragment());
                    break;
                case "recommendations":
                    switchFragment(new RecommendationFragment());
                    break;
                case "calendar":
                    switchFragment(new CalendarFragment());
                    break;
            }


        }
    };
}