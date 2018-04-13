import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, RegistrationApp!\n");
        Course c1 = new Course();
        System.out.println("course 1: "+ c1);

        Course c2 = new Course("CPSC","2730",3);
        System.out.println("course 2: " + c2);

        System.out.println("is c1 equal to c2?  " + c1.equals(c2));

        Course c3 = new Course(c1.getDept(),c1.getCourseNumber(),c1.getHours());
        System.out.println("is c1 equal to c3? " + c1.equals(c3));

        ArrayList<Course> courses = new ArrayList<>();
        fillCourseList("curriculum.dat",courses);
        System.out.println("courses: "+ courses);
        System.out.println("courses size: "+ courses.size());

        //calculate total hours in curriculum
        int totalHours = totalHoursInCurriculum(courses);
        System.out.println("the total hours in the curriculum: "+ totalHours);

        //total number of department courses
        int numOfCPSCCourses = totalNumberOfDepartmentCourses("CPSC",courses);
        System.out.println("the total number of CPSC courses: " + numOfCPSCCourses);

        //determine if a course is in the curriculum
        Course c4 = new Course("PHIL","2040",3);

        boolean isPhilosophyInTheCurriculum =  isThisCourseInTheCurriculum(c4 , courses);
        System.out.println("philosophy 2040 in the curriculum: "+ isPhilosophyInTheCurriculum);

        //create transcript file
        createTranscript("transcript.dat",courses);





    }

    private static void createTranscript(String nameOfFile, ArrayList<Course> courses) throws FileNotFoundException {
        File file = new File(nameOfFile);
        if (file.exists()) {
            System.out.println("Oh no, you're going to overwrite the data in the file!");
        }


        try(PrintWriter pw = new PrintWriter(file)){
            for (int i = 0; i < courses.size(); i++) {
                String[] parts = courses.get(i).getDept().split(" ");
                if(parts[0].equals("African") || parts[0].equals("Human") || parts[0].equals("Scientific") || parts.length>=2 ){

                }
                else {
                    pw.print(courses.get(i).getDept());
                    pw.print(" ");
                    pw.print(courses.get(i).getCourseNumber());
                    pw.print(" ");
                    pw.println(courses.get(i).getHours());
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



    }

    private static boolean isThisCourseInTheCurriculum(Course course, ArrayList<Course> courses) {
        boolean in = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course)){
                in = true;
            }
        }
        return in;
    }

    private static int totalNumberOfDepartmentCourses(String dept, ArrayList<Course> courses) {
        int numOfDesiredCourse = 0;
        for (int i = 0; i < courses.size() ; i++) {
            if (courses.get(i).getDept().equals(dept)){
                numOfDesiredCourse++;
            }

        }
        return numOfDesiredCourse;
    }

    private static int totalHoursInCurriculum(ArrayList<Course> courses) {
       int totalHours = 0;
        for (int i = 0; i <courses.size() ; i++) {
            totalHours+= courses.get(i).getHours();

        }
        return totalHours;

    }

    private static ArrayList<Course> fillCourseList(String fileName, ArrayList<Course> courses) {
        File infile = new File(fileName);
        if( ! infile.exists() ) {
            System.out.println( "Oh no, you can't read from a file that doesn't exist!" );
        } else {
            try( Scanner scan = new Scanner( infile ) ) {
                while( scan.hasNext() ) {

                    String aLine = scan.nextLine();
                    String[] parts = aLine.split(" ");
                    if (parts[1].equals("African")) {
                        Course course = new Course("African American Heritage", " ", 3);
                        courses.add(course);

                    }

                    if (parts[1].equals("Human")) {
                        Course course = new Course("Human Past", " ", 3);
                        courses.add(course);
                    }

                    if (parts[1].equals("Scientific")) {
                        Course course = new Course("Scientific Reasoning", " ", 3);
                        courses.add(course);
                    }

                    if (parts[1].equals("CPSC")) {
                        Course course = new Course("CPSC Elective", " ", 3);
                        courses.add(course);
                    }
                    if (parts[0].equals("*")) {

                    }

                    else {

                        Course course = new Course(parts[0], parts[1], Integer.parseInt(parts[parts.length - 1]));
                        courses.add(course);
                    }
                }
                } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }

}
