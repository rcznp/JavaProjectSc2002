package BE;
import java.io.FileNotFoundException;
import java.io.IOException;
//creates the data storage when app starts so can check login credentials
//delete camps from the server
//put it inside MainPage,so when run menu,it will generate out data to compare the userID and password
import java.util.ArrayList;

public class Server {
	
	public static String StudentFilePath = "/Users/cheongray/Datasc2002/student";
	public static String StaffFilePath = "/Users/cheongray/Datasc2002/staff";
	public static String CampsFilePath = "/Users/cheongray/Datasc2002/campData";
	private static ArrayList<String> names;
    private static ArrayList<String> emails;
    private static ArrayList<String> faculties;
    private static ArrayList<String> userIDs;
    private static ArrayList<User> usersData;
    private static ArrayList<Camp> camps; // Maintain a list of camps
    public Server()
    {
    	start();
    }
	public static void start()
	{
		ArrayList<ArrayList<String>> dataFromFileHandler = new ArrayList<>();
		names = new ArrayList<>();
        emails = new ArrayList<>();
        faculties = new ArrayList<>();
        userIDs = new ArrayList<>();
        usersData = new ArrayList<>();
        

		try {
            dataFromFileHandler=File_Handler.PutFileContentIntoArray(StudentFilePath);
            names = dataFromFileHandler.get(0);
            emails = dataFromFileHandler.get(1);
            faculties = dataFromFileHandler.get(2);
            userIDs = dataFromFileHandler.get(3);
            
            
            //server is an arraylist of User objects
            for (int i = 0; i < names.size(); i++) {
                User user = new Student(names.get(i), userIDs.get(i), faculties.get(i));
                usersData.add(user);
            }
            dataFromFileHandler=File_Handler.PutFileContentIntoArray(StaffFilePath);
            names = dataFromFileHandler.get(0);
            emails = dataFromFileHandler.get(1);
            faculties = dataFromFileHandler.get(2);
            userIDs = dataFromFileHandler.get(3);
            
            
            //server is an arraylist of User objects
            for (int i = 0; i < names.size(); i++) {
                User user = new Staff(names.get(i), userIDs.get(i), faculties.get(i));
                usersData.add(user);
            }
            loadTxTtoCamps(CampsFilePath, usersData);
            
//            for (User user : usersData) {
//                System.out.println("Name: " + user.getName());
//                System.out.println("NTU Network ID: " + user.getNtuNetworkId());
//                System.out.println("Faculty: " + user.getFaculty());
//                System.out.println("password:" + user.getPassword());
//                System.out.println("--------");
//            }
//            
        
//            
        } catch(IOException e){
//   		 System.err.println("An error occurred while reading the file: " + e.getMessage());
//   	}
	}
	}
	public User login(String userID, String password) {
	    for (User user : usersData) {
	        if (user.getNtuNetworkId().equals(userID) && user.getPassword().equals(password)) {
	            if (user instanceof Student) {
	                // User is a student
	                return user; 
	            } else if (user instanceof Staff) {
	                // User is a staff
	                return user; 
	            }
	        }
	    }
	    return null; // Login failed
	}
	public Camp createCamp(Staff staff, String campName, String dates, String registrationClosingDate, String userGroup, String location,
            int totalSlots, int campCommitteeSlots, String description) {
        // Create a new camp using the provided details
        Camp newCamp = staff.createCamp(campName, dates, registrationClosingDate, userGroup, location, totalSlots, campCommitteeSlots, description);

        // Add the new camp to the list of camps
        camps.add(newCamp);
        System.out.println("Camp created!");
        saveCampsToTxtFile(CampsFilePath);
        return newCamp;
    }
	public boolean deleteCamp(Camp camp) {
        // Check if the camp exists in the list of camps
        if (camps.contains(camp)) {
            // Remove the camp from the list
            camps.remove(camp);
            saveCampsToTxtFile(CampsFilePath);
            return true; // Deletion successful
        }

        return false; // Camp not found
    }
	public boolean editCamp(Camp camp, String campName, String dates, String registrationClosingDate, String userGroup, String location,
            int totalSlots, int campCommitteeSlots, String description) {
        // Check if the camp exists in the list of camps
        if (camps.contains(camp)) {
            // Update the camp details
            camp.setCampName(campName);
            camp.setDates(dates);
            camp.setRegistrationClosingDate(registrationClosingDate);
            camp.setUserGroup(userGroup);
            camp.setLocation(location);
            camp.setTotalSlots(totalSlots);
            camp.setCampCommitteeSlots(campCommitteeSlots);
            camp.setDescription(description);
            saveCampsToTxtFile(CampsFilePath);
            return true; // Edit successful
        }

        return false; // Camp not found
    }
	public Camp findCampByName(String campName) {
	    for (Camp camp : camps) {
	        if (camp.getCampName().equals(campName)) {
	            return camp;
	        }
	    }
	    return null; // Camp not found
	
	  
	}
	public ArrayList<Camp> getAllCamps(){
		return camps;
	}
	public ArrayList<Camp> getAllAvailableCamps(User user){
		ArrayList<Camp> availableCamps = new ArrayList<>();
		for (Camp camp : camps) {
	        // Check if the camp has available slots and the user's faculty matches the camp's user group
	        if (camp.getAvailableSlots() > 0 && camp.getUserGroup().equalsIgnoreCase(user.getFaculty())||
	                camp.getUserGroup().equalsIgnoreCase("NTU")) {
	            availableCamps.add(camp);
	        }
	    }
		return availableCamps;
		
	}
	public ArrayList<Camp> getCampsCreatedByUser(User user) {//must check if User is staff(add)
	    ArrayList<Camp> userCreatedCamps = new ArrayList<>();
	    for (Camp camp : camps) {
	        if (camp.getStaffInCharge().equals(user)) {
	            userCreatedCamps.add(camp);
	        }
	    }
	    return userCreatedCamps;
	}
	public void saveCampsToTxtFile(String filePath) {
        CampFileHandler.saveCampsToTextFile(camps, filePath);
    }
	public static void loadTxTtoCamps(String filePath,ArrayList<User> usersData)
	{
		try {
			camps = CampFileHandler.loadCampsFromFile(filePath, usersData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server.start();
		
	}
	

}
