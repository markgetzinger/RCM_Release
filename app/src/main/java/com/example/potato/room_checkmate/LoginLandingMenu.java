package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LoginLandingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_landing_menu);
        TextView welcomeText = (TextView) findViewById(R.id.welcome);
        welcomeText.setText("Welcome back,"+ Home.ACTIVE_USER.getUsername() );
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Room-Checkmate Menu");
    }

    //back button process
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            // activity end
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }

    public void checkMatch(View view){
        Intent startNewActivity = new Intent(this, CheckMatch.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }

    public void userSearch(View view){
        Intent startNewActivity = new Intent(this, UserSearch.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    public void Logout(View view){
        Intent startNewActivity = new Intent(this, Home.class);
        Home.ACTIVE_USER = null;
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }

    public void updateProfile(View view){
        Intent startNewActivity = new Intent(this, UpdateProfile.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    public void roomTools(View view){
        Intent startNewActivity = new Intent(this, RoomTools.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
}
