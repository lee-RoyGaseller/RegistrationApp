import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, RegistrationApp!\n");

        readFromFile("curriculum.dat");


    }

    private static void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

}
