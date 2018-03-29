import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, RegistrationApp!\n");
        ArrayList<Integer> hours = new ArrayList<Integer>();
        readFromFile("curriculum.dat");
        //add hours to list
        addHoursToList("Curriculum.dat",hours);
        System.out.println("total number of hours: "+ hours);



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

}
