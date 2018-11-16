package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week;
    private int hours;
    private String course;
    private ArrayList<Integer> exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int getNumberOfExercises(){
        return exercises.size();
    }

    public int getHours(){
        return hours;
    }

    private String exerciseString(){
        String v="";
        for (int i=0; i<exercises.size(); i++) {
            if (i != 0) {
                v+=", ";
            }
            v+=""+exercises.get(i);
        }
        return v;
    }
    @Override
    public String toString() {
        return course
                +", viikko "+week
                +" tehtyjä tehtäviä yhteensä "+exercises.size()
                +" aikaa kului "+hours
                +" tehdyt tehtävät: "+exerciseString();
    }
    
}