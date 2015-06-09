package com.codiodes.hamburgerdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    RelativeLayout hamburgerMenu;
    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle drawerToggle;
    ArrayList<NavigationItem> mNavigationItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hamburgerMenu = (RelativeLayout) findViewById(R.id.hamburger_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.menu_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setMenusForHamburgerMenu();
        setupDrawer();
    }

    private void setMenusForHamburgerMenu() {
        try {
            //  Hard coded Strings
            String[] title = {"Home", "Settings", "About"};

            String subtitle = getResources().getString(R.string.demo_subtitle);

            int settingMenuPosition = 0;
            int shareMenuPosition = 1;
            int helpMenuPosition = 2;

            mNavigationItems.add(new NavigationItem(title[settingMenuPosition], subtitle));
            mNavigationItems.add(new NavigationItem(title[shareMenuPosition], subtitle));
            mNavigationItems.add(new NavigationItem(title[helpMenuPosition], subtitle));

            DrawerListAdapter listAdapter = new DrawerListAdapter(this, mNavigationItems);
            listView.setAdapter(listAdapter);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return false;
        }
    }
}
