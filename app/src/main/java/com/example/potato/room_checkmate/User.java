package com.example.potato.room_checkmate;

import android.preference.Preference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Potato on 11/8/2017.
 */

//USER CLASS

/**
 * Created by Ethan on 11/7/2017.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String prank;
    private String rankings;
    private String first_name;
    private String last_name;
    private String email;

    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;

    public ArrayList<UserPreference> preferenceList;


    public User()
    {
        //constructor blank user with id -1
        this.setId(-1);
        this.setUsername("");
        this.setPassword("");
        this.setPrank("");
        this.setRankings("");
        this.setFirst_name("");
        this.setLast_name("");
        this.setEmail("");

        this.setPhone("");
        this.setAddress("");
        this.setCity("");
        this.setState("");
        this.setZip("");
        this.preferenceList=new ArrayList<UserPreference>();
        //this.setPreferenceList();
    }


    public boolean equals(User user2)
    {
        if(this.username.equals(user2.getUsername())
                && this.password.equals(user2.getPassword())
                )/*&& this.prank.equals(user2.getPrank())
                    && this.rankings.equals(user2.getRankings())
                    && this.first_name.equals(user2.getFirst_name())
                    && this.last_name.equals(user2.getLast_name())
                    && this.email.equals(user2.getEmail())
                    && this.phone.equals(user2.getPhone())
                    && this.address.equals(user2.getAddress())
                    && this.city.equals(user2.getCity())
                    && this.state.equals(user2.getState())
                    && this.zip.equals(user2.getZip()))*/
            return true;
        else
            return false;
    }

    public String toString()
    {
        return  "User ID:\t" + this.id + "\n" +
                "Username:\t" + this.username + "\n" +
                "Password:\t" + this.password + "\n"  +
                "PRank:\t" + this.prank + "\n" +
                "Rankings:\t" + this.rankings + "\n"; /*+
                    "First name:\t" + this.first_name + "\n" +
                    "Last name:\t" + this.last_name + "\n" +
                    "Email:\t" + this.email + "\n" +
                    "Phone:\t" + this.phone + "\n" +
                    "Address:\t" + this.address + "\n" +
                    "City:\t" + this.city + "\n" +
                    "State:\t" + this.state + "\n" +
                    "Zip:\t" + this.zip;
                    */
    }

    public static Comparator prankComparator = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            if (Integer.getInteger(user1.getPrank()) > Integer.getInteger(user2.getPrank()))
                return 1;
            if (Integer.getInteger(user1.getPrank()) < Integer.getInteger(user2.getPrank()))
                return -1;
            return 0;
        }
    };


    //+++++++++++++++++GETTERS+++++++++++++++++
    public ArrayList<UserPreference> getPreferenceList() {

        return preferenceList;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPrank() {
        return prank;
    }

    public String getRankings() {
        return rankings;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }


    //+++++++++++++++++SETTERS+++++++++++++++++

    public void setPreferenceList(ArrayList<UserPreference> preferenceList) {
        this.preferenceList = preferenceList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrank(String prank) {
        this.prank = prank;
    }

    public void setRankings(String rankings) {
        this.rankings = rankings;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

