package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class UserSearch extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        Spinner cleanSpinner = (Spinner) findViewById(R.id.cleanSpin);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> cleanAdapter = ArrayAdapter.createFromResource(this,
                R.array.cleanLevel, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        cleanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        cleanSpinner.setAdapter(cleanAdapter);




        Spinner socialSpinner = (Spinner) findViewById(R.id.socialSpin);
        ArrayAdapter<CharSequence> socialAdapter = ArrayAdapter.createFromResource(this,
                R.array.socialLevel, android.R.layout.simple_spinner_item);
        socialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        socialSpinner.setAdapter(socialAdapter);

        Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpin);
        ArrayAdapter<CharSequence> soundAdapter = ArrayAdapter.createFromResource(this,
                R.array.soundLevel, android.R.layout.simple_spinner_item);
        soundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soundSpinner.setAdapter(soundAdapter);

        Spinner hourSpinner = (Spinner) findViewById(R.id.hourSpin);
        ArrayAdapter<CharSequence> hourAdapter = ArrayAdapter.createFromResource(this,
                R.array.timeLevel, android.R.layout.simple_spinner_item);
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hourSpinner.setAdapter(hourAdapter);






        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("User Search");



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

    public void userSearchBack(View view){
        Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }


    public void searchForUser(View view){
        DBHandler db = new DBHandler(this);
        ArrayList<User> searchResults = new ArrayList<>();
        String formatSearchout = "";


        Spinner timeSpinner = (Spinner) findViewById(R.id.hourSpin);
        Spinner cleanSpinner = (Spinner) findViewById(R.id.cleanSpin);
        Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpin);
        Spinner socialSpinner = (Spinner) findViewById(R.id.socialSpin);
        TextView searchText = (TextView) findViewById(R.id.testSearch);
        /*searchText.setText("Clean current number is: Time: "+ timeSpinner.getItemAtPosition(timeSpinner.getSelectedItemPosition()).toString()+
                "\nClean: " + cleanSpinner.getItemAtPosition(cleanSpinner.getSelectedItemPosition()).toString() +
                "\nSound: " + soundSpinner.getItemAtPosition(soundSpinner.getSelectedItemPosition()).toString()+
                "\nSocial: " + socialSpinner.getItemAtPosition(socialSpinner.getSelectedItemPosition()).toString()
        );

        Log.d(db.userSearch(timeSpinner.getItemAtPosition(timeSpinner.getSelectedItemPosition()).toString(),
                cleanSpinner.getItemAtPosition(cleanSpinner.getSelectedItemPosition()).toString(),
                soundSpinner.getItemAtPosition(soundSpinner.getSelectedItemPosition()).toString(),
                socialSpinner.getItemAtPosition(socialSpinner.getSelectedItemPosition()).toString()).toString(), "");
        */
        searchResults = db.userSearch(timeSpinner.getItemAtPosition(timeSpinner.getSelectedItemPosition()).toString(),
                cleanSpinner.getItemAtPosition(cleanSpinner.getSelectedItemPosition()).toString(),
                soundSpinner.getItemAtPosition(soundSpinner.getSelectedItemPosition()).toString(),
                socialSpinner.getItemAtPosition(socialSpinner.getSelectedItemPosition()).toString());

        for(int i = 0; i<searchResults.size(); i++){
            formatSearchout += ("\n"+searchResults.get(i).getUsername());
        }

        searchText.setText("Users Found: \n" + formatSearchout);


    }


}
