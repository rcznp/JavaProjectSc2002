package FE;
import java.util.Scanner;
import BE.Server;
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
            System.out.println("Login successful. User: " + loggedInUser.getName());
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
		
		
		scanner.close();

	}

}
