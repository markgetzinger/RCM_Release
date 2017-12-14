package com.example.potato.room_checkmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class Home extends AppCompatActivity {

    static User ACTIVE_USER = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void login(View view){
        EditText enteredUserName = (EditText)findViewById(R.id.inputUserName);
        EditText enteredPassword = (EditText)findViewById(R.id.inputPassWord);
        String userNameCheck = enteredUserName.getText().toString();
        String userPassCheck = enteredPassword.getText().toString();

        DBHandler dbHandler = new DBHandler(this);

        User currentUser = dbHandler.findUsername(userNameCheck);
        TextView errorOut = (TextView) findViewById(R.id.errorOut);

        if (currentUser != null)//here
        {   Log.d("currentUser", currentUser.toString());//here
            if (currentUser.getPassword().equals(userPassCheck))//here
            {
                setACTIVE_USER(currentUser);

                Intent startNewActivity = new Intent(this, LoginLandingMenu.class);
                startActivity(startNewActivity);
                this.overridePendingTransition(0, 0);
            }
            else
                errorOut.setText("Invalid Password");
        }
        else
            errorOut.setText("Invalid Username");
    }

    public void signUp(View view){
        Intent startNewActivity = new Intent(this, RegLand.class);
        startActivity(startNewActivity);
        this.overridePendingTransition(0, 0);
    }

    public void randomGeneration(View view)
    {
        for(int i = 0; i < 1500; i++) {
            Random rand = new Random(i);
            String username = "";
            String password = "";
            String pRank = "";
            String rankings = "";
            String firstName;
            String lastName;
            String email = "";

            for (int index = 0; index < 4; index++) {
                username += (char) (rand.nextInt(26) + 65);
                password += (char) (rand.nextInt(26) + 65);
                pRank += rand.nextInt(4) + 1;
                rankings += rand.nextInt(5) + 1;
            }
            firstName = username.substring(0, 2);
            lastName = username.substring(3, 4);
            email += firstName + "." + lastName + "@gmail.com";

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPrank(pRank);
            user.setRankings(rankings);
            user.setFirst_name(firstName);
            user.setLast_name(lastName);
            user.setEmail(email);
            DBHandler db = new DBHandler(this);
            db.insertNewUser(user);
        }
    }



    public void setACTIVE_USER(User activeName)
    {
        this.ACTIVE_USER = activeName;
    }

    public User getACTIVE_USER(){

        return this.ACTIVE_USER;
    }

}
