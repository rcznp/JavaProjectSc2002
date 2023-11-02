package BE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetText {
    public static void main(String[] args) {
        String filePath = "/Users/cheongray/eclipse-workspace/Sc2002Assignment/src/BE/test.txt"; 

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
}
