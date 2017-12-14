package com.example.potato.room_checkmate;

import java.util.Comparator;

/**
 * Created by mark.getzinger926 on 11/20/17.
 */

public class UserPreference {

    private int index;
    private int difference;

    public UserPreference()
    {
        this.index = -1;
        this.difference = -1;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setDifference(int difference)
    {
        this.difference = difference;
    }

    public int getIndex()
    {
        return this.index;
    }

    public int getDifference()
    {
        return this.difference;
    }

    public String toString()
    {
        return "index: " + this.index + "\tdifference: " + this.difference;
    }

    public static Comparator differenceComparator = new Comparator<UserPreference>() {

        @Override
        public int compare(UserPreference pref1, UserPreference pref2) {
            if (pref1.getDifference() > pref2.getDifference())
                return 1;
            if (pref1.getDifference() < pref2.getDifference())
                return -1;
            return 0;
        }
    };


}
