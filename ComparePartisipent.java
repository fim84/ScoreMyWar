package com.familyfight.stenb.scoremywar;

import java.util.Comparator;

/**
 * Created by stenb on 2017-09-06.
 */
public class ComparePartisipent implements Comparator<Partisipent>{

    public int compare(Partisipent first, Partisipent second){
        return first.getContestPoint() - second.getContestPoint();
    }
}
