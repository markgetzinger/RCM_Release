package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class RoomChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_chat);
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Roommate Chat");
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

    /*
    public void roomChatBack(View view){
        Intent startNewActivity = new Intent(this, RoomTools.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    */

}
