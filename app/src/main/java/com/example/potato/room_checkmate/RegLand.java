package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;

public class RegLand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_land);
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Registration");
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            // activity end
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void RegNext(View view){
        //Capture all fields, and convert to strings

        EditText regName = (EditText)findViewById(R.id.regUserName);
        EditText regEm = (EditText)findViewById(R.id.regEmail);
        EditText regPass = (EditText)findViewById(R.id.regPW);
        EditText regRepPass = (EditText)findViewById(R.id.regRPW);
        String userName = regName.getText().toString();
        String userEmail = regEm.getText().toString();
        String userPassword = regPass.getText().toString();
        String userRetype = regRepPass.getText().toString();

        //add regex / input validation
        if (userPassword.equals(userRetype)) {
            //send all data to the database

            //Loads next page only if password is valid (typed the same)
            Intent startNewActivity = new Intent(this, RegProfile.class);
            startNewActivity.putExtra("RegLandUserName", userName);
            startNewActivity.putExtra("RegLandEmail", userEmail);
            startNewActivity.putExtra("RegLandPassword", userPassword);
            startActivity(startNewActivity);
            this.overridePendingTransition(0, 0);

        }
    }
}
