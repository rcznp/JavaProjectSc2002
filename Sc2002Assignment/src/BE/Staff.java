package BE;

public class Staff extends User {
    private String staffAttribute; //later change test first
    public Staff(String name, String ntuNetworkId, String faculty) {
        super(name, ntuNetworkId, faculty);
        // Initialize staff-specific attributes...
    }

    public String getStaffAttribute() {
        return staffAttribute;
    }

    public void setStaffAttribute(String staffAttribute) {
        this.staffAttribute = staffAttribute;
    }
    public Camp createCamp(String campName, String dates, String registrationClosingDate, String userGroup, String location,
            int totalSlots, int campCommitteeSlots, String description) 
    {


// Create a new camp with the provided details and set the staff in charge
    	Camp newCamp = new Camp(campName, dates, registrationClosingDate, userGroup, location,
        totalSlots, campCommitteeSlots, description, this);

// Add the new camp to the list of camps managed by this staff
// You can maintain a list of camps associated with the staff for future reference

    	return newCamp;
    }
    static void displayMenu() {
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

    
    
}