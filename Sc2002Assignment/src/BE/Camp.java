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

    public void addCampAttendee(Student student) {
        if (campAttendees.size() < totalSlots) {
            campAttendees.add(student);
        }
    }

    public void addCampCommitteeMember(Student student) {
        if (campCommitteeMembers.size() < campCommitteeSlots) {
            campCommitteeMembers.add(student);
        }
    }

    public ArrayList<Student> getCampAttendees() {
        return campAttendees;
    }

    public ArrayList<Student> getCampCommitteeMembers() {
        return campCommitteeMembers;
    }
}

