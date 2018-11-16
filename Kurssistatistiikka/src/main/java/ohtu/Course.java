package ohtu;

import java.util.ArrayList;

public class Course {
    private String name;
    private String fullName;
    private int year;
    private String term;
    private ArrayList<Integer> exercises;


    public String getName(){
      return name;
    }

    public int getNumberOfExercises(int week){
      if (week < 0 || week >= exercises.size()){
        return 0;
      }
      return exercises.get(week);
    }
    
    public int getNumberOfExercises(){
      int total=0;
      for (int p : exercises){
        total+=p;
      }
      return total;
    }


    @Override
    public String toString() {
      return fullName+" "+term+" "+year;
    }
    
}