package BE;

import java.util.ArrayList;

public class Camp {
    private String campName;
    private String dates;
    private String registrationClosingDate;
    private String userGroup;
    private String location;
    private int totalSlots;
    private int campCommitteeSlots;//max 10
    private int campMemberSlots;
    private String description;
    private Staff staffInCharge; // A reference to the staff member in charge
    private ArrayList<Student> campAttendees;
    private ArrayList<Student> campCommitteeMembers;
	private boolean visible;
	private ArrayList<Inquiry> inquiries;
	

	

    public Camp(String campName, String dates, String registrationClosingDate, String userGroup, String location,
                int totalSlots,String description, Staff staffInCharge,int committeeSlots,Boolean v,int campCommitteeSlots,int campMemberSlots) {
        this.campName = campName;
        this.dates = dates;
        this.registrationClosingDate = registrationClosingDate;
        this.userGroup = userGroup;
        this.location = location;
        this.totalSlots = totalSlots;
        this.campCommitteeSlots = committeeSlots;
        this.description = description;
        this.staffInCharge = staffInCharge;
        this.campAttendees = new ArrayList<>();
        this.campCommitteeMembers = new ArrayList<>();
        this.visible = v;
        this.campCommitteeSlots = campCommitteeSlots;
        this.campMemberSlots = campMemberSlots;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }



    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getRegistrationClosingDate() {
        return registrationClosingDate;
    }

    public void setRegistrationClosingDate(String registrationClosingDate) {
        this.registrationClosingDate = registrationClosingDate;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public int getCampCommitteeSlots() {
        return campCommitteeSlots;
    }

    public void setCampCommitteeSlots(int campCommitteeSlots) {
        this.campCommitteeSlots = campCommitteeSlots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Staff getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(Staff staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public ArrayList<Student> getCampAttendees() {
        return campAttendees;
    }

//    public void setCampAttendees(ArrayList<Student> campAttendees) {
//        this.campAttendees = campAttendees;
//    }

    public ArrayList<Student> getCampCommitteeMembers() {
        return campCommitteeMembers;
    }

//    public void setCampCommitteeMembers(ArrayList<Student> campCommitteeMembers) {
//        this.campCommitteeMembers = campCommitteeMembers;
//    }
    // Method to add a student as a camp attendee
    public void addCampAttendee(Student student) {
        if (campAttendees.size() < totalSlots) {
            campAttendees.add(student);
            campMemberSlots--;
            
        } else {
            System.out.println("Camp is full. Cannot add more attendees.");
        }
    }
    public int getCommitteMembersSize()
    {
    	return campCommitteeMembers.size();
    }

    // Method to add a student as a camp committee member
    public void addCampCommitteeMember(Student student) {
        if (campCommitteeMembers.size() < campCommitteeSlots) {
            campCommitteeMembers.add(student);
            campCommitteeSlots--;
//            System.out.println("added student as Committee Member(Camp.java)");
            
        } else {
            System.out.println("Camp ccommittee is full. Cannot add more members.");
        }
    }
    public void addInquiry(User sender, String message) {
        Inquiry inquiry = new Inquiry(sender, message);
        inquiries.add(inquiry);
    }

    public ArrayList<Inquiry> getInquiries() {
        return inquiries;
    }

    public void replyToInquiry(Inquiry inquiry, String reply) {
        inquiry.setReply(reply);
    }
    public int getAvailableSlots() {
        return campMemberSlots;
    }
    public int getAvailableSlotsForCommitteeMember()
    {
    	return campCommitteeSlots;
    }
    @Override
    public String toString() {
        return "Camp Name: " + campName + "\n" +
               "Dates: " + dates + "\n" +
               "Registration Closing Date: " + registrationClosingDate + "\n" +
               "User Group: " + userGroup + "\n" +
               "Location: " + location + "\n" +
               "Total Slots: " + totalSlots + "\n" +
               "Camp Committee Slots: " + campCommitteeSlots + "\n" +
               "Description: " + description + "\n" +
               "Staff in Charge: " + staffInCharge.getNtuNetworkId() + "\n" +
               "Committee Members: " + campCommitteeMembers.toString() + "\n" +
               "Camp Attendees: " + campAttendees.toString() + "\n";
    }


}

