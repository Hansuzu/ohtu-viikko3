package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week;
    private int hours;
    private String course;
    private ArrayList<Integer> exercises;
    private int maxExercises;


    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int getHours(){
        return hours;
    }

    public String getCourse(){
        return course;
    }

    public int getNumberOfExercises(){
        return exercises.size();
    }

    public void setMaxExercises(int no){
        maxExercises = no;
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
        return  " tehtyjä tehtäviä yhteensä "+exercises.size()+"/"+maxExercises
                +" aikaa kului "+hours
                +" tehdyt tehtävät: "+exerciseString();
    }
    
}