package BE;

public class User {
    private String name;
    private String ntuNetworkId;
    private String password;
    private String faculty;

    public User(String name, String ntuNetworkId, String faculty) {
        this.name = name;
        this.ntuNetworkId = ntuNetworkId;
        this.password = "password";//default password
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNtuNetworkId() {
        return ntuNetworkId;
    }

    public void setNtuNetworkId(String ntuNetworkId) {
        this.ntuNetworkId = ntuNetworkId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void displayMenu() {
    	if (this instanceof Staff) 
    	{
        System.out.println("------------- Staff Menu -------------");
        System.out.println("1. Create a new camp");
        System.out.println("2. Edit an existing camp");
        System.out.println("3. Delete a camp");
        System.out.println("4. Toggle camp visibility");
        System.out.println("5. View all camps");
        System.out.println("6. View my created camps");
        System.out.println("7. View and reply to enquiries");
        System.out.println("8. View and approve suggestions");
        System.out.println("9. Generate a report");
        System.out.println("10. Generate a performance report");
        System.out.println("11. Exit");
        System.out.print("Please enter the number of your choice: ");
    	}
    	else if (this instanceof Student)
    	{
		System.out.println("------------- Student Menu -------------");
	    System.out.println("1. View available camps");
	    System.out.println("2. Select camps to register as camp attendee or committee");
	    System.out.println("3. Submit an enquiry for a camp");
	    System.out.println("4. View registered camps");
	    System.out.println("5. View and reply to enquiries");
	    System.out.println("6. Request to withdraw from camps");
	    System.out.println("7. Exit");
	    System.out.print("Please enter the number of your choice: ");
    	}
    	}
}
