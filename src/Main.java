import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, RegistrationApp!\n");
        Course c1 = new Course();
        System.out.println("course 1: "+ c1);

        Course c2 = new Course("CPSC",2730,3);
        System.out.println("course 2: " + c2);

        System.out.println("is c1 equal to c2?  " + c1.equals(c2));

        Course c3 = new Course(c1.getDept(),c1.getCourseNumber(),c1.getHours());
        System.out.println("is c1 equal to c3? " + c1.equals(c3));

       /* ArrayList<Integer> hours = new ArrayList<>();
        readFromFile("curriculum.dat");
        //add hours to list
        addHoursToList("Curriculum.dat",hours);
        System.out.println("total number of hours: "+ hours);
        //add courses to list
        ArrayList<String> courses = new ArrayList<>();
        addCoursesToList("Curriculum.dat", courses);*/


    }

}

    /*private static void addCoursesToList(String fileName, ArrayList<String> courses) {

    }

    private static void addHoursToList(String fileName, ArrayList<Integer> hours) {
        File infile = new File(fileName);
        if( ! infile.exists() ) {
            System.out.println( "Oh no, you can't read from a file that doesn't exist!" );
        } else {
            try( Scanner scan = new Scanner( infile ) ) {
                while( scan.hasNext() ) {
                    hours.add(scan.nextInt());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    private static void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

}*/
