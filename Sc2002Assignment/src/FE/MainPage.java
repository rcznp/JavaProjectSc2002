package FE;
import java.util.ArrayList;
import java.util.Scanner;
import BE.Server;
import BE.Staff;
import BE.Student;
import BE.User;
import BE.Camp;
import BE.Inquiry;
//remember to use server(BE) to generate the server(server will just be arraylist of Users  storing details)
public class MainPage {

	private static Server serverInstance;
	public MainPage() {
        //new instance of server for every new page
		serverInstance = new Server();
    }
	public static void main(String[] args) 
	{
		MainPage M = new MainPage();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------Camp Application and Management System (CAMs).----------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("UserID:");
		String UserID= scanner.nextLine();
		System.out.println("Password:");
		String Password= scanner.nextLine();
		User loggedInUser = serverInstance.login(UserID, Password);
		
		if (loggedInUser != null) {
			if (loggedInUser instanceof Student) {
		        System.out.println("Login successful. User is a student.Welcome: " + loggedInUser.getName());
		        while(true) 
		        {
		        	loggedInUser.displayMenu();
		        	int choice = scanner.nextInt();

		            switch (choice) {
		            case 1:
		                // View available camps by faculty and visibility toggle
		                ArrayList<Camp> availableCamps = serverInstance.getAllAvailableCamps(loggedInUser);
		                
		                if (availableCamps.isEmpty()) {
		                    System.out.println("There are no available camps for your faculty.");
		                } else {
		                    System.out.println("Available camps for you:");
		                    for (Camp camp : availableCamps) {
		                        System.out.println("Camp Name: " + camp.getCampName());
		                        System.out.println("Dates: " + camp.getDates());
		                        System.out.println("Location: " + camp.getLocation());
		                        System.out.println("Vaccancy" + camp.getAvailableSlots());
		                        // Add more camp details as needed
		                        System.out.println("--------------------------------");
		                    }
		                }
		                break;
		            case 2:
		            	availableCamps= serverInstance.getAllAvailableCamps(loggedInUser);
		            	System.out.println("Available camps for you:");
		                if (availableCamps.isEmpty()) {
		                    System.out.println("There are no available camps for your faculty.");
		                } else {
		                    System.out.println("Available camps for you:");
		                    for (Camp camp : availableCamps) {
		                        System.out.println("Camp Name: " + camp.getCampName());
		                        System.out.println("Dates: " + camp.getDates());
		                        System.out.println("Location: " + camp.getLocation());
		                        System.out.println("Vaccancy" + camp.getAvailableSlots());
		                        // Add more camp details as needed
		                        System.out.println("--------------------------------");
		                    }
		                }
		            	System.out.println("Enter camp name you wish to join:");
		            	String campName = scanner.nextLine();
		            	System.out.println("Do you wish to join as a camp attendee or committee member?:");
		            	System.out.println("Enter 1 for camp attendee and 0 for committee member");
		            	int c = scanner.nextInt();
		            }
		            break;
		        }
		        
        } 
			else if (loggedInUser instanceof Staff) {
		        System.out.println("Login successful. User is a staff.Welcome: " + loggedInUser.getName());
		        while(true) 
		        {
		        	loggedInUser.displayMenu();
		        	
		        	int choice = scanner.nextInt();
		        	String clear = scanner.nextLine();//clear out the extra "\n"

		            switch (choice) {
		                case 1:
		                	System.out.println("Enter the camp name: ");
		                    String campName = scanner.nextLine();
		                    
		                    System.out.println("Enter the dates: ");
		                    String dates = scanner.nextLine();
		                    
		                    System.out.println("Enter the registration closing date: ");
		                    String registrationClosingDate = scanner.nextLine();
		                    
		                    System.out.println("Enter the user group(own school or whole of NTU): ");
		                    String userGroup = scanner.nextLine();
		                    
		                    System.out.println("Enter the location: ");
		                    String location = scanner.nextLine();
		                    
		                    System.out.println("Enter the total slots: ");
		                    int totalSlots = scanner.nextInt();
		                    
		                    System.out.println("Enter the camp committee slots: ");
		                    int campCommitteeSlots = scanner.nextInt();
		                    
		                    scanner.nextLine(); // Consume newline
		                    
		                    System.out.println("Enter the description: ");
		                    String description = scanner.nextLine();
		                    serverInstance.createCamp((Staff) loggedInUser, campName, dates, registrationClosingDate, userGroup, location, totalSlots, campCommitteeSlots, description);
		                    
		                    
		                    break;
		                case 2:
		                    // Edit an existing camp
		                    System.out.println("Enter the camp name of the camp you want to edit: ");
		                    String campToEdit = scanner.nextLine();
		                    Camp campEDIT = serverInstance.findCampByName(campToEdit);

		                    System.out.println("Enter the new camp name: ");
		                    String newCampName = scanner.nextLine();
		                    
		                    System.out.println("Enter the new dates: ");
		                    String newDates = scanner.nextLine();
		                    
		                    System.out.println("Enter the new registration closing date: ");
		                    String newRegistrationClosingDate = scanner.nextLine();
		                    
		                    System.out.println("Enter the new user group (own school or whole of NTU): ");
		                    String newUserGroup = scanner.nextLine();
		                    
		                    System.out.println("Enter the new location: ");
		                    String newLocation = scanner.nextLine();
		                    
		                    System.out.println("Enter the new total slots: ");
		                    int newTotalSlots = scanner.nextInt();
		                    
		                    System.out.println("Enter the new camp committee slots: ");
		                    int newCampCommitteeSlots = scanner.nextInt();
		                    
		                    scanner.nextLine(); // Consume newline
		                    
		                    System.out.println("Enter the new description: ");
		                    String newDescription = scanner.nextLine();
		                    
		                    serverInstance.editCamp(campEDIT, newCampName, newDates, newRegistrationClosingDate, newUserGroup, newLocation, newTotalSlots, newCampCommitteeSlots, newDescription);

		                    break;
		                case 3:
		                    // Delete a camp
		                    System.out.println("Enter the camp name of the camp you want to delete: ");
		                    String campToDelete = scanner.nextLine();

		                    Camp campDelete = serverInstance.findCampByName(campToDelete);

		                    if (campDelete != null) {
		                        // Camp found, proceed with deletion
		                        boolean deletionResult = serverInstance.deleteCamp(campDelete);

		                        if (deletionResult) {
		                            System.out.println("Camp deleted successfully.");
		                        } else {
		                            System.out.println("Failed to delete the camp.");
		                        }
		                    } else {
		                        System.out.println("Camp not found.");
		                    }
		                    break;
		                case 4:
		                    // Toggle camp visibility
		                    System.out.println("Enter the camp name of the camp you want to toggle visibility for: ");
		                    String campToToggleVisibility = scanner.nextLine();

		                    Camp campToToggle = serverInstance.findCampByName(campToToggleVisibility);

		                    if (campToToggle != null) {
		                        System.out.println("Do you want to make the camp visible (1) or invisible (0)? Enter 1 or 0: ");
		                        int visibilityChoice = scanner.nextInt();

		                        if (visibilityChoice == 0 || visibilityChoice == 1) {
		                            boolean isVisible = (visibilityChoice == 1);//if 1 means that this is true,so isVisble=1
		                            campToToggle.setCampVisibility(isVisible);
		                            System.out.println("Camp visibility toggled successfully.");
		                        } else {
		                            System.out.println("Invalid choice. Please enter 1 for visible or 0 for invisible.");
		                        }
		                    } else {
		                        System.out.println("Camp not found.");
		                    }
		                    break;
		                case 5:
		                    // View all camps
		                    ArrayList<Camp> allCamps = serverInstance.getAllCamps();
		                    
		                    if (allCamps.isEmpty()) {
		                        System.out.println("There are no camps to display.");
		                    } else {
		                        System.out.println("List of all camps:");
		                        for (Camp camp : allCamps) {
		                            System.out.println("Camp Name: " + camp.getCampName());
		                            System.out.println("Dates: " + camp.getDates());
		                            System.out.println("Location: " + camp.getLocation());
		                            // Add more camp details as needed
		                            System.out.println("--------------------------------");
		                        }
		                    }
		                    break;
		                case 6:
		                    // View camps created by the logged-in user
		                    ArrayList<Camp> userCreatedCamps = serverInstance.getCampsCreatedByUser(loggedInUser);

		                    if (userCreatedCamps.isEmpty()) {
		                        System.out.println("You haven't created any camps yet.");
		                    } else {
		                        System.out.println("Camps created by " + loggedInUser.getName() + ":");
		                        for (Camp camp : userCreatedCamps) {
		                            System.out.println("Camp Name: " + camp.getCampName());
		                            System.out.println("Dates: " + camp.getDates());
		                            System.out.println("Location: " + camp.getLocation());
		                            // Add more camp details as needed
		                            System.out.println("--------------------------------");
		                        }
		                    }
		                    break;
		   
		                case 7:
		                    // View and reply to inquiries
		                	ArrayList<Camp> userCreatedCamps_forInquiry = serverInstance.getCampsCreatedByUser(loggedInUser);
		                    ArrayList<Inquiry> allInquiries = new ArrayList<>();
		                    
		                    // Loop through the camps created by the logged-in user
		                    for (Camp camp : userCreatedCamps_forInquiry) {
		                        // Get the inquiries for the current camp
		                        ArrayList<Inquiry> campInquiries = camp.getInquiries();
		                        
		                        // Display camp name and details
		                        System.out.println("Camp Name: " + camp.getCampName());
		                        System.out.println("Dates: " + camp.getDates());
		                        System.out.println("Location: " + camp.getLocation());
		                        // Add more camp details as needed
		                        System.out.println("--------------------------------");
		                        
		                        // Check if the camp has inquiries
		                        if (campInquiries.isEmpty()) {
		                            System.out.println("No inquiries for this camp.");
		                        } else {
		                            System.out.println("Inquiries for this camp:");
		                            // Loop through the inquiries for the current camp
		                            for (Inquiry inquiry : campInquiries) {
		                                // Display inquiry details
		                                System.out.println("Sender: " + inquiry.getSender());
		                                System.out.println("Message: " + inquiry.getMessage());
		                                // Add more inquiry details as needed
		                                System.out.println("--------------------------------");
		                                
		                                // Add the inquiry to the list of all inquiries
		                                allInquiries.add(inquiry);
		                            }
		                        }
		                    }
		                    
		                    
		                    break;





		            }
		        }
		        
		    }
		}else {
            System.out.println("Login failed. Please check your credentials.");
        }
		
		
		scanner.close();

	}

}
