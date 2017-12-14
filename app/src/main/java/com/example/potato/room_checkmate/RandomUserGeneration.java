package com.example.potato.room_checkmate;

/**
 * Created by CrystalNova on 11/12/2017.
 */

import java.util.Random;

public class RandomUserGeneration {
    private static final String TABLE_USER_INFORMATION = "userInformation";

    public static String generateRandomUser(int seed) {
        Random rand = new Random(seed);
        String username = "";
        String id = "";
        String password = "";
        String pRank = "";
        String rankings = "";
        String firstName = "";
        String lastName = "";
        String email = "";

        for(int index = 0; index < 5; index++)
        {
            username += (char)(rand.nextInt(26) + 65);
            id += rand.nextInt(10);
            password += (char)(rand.nextInt(26) + 65);
            pRank += rand.nextInt(5) + 1;
            rankings += rand.nextInt(5) + 1;
        }
        firstName = username.substring(0,2);
        lastName = username.substring(3,4);
        email += firstName+"."+lastName+"@gmail.com";
        return "CREATE TABLE IF NOT EXISTS " +
                TABLE_USER_INFORMATION
                + "(" + id + " TEXT,"
                + username + " TEXT,"
                + password + " TEXT,"
                + pRank + " TEXT,"
                + rankings + " TEXT,"
                + firstName + " TEXT,"
                + lastName + " TEXT,"
                + email + " TEXT )";
    }

    public static void main(String [] args) {
        for(int index = 0; index < 99; index++)
        {
            System.out.println(generateRandomUser(index));
        }
    }
}
