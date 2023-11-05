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
            int totalSlots, String description,int committeeSlots,boolean v,int campComitteeSlots,int campMemberSlots) 
    {


// Create a new camp with the provided details and set the staff in charge
    	Camp newCamp = new Camp(campName, dates, registrationClosingDate, userGroup, location,
        totalSlots,description, this,committeeSlots,v,campComitteeSlots,campMemberSlots);

// Add the new camp to the list of camps managed by this staff
// You can maintain a list of camps associated with the staff for future reference

    	return newCamp;
    }
    public void toggleCampVisibility(Camp camp) {
        camp.setVisible(!camp.isVisible());
    }
    

    
    
}