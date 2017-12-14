package com.example.potato.room_checkmate;

/**
 * Created by mark.getzinger926 on 11/8/17.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Created by Ethan on 11/4/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user";
    private static final String TABLE_USER_INFORMATION = "userInformation";


    // TABLE COLUMN NAMES
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_PRANK = "prank";
    private static final String KEY_RANKINGS = "rankings";
    private static final String KEY_FIRST_NAME = "first";
    private static final String KEY_LAST_NAME = "last";
    private static final String KEY_EMAIL = "email";

    private static final String KEY_PHONE = "phone";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_ZIP = "zip";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_INFORMATION_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USER_INFORMATION
                + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_PRANK + " TEXT,"
                + KEY_RANKINGS + " TEXT,"
                + KEY_FIRST_NAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"

                + KEY_PHONE + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_CITY + " TEXT,"
                + KEY_STATE + " TEXT,"
                + KEY_ZIP + " TEXT " + ")";

        db.execSQL(CREATE_USER_INFORMATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drops older table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INFORMATION);
        //recreates table
        onCreate(db);
    }


    public void insertNewUser(User newUser) {
        // Create a new map of values, where column names are the keys
        ContentValues userInfo = new ContentValues();

        userInfo.put(KEY_USERNAME, newUser.getUsername());
        userInfo.put(KEY_PASSWORD, newUser.getPassword());
        userInfo.put(KEY_PRANK, newUser.getPrank());
        userInfo.put(KEY_RANKINGS, newUser.getRankings());
        userInfo.put(KEY_FIRST_NAME, newUser.getFirst_name());
        userInfo.put(KEY_LAST_NAME, newUser.getLast_name());
        userInfo.put(KEY_EMAIL, newUser.getEmail());
        userInfo.put(KEY_PHONE, newUser.getPhone());
        userInfo.put(KEY_ADDRESS, newUser.getAddress());
        userInfo.put(KEY_CITY, newUser.getCity());
        userInfo.put(KEY_STATE, newUser.getState());
        userInfo.put(KEY_ZIP, newUser.getZip());


        // Insert the new row, returning the primary key value of the new row
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER_INFORMATION, null, userInfo);
        db.close();
    }

    public User findUsername(String username)
    {
        String query = "Select * FROM " + TABLE_USER_INFORMATION + " WHERE " + KEY_USERNAME + " = \"" + username + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User foundUser = new User();
        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            foundUser.setId(Integer.parseInt(cursor.getString(0)));
            foundUser.setUsername(cursor.getString(1));
            foundUser.setPassword(cursor.getString(2));
            foundUser.setPrank(cursor.getString(3));
            foundUser.setRankings(cursor.getString(4));
            foundUser.setFirst_name(cursor.getString(5));
            foundUser.setLast_name(cursor.getString(6));
            foundUser.setEmail(cursor.getString(7));
            foundUser.setPhone(cursor.getString(8));
            foundUser.setAddress(cursor.getString(9));
            foundUser.setCity(cursor.getString(10));
            foundUser.setState(cursor.getString(11));
            foundUser.setZip(cursor.getString(12));
            cursor.close();
        }
        else
        {
            foundUser = null;
        }
        cursor.close();
        db.close();
        return foundUser;
    }

    public User findId(int Id)
    {
        String query = "Select * FROM " + TABLE_USER_INFORMATION + " WHERE " + KEY_ID + " = \"" + Id + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User foundUser = new User();
        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            foundUser.setId(Integer.parseInt(cursor.getString(0)));
            foundUser.setUsername(cursor.getString(1));
            foundUser.setPassword(cursor.getString(2));
            foundUser.setPrank(cursor.getString(3));
            foundUser.setRankings(cursor.getString(4));
            foundUser.setFirst_name(cursor.getString(5));
            foundUser.setLast_name(cursor.getString(6));
            foundUser.setEmail(cursor.getString(7));
            foundUser.setPhone(cursor.getString(8));
            foundUser.setAddress(cursor.getString(9));
            foundUser.setCity(cursor.getString(10));
            foundUser.setState(cursor.getString(11));
            foundUser.setZip(cursor.getString(12));
            cursor.close();
        }
        else
        {
            foundUser = null;
        }
        cursor.close();
        db.close();
        return foundUser;
    }

    public User findPrank(String prank)
    {
        String query = "Select * FROM " + TABLE_USER_INFORMATION + " WHERE " + KEY_PRANK + " = \"" + prank + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User foundUser = new User();
        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            foundUser.setId(Integer.parseInt(cursor.getString(0)));
            foundUser.setUsername(cursor.getString(1));
            foundUser.setPassword(cursor.getString(2));
            foundUser.setPrank(cursor.getString(3));
            foundUser.setRankings(cursor.getString(4));
            foundUser.setFirst_name(cursor.getString(5));
            foundUser.setLast_name(cursor.getString(6));
            foundUser.setEmail(cursor.getString(7));
            foundUser.setPhone(cursor.getString(8));
            foundUser.setAddress(cursor.getString(9));
            foundUser.setCity(cursor.getString(10));
            foundUser.setState(cursor.getString(11));
            foundUser.setZip(cursor.getString(12));
            cursor.close();
        }
        else
        {
            foundUser = null;
        }
        cursor.close();
        db.close();
        return foundUser;
    }

    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> user_list = new ArrayList<User>();

        String query = "select * FROM " + TABLE_USER_INFORMATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query , null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            User foundUser = new User();

            foundUser.setId(Integer.parseInt(cursor.getString(0)));
            foundUser.setUsername(cursor.getString(1));
            foundUser.setPassword(cursor.getString(2));
            foundUser.setPrank(cursor.getString(3));
            foundUser.setRankings(cursor.getString(4));
            foundUser.setFirst_name(cursor.getString(5));
            foundUser.setLast_name(cursor.getString(6));
            foundUser.setEmail(cursor.getString(7));
            foundUser.setPhone(cursor.getString(8));
            foundUser.setAddress(cursor.getString(9));
            foundUser.setCity(cursor.getString(10));
            foundUser.setState(cursor.getString(11));
            foundUser.setZip(cursor.getString(12));

            user_list.add(foundUser);//add users to list here
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return user_list;
    }

    public ArrayList<ArrayList<User>> splitUsers(ArrayList<User> listOfUsers){
        ArrayList array1 = new ArrayList<User>();
        ArrayList array2 = new ArrayList<User>();
        ArrayList retArray = new ArrayList<ArrayList<User>>();
        for(int i =0; i < listOfUsers.size()/2;i++) {
            array1.add(listOfUsers.get(i));
            array2.add(listOfUsers.get(i + (listOfUsers.size() / 2)));
        }

        while(array1.size() > array2.size())
            array1.remove(array1.size()-1);
        while(array2.size() > array1.size())
            array2.remove(array2.size()-1);

        retArray.add(array1);
        retArray.add(array2);
        return retArray;
    }


    public UserPreference setPreference(ArrayList<ArrayList<User>> captureSplit, int user1, int user2)
    {
        UserPreference retPref = new UserPreference();
        int difference = 0;
        for(int index = 0; index < 4; index++)
        {
            difference += abs(Character.getNumericValue(captureSplit.get(0).get(user1).getPrank().charAt(index))-
                    Character.getNumericValue(captureSplit.get(1).get(user2).getRankings().charAt(index)) ) +
                    abs(Character.getNumericValue(captureSplit.get(1).get(user2).getPrank().charAt(index))-
                            Character.getNumericValue(captureSplit.get(0).get(user1).getRankings().charAt(index)));
        }
        retPref.setDifference(difference);
        retPref.setIndex(user2);
        return retPref;
    }




    public boolean deleteUser(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USER_INFORMATION, KEY_USERNAME + "=" + username, null) > 0;
    }


    public ArrayList<User> userSearch(String time, String clean, String sound, String social)
    {
        String compareRank = "";
        switch(time)
        {
            case "very early":
                compareRank += 1;
                break;
            case "early":
                compareRank += 2;
                break;
            case "average":
                compareRank += 3;
                break;
            case "late":
                compareRank += 4;
                break;
            case "very late":
                compareRank += 5;
                break;
            default:
                compareRank += 3;
                break;
        }
        switch(clean)
        {
            case "very clean":
                compareRank += 1;
                break;
            case "clean":
                compareRank += 2;
                break;
            case "average":
                compareRank += 3;
                break;
            case "dirty":
                compareRank += 4;
                break;
            case "very dirty":
                compareRank += 5;
                break;
            default:
                compareRank += 3;
                break;
        }
        switch(sound)
        {
            case "very quiet":
                compareRank += 1;
                break;
            case "quiet":
                compareRank += 2;
                break;
            case "average":
                compareRank += 3;
                break;
            case "loud":
                compareRank += 4;
                break;
            case "very loud":
                compareRank += 5;
                break;
            default:
                compareRank += 3;
                break;
        }
        switch(social)
        {
            case "very social":
                compareRank += 1;
                break;
            case "social":
                compareRank += 2;
                break;
            case "average":
                compareRank += 3;
                break;
            case "reserved":
                compareRank += 4;
                break;
            case "antisocial":
                compareRank += 5;
                break;
            default:
                compareRank += 3;
                break;
        }

        String query = "Select * FROM " + TABLE_USER_INFORMATION + " WHERE " + KEY_RANKINGS + " = \"" + compareRank + "\"";
        ArrayList<User> user_list = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query , null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            User foundUser = new User();

            foundUser.setId(Integer.parseInt(cursor.getString(0)));
            foundUser.setUsername(cursor.getString(1));
            foundUser.setPassword(cursor.getString(2));
            foundUser.setPrank(cursor.getString(3));
            foundUser.setRankings(cursor.getString(4));
            foundUser.setFirst_name(cursor.getString(5));
            foundUser.setLast_name(cursor.getString(6));
            foundUser.setEmail(cursor.getString(7));
            foundUser.setPhone(cursor.getString(8));
            foundUser.setAddress(cursor.getString(9));
            foundUser.setCity(cursor.getString(10));
            foundUser.setState(cursor.getString(11));
            foundUser.setZip(cursor.getString(12));

            user_list.add(foundUser);//add users to list here
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return user_list;
    }


    public String prankConversion(String first, String second, String third, String fourth) {
        String[] nextStringArray = {first, second, third, fourth};
        String appendedPrank = "";
        /*
        <item>Cleanliness</item>
        <item>Active Hours</item>
        <item>Sociability</item>
        <item>Sound Levels</item>
        */
        for (int i = 0; i<nextStringArray.length;i++) {
            switch (nextStringArray[i]) {
                case "Active Hours":
                    appendedPrank += 1;
                    break;
                case "Cleanliness":
                    appendedPrank += 2;
                    break;
                case "Sound Levels":
                    appendedPrank += 3;
                    break;
                case "Sociability":
                    appendedPrank += 4;
                    break;
                default:
                    break;
            }
        }
        Log.d("appended prank", appendedPrank);
        return appendedPrank;
    }





    public String getRankKeyword(String rankings, int rankingInd) {
        Log.d("passed stuff: ", rankings + " :: " + rankingInd);

        char charAtValue = rankings.charAt(rankingInd);

        String charRanking = "" + charAtValue;

        Log.d("captured string: ", charRanking);
                /*
        Ranking In-dices
        0 = time
        1 = cleanliness
        2 = noise
        3 = sociability
         */
        String possibleRankings[][] = {
                {"very early", "early", "average", "late", "very late"},
                {"very clean", "clean", "average", "dirty","very dirty"},
                {"very quiet","quiet","average","loud","very loud"},
                {"very social","social","average","reserved","antisocial"}
        };
        return possibleRankings[rankingInd][Integer.valueOf(charRanking)-1];
    }
}


