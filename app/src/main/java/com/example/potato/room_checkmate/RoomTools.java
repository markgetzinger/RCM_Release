package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class RoomTools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_tools);
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Roommate Tools");



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

    public void roomChat(View view){
        Intent startNewActivity = new Intent(this, RoomChat.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    public void roomCalendar(View view){
        Intent startNewActivity = new Intent(this, RoomCalendar.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    public void roomToolsBack(View view){
        Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }

}
