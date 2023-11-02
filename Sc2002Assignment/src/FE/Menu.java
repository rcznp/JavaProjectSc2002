package FE;
import BE.File_Handler;//abstract away the low-level details of file operations(OOP) using FileHandler
import java.io.IOException;
import java.util.Scanner;
import BE.GetText;
public class Menu 
{
	public static void main(String[] args) {
	System.out.println("CAM");
	System.out.println("-----------------------------");
	Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the path to the text file: ");
    File_Handler.Logger();
    String sourceFilePath = scanner.nextLine();
    String destinationPath = "BE/students/student_data.txt"; // Specify the destination path
    
    try {
        File_Handler.copyFile(sourceFilePath, destinationPath);
        System.out.println("File uploaded successfully.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Failed to upload the file.");
    } finally {
        scanner.close(); // Close the scanner to release resources
    }
    GetText.printTextFile(destinationPath);
    
	}
}
