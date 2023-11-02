package BE;

import FE.StudentPage;
import java.io.IOException;
//creates the data storage when app starts so can check login credentials
//put it inside MainPage,so when run menu,it will generate out data to compare
import java.util.ArrayList;

public class Server {
	
	public static String StudentFilePath = "/Users/cheongray/Datasc2002/student";
	public static String StaffFilePath = "/Users/cheongray/Datasc2002/staff";//haven't put yet
	private static ArrayList<String> names;
    private static ArrayList<String> emails;
    private static ArrayList<String> faculties;
    private static ArrayList<String> userIDs;
    private static ArrayList<User> usersData;
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
                User user = new User(names.get(i), userIDs.get(i), faculties.get(i));
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
	public User login(String userID, String password) {
        for (User user : usersData) {
            if (user.getNtuNetworkId().equals(userID) && user.getPassword().equals(password)) {
                return user; // Successful login
            }
        }
        return null; // Login failed
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server.start();
	}

}
