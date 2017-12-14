package com.example.potato.room_checkmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class RegProfile extends AppCompatActivity {

    private SeekBar cleanSeekbar;
    private TextView cleanProgressTextView;
    private SeekBar timeSeekbar;
    private TextView timeProgressTextView;
    private SeekBar socialSeekbar;
    private TextView socialProgressTextView;
    private SeekBar soundSeekbar;
    private TextView soundProgressTextView;



    static int USER_Time;
    static int USER_Clean;
    static int USER_Sound;
    static int USER_Social;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_profile);
        //seek bar captures


        cleanSeekbar = (SeekBar) findViewById(R.id.cleanBar);
        cleanProgressTextView = (TextView) findViewById(R.id.cleanPrank);
        cleanSeekbar.setMax(4);
        cleanSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        cleanSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                cleanProgressTextView.setText("Cleanliness - "+(progressChangedValue+1));
                USER_Clean = progressChangedValue+1;
            }
        });


        timeSeekbar = (SeekBar) findViewById(R.id.timeBar);
        timeProgressTextView = (TextView) findViewById(R.id.timePrank);
        timeSeekbar.setMax(4);
        timeSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        timeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                timeProgressTextView.setText("\n\nHours of Activity - "+(progressChangedValue+1));
                USER_Time = progressChangedValue+1;
            }
        });

        socialSeekbar = (SeekBar) findViewById(R.id.socialBar);
        socialProgressTextView = (TextView) findViewById(R.id.socialPrank);
        socialSeekbar.setMax(4);
        socialSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        socialSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                socialProgressTextView.setText("\n\nSociability - "+(progressChangedValue+1));
                USER_Social = progressChangedValue+1;
            }
        });

        soundSeekbar = (SeekBar) findViewById(R.id.soundBar);
        soundProgressTextView = (TextView) findViewById(R.id.soundPrank);
        soundSeekbar.setMax(4);
        soundSeekbar.setProgress(0);

        // perform seek bar change listener event used for getting the progress value
        soundSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                soundProgressTextView.setText("\n\nSound Levels - "+(progressChangedValue+1));
                USER_Sound = progressChangedValue+1;
            }
        });



        // SPINNER STUFF
        Spinner firstSpinner = (Spinner) findViewById(R.id.firstPlace);
        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource(this,
                R.array.prefPrank, android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        firstSpinner.setAdapter(firstAdapter);


        Spinner secondSpinner = (Spinner) findViewById(R.id.secondPlace);
        ArrayAdapter<CharSequence> secondAdapter = ArrayAdapter.createFromResource(this,
                R.array.prefPrank, android.R.layout.simple_spinner_item);
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        secondSpinner.setAdapter(secondAdapter);


        Spinner thirdSpinner = (Spinner) findViewById(R.id.thirdPlace);
        ArrayAdapter<CharSequence> thirdAdapter = ArrayAdapter.createFromResource(this,
                R.array.prefPrank, android.R.layout.simple_spinner_item);
        thirdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        thirdSpinner.setAdapter(thirdAdapter);

        Spinner fourthPlace = (Spinner) findViewById(R.id.fourthPlace);
        ArrayAdapter<CharSequence> fourthAdapter = ArrayAdapter.createFromResource(this,
                R.array.prefPrank, android.R.layout.simple_spinner_item);
        fourthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fourthPlace.setAdapter(fourthAdapter);


        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Profile Information");

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


    public void Reg2Fin(View view) {

        Bundle extras = getIntent().getExtras();

        EditText profFirstName = (EditText) findViewById(R.id.firstName);
        EditText profLastName = (EditText) findViewById(R.id.lastName);
        EditText profAddress = (EditText) findViewById(R.id.regAddress);
        EditText profCity = (EditText) findViewById(R.id.regCity);
        EditText profState = (EditText) findViewById(R.id.regState);
        EditText profZip = (EditText) findViewById(R.id.regZip);
        EditText profPhone = (EditText) findViewById(R.id.regPhone);

        String userFirstName = profFirstName.getText().toString();
        String userLastName = profLastName.getText().toString();
        String userAddress = profAddress.getText().toString();
        String userCity = profCity.getText().toString();
        String userState = profState.getText().toString();
        String userZip = profZip.getText().toString();
        String userPhone = profPhone.getText().toString();

        //add regex / input validation

        Spinner first_Spin = (Spinner) findViewById(R.id.firstPlace);
        Spinner second_Spin = (Spinner) findViewById(R.id.secondPlace);
        Spinner third_Spin = (Spinner) findViewById(R.id.thirdPlace);
        Spinner fourth_Spin = (Spinner) findViewById(R.id.fourthPlace);
        String first_String = first_Spin.getItemAtPosition(first_Spin.getSelectedItemPosition()).toString();
        String second_String = second_Spin.getItemAtPosition(second_Spin.getSelectedItemPosition()).toString();
        String third_String = third_Spin.getItemAtPosition(third_Spin.getSelectedItemPosition()).toString();
        String fourth_String = fourth_Spin.getItemAtPosition(fourth_Spin.getSelectedItemPosition()).toString();


        if (first_String != second_String &&
                first_String != third_String &&
                first_String != fourth_String &&
                second_String != third_String &&
                second_String != fourth_String &&
                third_String != fourth_String) {


            //send all data to the database

            User user = new User();
            user.setUsername(extras.getString("RegLandUserName"));
            user.setPassword(extras.getString("RegLandPassword"));
            user.setEmail(extras.getString("RegLandEmail"));
            user.setFirst_name(userFirstName);
            user.setLast_name(userLastName);
            user.setAddress(userAddress);
            user.setCity(userCity);
            user.setState(userState);
            user.setZip(userZip);
            user.setPhone(userPhone);

            user.setRankings(Integer.toString(USER_Time) + Integer.toString(USER_Clean) + Integer.toString(USER_Sound) + Integer.toString(USER_Social));

            //add user to db
            DBHandler db = new DBHandler(this);
            user.setPrank(db.prankConversion(first_String,second_String,third_String,fourth_String));
            Log.d("User INjectd:", user.toString());
            db.insertNewUser(user);

            //user was inserted into database, make sure its there before continuing
            User user2 = db.findUsername(user.getUsername());
            if (user2 != null) {
                Home.ACTIVE_USER = user2;
                Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
                startActivity(startNewActivity);
                this.overridePendingTransition(0, 0);
            }
        }
    }

    /*
    public void Reg2Back(View view){
        Intent startNewActivity = new Intent(this, RegLand.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }
    */
}
