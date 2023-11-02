
//this is a UI to upload the student and staff txt files

package FE;
import BE.FilesCreation;//abstract away the low-level details of file operations(OOP) using FileHandler
import java.io.IOException;
import java.util.Scanner;
import BE.File_Handler;
public class UploadFiles 
{
	public static void main(String[] args) {
	System.out.println("-------------this is a UI to upload the student and staff txt files----------------");
	System.out.println("-----------------------------");
	Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the path to the text file: ");
    FilesCreation.Logger();
    String sourceFilePath = scanner.nextLine();
    String studentdestinationPath = "BE/students/student_data.txt"; // Specify the destination path
    
    try {
        FilesCreation.copyFile(sourceFilePath, studentdestinationPath);
        System.out.println("File uploaded successfully.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Failed to upload the file.");
    } finally {
        scanner.close(); // Close the scanner to release resources
    }System.out.println("Enter the path to the staff text file: ");
    FilesCreation.Logger();
    String staffSourceFilePath = scanner.nextLine();
    String staffDestinationPath = "BE/staff/staff_data.txt"; // Specify the destination path for staff

    try {
        FilesCreation.copyFile(staffSourceFilePath, staffDestinationPath);
        System.out.println("Staff file uploaded successfully.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Failed to upload the staff file.");
    } finally {
        scanner.close(); // Close the scanner to release resources
    }
    File_Handler.printTextFile(studentdestinationPath);
    
	}
}
