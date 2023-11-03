package BE;

import java.util.ArrayList;

public class Student extends User {
	private boolean isCommitteeMember;
	public Student(String name, String ntuNetworkId, String faculty) {
		super(name, ntuNetworkId, faculty);
		// TODO Auto-generated constructor stub
		this.isCommitteeMember = false;
	}
	public Student findStudentByUsername(ArrayList<User> usersData, String username) {
	    for (User user : usersData) {
	        if (user instanceof Student && user.getNtuNetworkId().equals(username)) {
	            return (Student) user; // If found, return the Student object
	        }
	    }
	    return null; // If not found, return null
	}
	public boolean isCommitteeMember() {
        return isCommitteeMember;
    }

    public void setCommitteeMember(boolean committeeMember) {
        isCommitteeMember = committeeMember;
    }
    @Override
    public String toString() {
        return "Name: " + getName() + ", Student ID: " + getNtuNetworkId();
    }
	

	
}
