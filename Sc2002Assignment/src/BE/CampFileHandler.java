package BE;


import java.beans.Visibility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CampFileHandler {
	private static ArrayList<Camp> camps;
	public static String StudentFilePath = "/Users/cheongray/Datasc2002/student";
	public static String StaffFilePath = "/Users/cheongray/Datasc2002/staff";
	public static String CampsFilePath = "/Users/cheongray/Datasc2002/campData";
	public static String CampsFilePathWithMembers = "/Users/cheongray/Datasc2002/campDataWithMembers";
	private static ArrayList<String> names;
    private static ArrayList<String> emails;
    private static ArrayList<String> faculties;
    private static ArrayList<String> userIDs;
    private static ArrayList<User> usersData;
	
	//overwrite the whole thing using the newest Camps
	public static void saveCampsToTextFile_2(ArrayList<Camp> camps, String filePath) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        for (Camp camp : camps) {
	            // Write camp data to the TXT file
	        	writer.write("Visibility: " + camp.isVisible() + "\n");
	            writer.write("Camp Name: " + camp.getCampName() + "\n");
	            writer.write("Dates: " + camp.getDates() + "\n");
	            writer.write("Registration Closing Date: " + camp.getRegistrationClosingDate() + "\n");
	            writer.write("User Group: " + camp.getUserGroup() + "\n");
	            writer.write("Location: " + camp.getLocation() + "\n");
	            writer.write("Total Slots: " + camp.getTotalSlots() + "\n");
	            writer.write("Camp Committee Slots: " + camp.getCampCommitteeSlots() + "\n");
	            writer.write("Description: " + camp.getDescription() + "\n");
	            writer.write("Staff in Charge: " + camp.getStaffInCharge().getNtuNetworkId() + "\n");
	            
	            // Add Committee Members and Camp Attendees
//	            writer.write("Committee Members: " + camp.getCampCommitteeMembers().toString() + "\n");
	            writer.write("Committee Members: ");
	            if (camp.getCommitteMembersSize()==0)
	            {
	            	 writer.write("Camp Members: " + camp.getCampCommitteeMembers().toString()+"\n");
	            }
	            ArrayList<Student> committeeMembers = camp.getCampCommitteeMembers();
	            
	            
	            for (int i = 0; i < committeeMembers.size(); i++) {
	                writer.write(committeeMembers.get(i).getNtuNetworkId()); // Write the ID(more unique than name
	                if (i < committeeMembers.size() - 1) {
	                    writer.write(", "); // Add a comma and space if not the last member
	                }
	                
	                else {
	                    writer.write("\n"); // Add a newline character after the last member
	                }
	            }

	            writer.write("Camp Attendees: " + camp.getCampAttendees().toString()+"\n");
//	            System.out.println("Camp Attendees for Camp " + camp.getCampName() + ":");
//	            for (Student attendee : camp.getCampAttendees()) {
//	                System.out.println("Student Name: " + attendee.getName());
//	                System.out.println("Student ID: " + attendee.getNtuNetworkId());
//	                
//	                System.out.println("---------------");
//	            }

	            
//	            System.out.println("-Camp Committee Members for Camp " + camp.getCampName() + ": " + camp.getCampCommitteeMembers().toString());
	            
	            
	            writer.write("\n"); // Add a separator between camps
	        }
	    } catch (IOException e) {
	        System.err.println("Error saving camp data to TXT: " + e.getMessage());
	    }
	}

	
	
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
    //get from text file
    public static  ArrayList<Camp>loadCampsFromFile(String filePath,ArrayList<User> usersData) throws FileNotFoundException {
    	    try {
    	    	//rmb change this
    	        Scanner s = new Scanner(new File("/Users/cheongray/Datasc2002/campDataWithMembers"));
    	        ArrayList<Camp> camps = new ArrayList<>();
    	        while (s.hasNext()) {
    	            // Read camp data from the file
    	        	String visibility = s.nextLine().replace("Visibility: ", "");
    	        	
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
    	            String CM = s.nextLine().replace("Committee Members: ", "");
    	            String CA = s.nextLine().replace("Committee Attendees: ", "");

    	            
    	            
    	            //find user object
    	            
    	           
    	          
    	            s.nextLine(); // Skip the empty line
    	            //to create camps array,need camps objects.to create camps object need a staff object to call createcamps()
    	            //usersData stores all the objects for staff and student(refer to login in serve.java
    	            //so i need to find the staffname in usersdata again to get the staff object
    	            //same for  Attendees and member
    	            
    	            for (User user : usersData) {
    	                if (user instanceof Staff && user.getNtuNetworkId().equals(staffInCharge)) {
    	                    Staff staff = (Staff) user; // Cast the user to Staff
    	                    
    	                    
    	                    Camp camp = staff.createCamp(campName, dates, registrationClosingDate, userGroup, location, totalSlots, description, campCommitteeSlots,Boolean.parseBoolean(visibility));
    	                    
    	                    
    	                   
    	                    // Add camp attendees to the camp
    	                    String[] cm_array = CM.trim().split(",\\s*");
    	                    String[] ca_array = CM.trim().split(",\\s*");
    	                   
    	                    for (String MemberID : cm_array) {
    	                        // Search for the Student object in usersData based on the attendeeName
    	                    	//go thru userDat again to find the corresponding user with that name
    	                    	for (User user1 : usersData) {
    	                    	    if (user1 instanceof Student && user1.getNtuNetworkId().equals(MemberID)) {
    	                    	        // Found a matching Student by name
    	                    	        Student mem = (Student) user1; // Cast to Student
    	                    	        camp.addCampCommitteeMember(mem);
//    	                    	        System.out.println("inside CampFilhandler");
//    	                    	        System.out.println(mem.getNtuNetworkId());
    	                    	        break; // Exit the loop since you found the attendee
    	                    	    }
    	                    	}

    	                    }
    	                    
    	                    for (String AttendeeID : ca_array) {
    	                        for (User user1 : usersData) {
    	                            if (user1 instanceof Student && user1.getNtuNetworkId().equals(AttendeeID)) {
    	                                Student attendee = (Student) user1; // Cast to Student
    	                                camp.addCampAttendee(attendee);
    	                                break; // Exit the loop since you found the member
    	                            }
    	                        }
    	                    }

    	                    // Add the camp to the list of camps
    	                    camps.add(camp);
    	                }
    	            }
//    	            for (User user:usersData)
//    	            {
//    	            	if(user instanceof Student && user.get)
//    	            }
    	            
    	            
    	            
    	        }
    	        
    	        
    	        s.close(); // Close the scanner when done
    	        return camps;
    	    } catch (FileNotFoundException e) {
    	        System.err.println("Error loading camp data from file: " + e.getMessage());
    	    }
			return camps;
        }
    ///BELOW is all for testing ignore
    
    public static void printCampsFromFile(String filePath) {//for debugging my txt file
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
	            System.out.println("Int of total slots "+totalSlots);
	            String description = s.nextLine().replace("Description: ", "");
	            String staffInCharge = s.nextLine().replace("Staff in Charge: ", "");
	            
	            String CM = s.nextLine().replace("Committee Members: ", "");
	            String CA = s.nextLine().replace("Committee Attendees: ", "");
	            String input = "[Name: CHERN, Student ID: YCHERN]";
	            String name = null;
	            String studentID = null;
	            //parse the string test
	            Pattern pattern = Pattern.compile("Name: (\\w+), Student ID: (\\w+)");
	            Matcher matcher = pattern.matcher(input);

	            if (matcher.find()) {
	                name = matcher.group(1);
	                studentID = matcher.group(2);
	            }
	            System.out.println("--------------------------------");
	            System.out.println("Name: " + name);
	            System.out.println("Student ID: " + studentID);
	            System.out.println("--------------------------------");
	        
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
	            System.out.println("CM: "+CM);
	            System.out.println("CA: "+CA);
            }
            

            s.close(); // Close the scanner when done
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    public static User getObj(ArrayList<User> usersData,String name)
    {
    	for (User user:usersData)
        {
        	if(user instanceof Student && user.getName().equalsIgnoreCase(name))
        	{
        		return user;
        	}
        }
    	return null;
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

   
    	public static void main(String[] args) {
//    	    String filePath = "/Users/cheongray/Datasc2002/campDataWithMembers"; 
//    	    try {
//    	    	start();
//				ArrayList<Camp> camps = CampFileHandler.loadCampsFromFile(filePath,usersData);
//				System.out.println(camps.toString());
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    		String filePath = "/Users/cheongray/Datasc2002/campDataWithMembers"; 
//    		printCampsFromFile(filePath);
    	}

    	
 
    }