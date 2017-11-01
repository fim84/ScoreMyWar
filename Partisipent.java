package com.familyfight.stenb.scoremywar;

/**
 * Created by stenb on 2017-08-30.
 */

public class Partisipent{

    private String name;
    private int totPoints = 0;
    private Team myTeam;
    private int contestPoint = 0;
    private double timeContest = 0.0;

    public Partisipent(String name, Team myTeam){
        this.name = name;
        this.myTeam = myTeam;
    }

    public String toString(){
        return name + " " + totPoints;
    }

    public String getName(){
        return name;
    }

    public void updatePoints(int points){
        totPoints += points;
    }

    public void setContestPoint(int points){
        contestPoint = points;
    }

    public int getContestPoint(){
        return contestPoint;
    }

    public void setTimeContest(double time){
        timeContest = time;
    }

    public double getTimeContest(){
        return timeContest;
    }

    public int getTotPoints(){
        return totPoints;
    }




}
