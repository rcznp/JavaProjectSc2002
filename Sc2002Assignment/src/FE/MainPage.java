package FE;
import java.util.Scanner;
import BE.Server;
import BE.Staff;
import BE.Student;
import BE.User;

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
		        
        } 
			else if (loggedInUser instanceof Staff) {
		        System.out.println("Login successful. User is a staff.Welcome: " + loggedInUser.getName());
		        while(true) 
		        {
		        	loggedInUser.displayMenu();
		        	
		        	int choice = scanner.nextInt();

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
