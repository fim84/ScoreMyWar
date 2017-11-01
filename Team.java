package com.familyfight.stenb.scoremywar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by stenb on 2017-08-30.
 */
public class Team implements Parcelable{
    private String name;
    private int teamPoints = 0;

    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return teamPoints;
    }

    public void updatePoints(int points){
        teamPoints = teamPoints + points;
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>(){
        public Team createFromParcel(Parcel in){
            return new Team(in);
        }
        public Team[] newArray(int size){
            return new Team[size];
        }
    };


    private Team(Parcel in){
        name = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(name);
    }

    public int equal(String teamName){
        if(teamName.equals(name)){
            return 1;
        }
        return -1;
    }

    public String toString(){
        return name + " " + teamPoints;
    }

}
