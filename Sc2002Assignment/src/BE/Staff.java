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

    
}