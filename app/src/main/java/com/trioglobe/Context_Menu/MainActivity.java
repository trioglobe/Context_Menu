package com.trioglobe.Context_Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity   {
    NavigationView nav;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.show);
        drawer = findViewById(R.id.drawer);
        drawerToggle  =new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        nav = findViewById(R.id.nav);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        // Code for Changing file
       show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,activity.class);
               startActivity(i);
           }
       });
        // creates on click listener
 nav.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case R.id.search_bar:
                                drawer.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.whatever:
                                Intent intent = new Intent(MainActivity.this, activity.class);
                                startActivity(intent);
                                drawer.closeDrawer(GravityCompat.START);
                                break;

                        }
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return(super.onOptionsItemSelected(item));
    }
}
