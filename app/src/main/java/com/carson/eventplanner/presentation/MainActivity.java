package com.carson.eventplanner.presentation;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.carson.eventplanner.presentation.adapters.SearchFragment;
import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.fragments.CreateEventFragment;
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.fragments.BookmarksFragment;
import com.carson.eventplanner.presentation.fragments.DiscoveryFragment;
import com.carson.eventplanner.R;
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.fragments.EventPageFragment;
import com.carson.eventplanner.presentation.fragments.FriendsFragment;
import com.carson.eventplanner.presentation.fragments.InvitesFragment;
import com.carson.eventplanner.presentation.fragments.EventListFragment;
import com.carson.eventplanner.presentation.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    void setupData(){
        // Init user
        // Add all user hardcoded data here
        currentUser = new User("JoeBlow");

        allEvents = new ArrayList<>();

        User prof = new User("Dr. Patrick Dubois");
        User joe = new User("Joe");
        User carson = new User("Carson");
        User obi = new User("Obi");
        User casandra = new User("Casandra");
        User ian = new User("Ian");
        User saad = new User("Sa'ad");

        currentUser.addFriend(carson);
        currentUser.addFriend(obi);
        currentUser.addFriend(casandra);
        currentUser.addFriend(ian);
        currentUser.addFriend(saad);

        Event school = new Event("Human Computer Interaction","March 16","10am","527 Buller","give A\nso tired", true);
        Event concert1 = new Event("Mom Jeans","March 17","9pm","23 osbourne","Live music", true);
        Event darts = new Event("Darts","March 18","8pm","Whispering Bean","Come down to play darts!", true);
        Event concert2 = new Event("SkyRaid","March 16","9pm","56 main street","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", true);
        Event golf = new Event("Night Golf","March 20","10pm","Park","golf, but extra hard", true);
        Event game = new Event("Game Night","March 20","7pm","124 clare street","Come and play games", true);
        Event shuffle = new Event("Shuffle Board","March 21","2pm","89 left street","come play shuffle board and not be bored.", true);
        Event bird = new Event("Bird Watching","March 21","10pm","Park","golf, but extra hard", true);
        Event cook = new Event("Learn to Cook","March 22","12pm","66 six street","Learn the pans!", true);
        Event race = new Event("Drag Race","March 29","8am","1273 go ave","got a fast car? join now!", true);
        Event joke = new Event("Open mic night","April 1","9pm","23 osbourne","funny jokes and good food!", true);
        Event sky = new Event("Learn to sky dive.","April 4","9am","124 clare street","We will take you through every jump to make you an expert.", true);
        Event magic = new Event("Magic show","April 7","7pm","Whispering Bean","We will take you through every jump to make you an expert.", true);
        Event birthday = new Event("Birthday!", "April 1", "ALL DAY", "26 Beef ave", "A big fun celebration, everyone is invited!", true);

        // Use of other way event call
        currentUser.createEvent(birthday);
        birthday.addAttendee(joe);
        birthday.addAttendee(carson);
        birthday.addAttendee(obi);
        birthday.addAttendee(casandra);
        birthday.addAttendee(ian);
        birthday.addAttendee(saad);

        school.addOrganizer(prof);
        school.addAttendee(carson);
        school.addAttendee(obi);
        school.addAttendee(casandra);
        school.addAttendee(ian);
        school.addAttendee(saad);

        concert1.addOrganizer(joe);
        concert1.addOrganizer(saad);
        concert1.addAttendee(carson);
        concert1.addAttendee(prof);
        concert1.addAttendee(ian);

        darts.addOrganizer(carson);
        darts.addAttendee(obi);
        darts.addAttendee(joe);
        darts.addAttendee(ian);

        concert2.addOrganizer(obi);
        concert2.addOrganizer(ian);
        concert2.addAttendee(carson);
        concert1.addAttendee(casandra);

        golf.addOrganizer(casandra);
        golf.addAttendee(ian);
        golf.addAttendee(obi);

        game.addOrganizer(ian);
        game.addOrganizer(carson);
        game.addOrganizer(casandra);
        game.addAttendee(joe);
        game.addAttendee(obi);
        game.addAttendee(saad);

        shuffle.addOrganizer(saad);
        shuffle.addAttendee(obi);
        shuffle.addAttendee(ian);

        bird.addOrganizer(carson);
        bird.addOrganizer(ian);
        bird.addAttendee(casandra);

        cook.addOrganizer(carson);
        cook.addAttendee(prof);
        cook.addAttendee(joe);

        race.addOrganizer(obi);
        race.addOrganizer(carson);
        race.addAttendee(saad);
        race.addAttendee(casandra);

        joke.addOrganizer(casandra);
        joke.addAttendee(ian);

        sky.addOrganizer(ian);
        sky.addOrganizer(joe);
        sky.addAttendee(carson);
        sky.addAttendee(saad);

        magic.addOrganizer(saad);
        magic.addAttendee(casandra);
        magic.addAttendee(ian);
        magic.addAttendee(carson);

        currentUser.joinEvent(school);

        allEvents.add(school);
        allEvents.add(concert1);
        allEvents.add(darts);
        allEvents.add(concert2);
        allEvents.add(golf);
        allEvents.add(game);
        allEvents.add(shuffle);
        allEvents.add(bird);
        allEvents.add(cook);
        allEvents.add(race);
        allEvents.add(joke);
        allEvents.add(sky);
        allEvents.add(magic);

        // Invite test
        carson.invite(darts, getActiveUser());
    }

    // The "database"
    private User currentUser;
    public User getActiveUser(){
        return currentUser;
    }
    public List<Event> allEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();

        changeFragment(new DiscoveryFragment());

        BottomNavigationView navbar = findViewById(R.id.navigation_bar);
        navbar.getMenu().findItem(R.id.menu_discovery).setChecked(true);

        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_search:
                        changeFragment(new SearchFragment());
                        // Handle the "Home" item
                        break;
                    case R.id.menu_discovery:
                        changeFragment(new DiscoveryFragment());
                        break;
                    case R.id.menu_profile:
                        // Handle the "Profile" item
                        changeFragment(new ProfileFragment(getActiveUser()));
                        break;
                }
                // Set the item as checked to highlight it in the NavigationView
                //item.setChecked(true);
                return true;
            }
        });


    }

    // Public function to be used outside this class without needing to touch its caller
    public void changeFragment(Fragment fragment){
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit();
    }

    public void undoFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
            updateNavigationBar();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        undoFragment();
    }

    // Make sure the navigation bar has the correct fragment checked
    private void updateNavigationBar(){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        BottomNavigationView navbar = findViewById(R.id.navigation_bar);

        // hmmmmmm. I believe .setSelectedItemId calls the above fragment switching code. This effectively modifies the stack in a way where nav buttons cannot be back swiped.
        // This was the old behaviour before using the manager stack. Writing this code, I did not intent for this to work like this, nonetheless I am pleasantly pleased.
        /*if(currentFragment instanceof DiscoveryViewFragment){
            navbar.setSelectedItemId(R.id.nav_discovery);
        }
        else if(currentFragment instanceof SearchViewFragment){
            navbar.setSelectedItemId(R.id.nav_search);
        }
        else if(currentFragment instanceof PantryFragment){
            navbar.setSelectedItemId(R.id.nav_pantry);
        }
        else if(currentFragment instanceof RecipeInsertFragment){
            navbar.setSelectedItemId(R.id.nav_insert_recipe);
        }
        else if(currentFragment instanceof ProfileViewFragment && ((ProfileViewFragment)currentFragment).isCurrentUser()){
            navbar.setSelectedItemId(R.id.nav_profile);
        }*/

        // else.... nothing.
    }

    public void showNavigationBar(boolean showBar){
        BottomNavigationView nav = findViewById(R.id.navigation_bar);
        if(showBar)
            nav.setVisibility(View.VISIBLE);
        else
            nav.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addfriend:
                Toast.makeText(this, "Add Friend!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    // Event Handlers
    final public EventAdapter.OnEventClickListener CLICK_EVENT = new EventAdapter.OnEventClickListener() {
        @Override
        public void onItemClick(Event event) {
            changeFragment(new EventPageFragment(event));
        }
    };


}