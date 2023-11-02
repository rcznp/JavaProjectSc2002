package BE;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampFileHandler {
	private static ArrayList<Camp> camps = new ArrayList<>();
    public static void saveCampsToTextFile(List<Camp> camps, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Camp camp : camps) {
                // Write camp data to the TXT file
                writer.write("Camp Name: " + camp.getCampName() + "\n");
                writer.write("Dates: " + camp.getDates() + "\n");
                writer.write("Registration Closing Date: " + camp.getRegistrationClosingDate() + "\n");
                writer.write("User Group: " + camp.getUserGroup() + "\n");
                writer.write("Location: " + camp.getLocation() + "\n");
                writer.write("Total Slots: " + camp.getTotalSlots() + "\n");
                writer.write("Camp Committee Slots: " + camp.getCampCommitteeSlots() + "\n");
                writer.write("Description: " + camp.getDescription() + "\n");
                writer.write("Staff in Charge: " + camp.getStaffInCharge().getNtuNetworkId() + "\n");
                writer.write("\n"); // Add a separator between camps
            }
        } catch (IOException e) {
            System.err.println("Error saving camp data to TXT: " + e.getMessage());
        }
    }
    public static  ArrayList<Camp>loadCampsFromFile(String filePath,ArrayList<User> usersData) throws FileNotFoundException {
    	    try {
    	        Scanner s = new Scanner(new File(filePath));

    	        while (s.hasNext()) {
    	            // Read camp data from the file
    	        	String campName = s.nextLine().replace("Camp Name: ", "");
    	            String dates = s.nextLine().replace("Dates: ", "");
    	            String registrationClosingDate = s.nextLine().replace("Registration Closing Date: ", "");
    	            String userGroup = s.nextLine().replace("User Group: ", "");
    	            String location = s.nextLine().replace("Location: ", "");
    	            String totalSlotsLine = s.nextLine().replace("Total Slots: ", "");
    	            String campCommitteeSlotsLine = s.nextLine().replace("Camp Committee Slots: ", "");
    	            int totalSlots = Integer.parseInt(totalSlotsLine);
    	            int campCommitteeSlots = Integer.parseInt(campCommitteeSlotsLine);
    	           
    	            String description = s.nextLine().replace("Description: ", "");
    	            String staffInCharge = s.nextLine().replace("Staff in Charge: ", "");
    	            s.nextLine(); // Skip the empty line
    	            //to create camps array,need camps objects.to create camps object need a staff object to call createcamps()
    	            //usersData stores all the objects for staff and student(refer to login in serve.java
    	            //so i need to find the staffname in usersdata again
    	            
    	            for (User user : usersData) {
    	            	if (user instanceof Staff && user.getNtuNetworkId().equals(staffInCharge)) {
    	                    Staff staff = (Staff) user; // Cast the user to Staff
    	                    Camp camp = staff.createCamp(campName, dates, registrationClosingDate, userGroup, location, totalSlots, campCommitteeSlots, description);
    	                    
    	                    camps.add(camp);
    	            	}
    	            }
    	            
    	            
    	            
    	        }
    	        
    	        
    	        s.close(); // Close the scanner when done
    	        return camps;
    	    } catch (FileNotFoundException e) {
    	        System.err.println("Error loading camp data from file: " + e.getMessage());
    	    }
			return camps;
        }
    public static void printCampsFromFile(String filePath) {//for debugging
        try {
            Scanner s = new Scanner(new File(filePath));

            while (s.hasNext()) {
            	
            	String campName = s.nextLine().replace("Camp Name: ", "");
	            String dates = s.nextLine().replace("Dates: ", "");
	            String registrationClosingDate = s.nextLine().replace("Registration Closing Date: ", "");
	            String userGroup = s.nextLine().replace("User Group: ", "");
	            String location = s.nextLine().replace("Location: ", "");
	            String totalSlotsLine = s.nextLine().replace("Total Slots: ", "");
	            String campCommitteeSlotsLine = s.nextLine().replace("Camp Committee Slots: ", "");
	            int totalSlots = Integer.parseInt(totalSlotsLine);
	            int campCommitteeSlots = Integer.parseInt(campCommitteeSlotsLine);
	            String description = s.nextLine().replace("Description: ", "");
	            String staffInCharge = s.nextLine().replace("Staff in Charge: ", "");
	            s.nextLine(); // Skip the empty line
	            System.out.println("Camp Name: " + campName);
	            System.out.println("Dates: " + dates);
	            System.out.println("Registration Closing Date: " + registrationClosingDate);
	            System.out.println("User Group: " + userGroup);
	            System.out.println("Location: " + location);
	            System.out.println("Total Slots: " + totalSlotsLine);
	            System.out.println("Camp Committee Slots: " + campCommitteeSlotsLine);
	            System.out.println("Description: " + description);
	            System.out.println("Staff in Charge: " + staffInCharge);
            }
            

            s.close(); // Close the scanner when done
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

   
//    	public static void main(String[] args) {
//    	    String filePath = "/Users/cheongray/Datasc2002/campData"; 
//    	    CampFileHandler.printCampsFromFile(filePath);
//    	}

    	
 
    }
