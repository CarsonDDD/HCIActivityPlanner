package com.carson.eventplanner.presentation;

import androidx.annotation.MenuRes;
import androidx.annotation.Nullable;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.carson.eventplanner.presentation.fragments.BookmarksFragment;
import com.carson.eventplanner.presentation.fragments.CalendarFragment;
import com.carson.eventplanner.presentation.fragments.DiscoveryFragment;
import com.carson.eventplanner.R;
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.fragments.FriendsFragment;
import com.carson.eventplanner.presentation.fragments.InvitesFragment;
import com.carson.eventplanner.presentation.fragments.EventListFragment;
import com.carson.eventplanner.presentation.fragments.RecommendationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private RecyclerView rvDrawerMenu;

    private @MenuRes int currentToolbarMenu = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set current fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new DiscoveryFragment(this));
        fragmentTransaction.commit();


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
        if(currentToolbarMenu != -1){
            getMenuInflater().inflate(currentToolbarMenu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addevent:
                Toast.makeText(this, "Add Event!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    // Used from other fragments to populate apps toolbar with its own
    // while keeping the standard/cross fragment toolbar features (hamburger menu)
    // Passing -1 as menu will remove it
    public void setToolbar(Toolbar toolbar){
        setToolbar(toolbar, -1);
    }

    public void setToolbar(Toolbar toolbar, @MenuRes int menu) {
        // Set toolbar
        setSupportActionBar(toolbar);

        // Set current toolbar. I dont know the proper way to do this. However InvalidateOptionsMenu() will recall onCreateOptionsMenu() with the new currentToolBarMenu
        currentToolbarMenu = menu;


        invalidateOptionsMenu();


        // Add standard features
        // Add menu to toolbar
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void switchFragment(Fragment newFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, newFragment);
        fragmentTransaction.commit();

        // Highlight current drawer item

        drawerLayout.close();
    }

    // Panic function
    // Yes this is mandatory, removing it will ensue in chaos
    private MainActivity getThis(){ return this;}


    final private DrawerMenuAdapter.OnItemClickListener menuClick = new DrawerMenuAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String id) {
            switch (id.toLowerCase()){
                case "home":
                    switchFragment(new DiscoveryFragment(getThis()));
                    break;
                case "invites":
                    switchFragment(new InvitesFragment());
                    break;
                case "friends":
                    switchFragment(new FriendsFragment());
                    break;
                case "your events":
                    switchFragment(new EventListFragment(getThis()));
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