package BE;

import java.util.ArrayList;

public class Camp {
    private String campName;
    private String dates;
    private String registrationClosingDate;
    private String userGroup;
    private String location;
    private int totalSlots;
    private int campCommitteeSlots;
    private String description;
    private Staff staffInCharge; // A reference to the staff member in charge
    private ArrayList<Student> campAttendees;
    private ArrayList<Student> campCommitteeMembers;

    public Camp(String campName, String dates, String registrationClosingDate, String userGroup, String location,
                int totalSlots, int campCommitteeSlots, String description, Staff staffInCharge) {
        this.campName = campName;
        this.dates = dates;
        this.registrationClosingDate = registrationClosingDate;
        this.userGroup = userGroup;
        this.location = location;
        this.totalSlots = totalSlots;
        this.campCommitteeSlots = campCommitteeSlots;
        this.description = description;
        this.staffInCharge = staffInCharge;
        this.campAttendees = new ArrayList<>();
        this.campCommitteeMembers = new ArrayList<>();
    }

    // Getters and setters for the camp's attributes

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

    public void setCampAttendees(ArrayList<Student> campAttendees) {
        this.campAttendees = campAttendees;
    }

    public ArrayList<Student> getCampCommitteeMembers() {
        return campCommitteeMembers;
    }

    public void setCampCommitteeMembers(ArrayList<Student> campCommitteeMembers) {
        this.campCommitteeMembers = campCommitteeMembers;
    }
    // Method to add a student as a camp attendee
    public void addCampAttendee(Student student) {
        if (campAttendees.size() < totalSlots) {
            campAttendees.add(student);
        } else {
            System.out.println("Camp is full. Cannot add more attendees.");
        }
    }

    // Method to add a student as a camp committee member
    public void addCampCommitteeMember(Student student) {
        if (campCommitteeMembers.size() < campCommitteeSlots) {
            campCommitteeMembers.add(student);
        } else {
            System.out.println("Camp committee is full. Cannot add more members.");
        }
    }

}

