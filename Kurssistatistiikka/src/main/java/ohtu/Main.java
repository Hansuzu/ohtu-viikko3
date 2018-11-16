package ohtu;

import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    private static Submission[] getSubs(String studentNr){
        try{
            String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
            String bodyText = Request.Get(url).execute().returnContent().asString();

            Gson mapper = new Gson();
            return mapper.fromJson(bodyText, Submission[].class);
        } catch(Exception e){
            return null;
        }
    }
    private static Course[] getCourses(){
        try{
            String url = "https://studies.cs.helsinki.fi/courses/courseinfo";
            String bodyText = Request.Get(url).execute().returnContent().asString();

            Gson mapper = new Gson();
            return mapper.fromJson(bodyText, Course[].class);
        } catch(Exception e){
            return null;
        }
    }

    private static void printCourseInfo(Course course, ArrayList<Submission> submissions){
        System.out.println(course);
        System.out.println();
        int totalExercises = 0;
        int totalTime = 0;
        int maxExercises = course.getNumberOfExercises();
        for (Submission submission : submissions){
            int week=submission.getWeek();
            System.out.println("viikko "+week+":");
            submission.setMaxExercises(course.getNumberOfExercises(week));
            System.out.println("  "+submission);
            totalExercises+=submission.getNumberOfExercises();
            totalTime+=submission.getHours();
        }
        System.out.println();
        System.out.println("yhteensä: "+totalExercises+"/"+maxExercises+" tehtävää "+totalTime+" tuntia");
        System.out.println();
    }

    private static void printInfo(String studentNr, Submission[] subs, Course[] courses){
        System.out.println("opiskelijanumero: "+studentNr);
        System.out.println();
        for (Course course : courses){
            ArrayList<Submission> courseSubmissions = new ArrayList<Submission>();
            for (Submission submission : subs) {
                if (submission.getCourse().equals(course.getName())) {
                    courseSubmissions.add(submission);
                }
            }
            if (courseSubmissions.size() >  0){
                printCourseInfo(course, courseSubmissions);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        Submission[] subs = getSubs(studentNr);
        Course[] courses = getCourses();
        printInfo(studentNr, subs, courses);
    }
}