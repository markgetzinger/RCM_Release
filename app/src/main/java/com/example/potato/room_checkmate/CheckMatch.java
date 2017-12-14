package com.example.potato.room_checkmate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.potato.room_checkmate.Home.ACTIVE_USER;
import static com.example.potato.room_checkmate.UserPreference.differenceComparator;

public class CheckMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_match);
        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //title change
        this.setTitle("Check Match");
        receiveMatch();

        ImageView img= (ImageView) findViewById(R.id.imageView2);
        //img.setImageResource(R.mipmap.ic_ruby);
    }

    public void receiveMatch(){
        DBHandler db = new DBHandler(this);
        AlgMatch matchedAlg = new AlgMatch();
        ArrayList<ArrayList<User>> captureSplit;
        captureSplit = db.splitUsers(db.getAllUsers());

        TextView match_Username = (TextView) findViewById(R.id.matchUsername);
        TextView match_Rank = (TextView) findViewById(R.id.matchRank);




        for(int b = 0; b < captureSplit.get(0).size(); b++)
        {
            for(int g = 0; g < captureSplit.get(1).size(); g++)
            {
                captureSplit.get(0).get(b).preferenceList.add(db.setPreference(captureSplit,b,g));
            }
            Collections.sort(captureSplit.get(0).get(b).preferenceList,differenceComparator);
        }

        @SuppressWarnings("Unchecked")
        ArrayList<ArrayList<Integer>> hashMatch = matchedAlg.matchUser(captureSplit);

        User match;

        if(hashMatch.get(0).indexOf(ACTIVE_USER.getId()) == -1) {

            match = db.findId(hashMatch.get(0).get(hashMatch.get(1).indexOf(ACTIVE_USER.getId())));
        }
        else

        {
            match = db.findId(hashMatch.get(1).get(hashMatch.get(0).indexOf(ACTIVE_USER.getId())));
        }


        match_Username.setText("You've Matched With: \n" + match.getUsername());
        match_Rank.setText("Match Preferences: \n" +
                "\nHours of activities: "+ db.getRankKeyword(match.getRankings(),0)+
                "\nCleanliness: "+ db.getRankKeyword(match.getRankings(),1)+
                "\nSound Levels: "+ db.getRankKeyword(match.getRankings(),2)+
                "\nSociability: "+ db.getRankKeyword(match.getRankings(),3));
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
}
