package BE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;
public class File_Handler {
    public static void printTextFile(String filePath) {
 
        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read and print each line in the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
//    public static List<User> readUserDataFromFile(String filePath) 
//    {
//    	
//    }
    
    public static ArrayList<ArrayList<String>>PutFileContentIntoArray(String filePath) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filePath));
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<String> faculties = new ArrayList<>();
        ArrayList<String> userIDs= new ArrayList<>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split("\t");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                String email = parts[1].trim();
                String faculty = parts[2].trim();

                names.add(name);
                emails.add(email);
                faculties.add(faculty);
                String[] emailParts = email.split("@");
                String userID = emailParts[0];
                //String role = emailParts[1];
                //System.out.println(role);
                userIDs.add(userID);
            }
        }
        ArrayList<ArrayList<String>> allArrays = new ArrayList<>();
        allArrays.add(names);
        allArrays.add(emails);
        allArrays.add(faculties);
        allArrays.add(userIDs);
        
        return allArrays;

    }
    //public static void ()
    public static void main(String[] args) {
    	try {
        File_Handler.PutFileContentIntoArray("/Users/cheongray/Datasc2002/student");
    	}
    	catch(IOException e){
    		 System.err.println("An error occurred while reading the file: " + e.getMessage());
    	}
    }
}
