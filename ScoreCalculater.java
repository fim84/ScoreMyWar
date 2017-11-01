package com.familyfight.stenb.scoremywar;

import java.util.ArrayList;

/**
 * Created by stenb on 2017-09-06.
 */
public class ScoreCalculater {


    private int numPoints;

    public ScoreCalculater(){

    }


    public int getNumPoints(ArrayList<Partisipent> partisipents, Partisipent partisipent){
        numPoints = partisipents.indexOf(partisipent)+1;
        return numPoints;
    }

}
