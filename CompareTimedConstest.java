package com.familyfight.stenb.scoremywar;

import java.util.Comparator;

/**
 * Created by stenb on 2017-09-06.
 */
public class CompareTimedConstest implements Comparator<Partisipent> {
    @Override
    public int compare(Partisipent first, Partisipent second){
        double d = (100*first.getTimeContest()) - (100*second.getTimeContest());
        int i = (int) d;
        return i;
    }
}
