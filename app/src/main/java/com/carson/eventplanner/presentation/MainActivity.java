package com.carson.eventplanner.presentation;

import androidx.annotation.MenuRes;
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
import android.widget.Toast;

import com.carson.eventplanner.objects.Event;
import com.carson.eventplanner.presentation.adapters.EventAdapter;
import com.carson.eventplanner.presentation.fragments.CreateEventFragment;
import com.carson.eventplanner.objects.User;
import com.carson.eventplanner.presentation.fragments.BookmarksFragment;
import com.carson.eventplanner.presentation.fragments.CalendarFragment;
import com.carson.eventplanner.presentation.fragments.DiscoveryFragment;
import com.carson.eventplanner.R;
import com.carson.eventplanner.presentation.adapters.DrawerMenuAdapter;
import com.carson.eventplanner.presentation.fragments.EventPageFragment;
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


    // The "database"
    private User currentUser;
    public List<Event> allEvents;
    private ACCIFragment previousFragment;
    private ACCIFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFragment = new DiscoveryFragment(this);

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
        Event golf = new Event("Night Gold","March 20","10pm","Park","golf, but extra hard", true);
        Event game = new Event("Game Night","March 20","7pm","124 clare street","Come and play games", true);
        Event shuffle = new Event("Shuffle Board","March 21","2pm","89 left street","come play shuffle board and not be bored.", true);
        Event bird = new Event("Night Golf","March 21","10pm","Park","golf, but extra hard", true);
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

    // Used from other fragments to populate apps toolbar with its own
    // while keeping the standard/cross fragment toolbar features (hamburger menu)
    // Passing -1 as menu will remove it
    public void setToolbar(Toolbar toolbar){
        setToolbar(toolbar, true);
    }

    public void setToolbar(Toolbar toolbar, boolean showDrawer){
        setToolbar(toolbar, -1, showDrawer);
    }

    public void setToolbar(Toolbar toolbar, @MenuRes int menu){
        setToolbar(toolbar, menu, true);
    }

    public void setToolbar(Toolbar toolbar, @MenuRes int menu, boolean showDrawer) {
        // Set toolbar
        setSupportActionBar(toolbar);

        // Set current toolbar. I dont know the proper way to do this. However InvalidateOptionsMenu() will recall onCreateOptionsMenu() with the new currentToolBarMenu
        currentToolbarMenu = menu;

        invalidateOptionsMenu(); // Might need to call this after showDrawer check. The internet says this calls onCreateOptionsMenu, wonder what else?

        // Add standard features
        // Add menu to toolbar
        if(showDrawer){
            drawerLayout = findViewById(R.id.drawer_layout);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        }
    }

    public void switchFragment(ACCIFragment newFragment){

        previousFragment = currentFragment;
        currentFragment = newFragment;

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, newFragment);
        fragmentTransaction.commit();

        // Highlight current drawer item

        drawerLayout.close();
    }

    public User getActiveUser() {
        return currentUser;
    }

    private void showNavDrawer(){

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
                    switchFragment(new InvitesFragment(getThis()));
                    break;
                case "friends":
                    switchFragment(new FriendsFragment(getThis()));
                    break;
                case "your events":
                    switchFragment(new EventListFragment(getThis()));
                    break;
                /*case "bookmarks":
                    switchFragment(new BookmarksFragment());
                    break;
                case "recommendations":
                    switchFragment(new RecommendationFragment());
                    break;
                case "calendar":
                    switchFragment(new CalendarFragment());
                    break;*/
            }

        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addevent:
                Toast.makeText(this, "Add Event!", Toast.LENGTH_SHORT).show();
                switchFragment(new CreateEventFragment(getThis()));
                break;
            case R.id.action_addfriend:
                Toast.makeText(this, "Add Friend!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_escape:
                // Change fragment back to frivolous, right now just always to same spot
                switchFragment(previousFragment);
                break;
        }
        return true;
    }

    // Event Handlers
    final public EventAdapter.OnEventClickListener CLICK_EVENT = new EventAdapter.OnEventClickListener() {
        @Override
        public void onItemClick(Event event) {
            switchFragment(new EventPageFragment(getThis(), event));
        }
    };


}