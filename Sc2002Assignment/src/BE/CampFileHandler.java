package BE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CampFileHandler {
    public static void saveCampsToTextFile(List<Camp> camps, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Camp camp : camps) {
                // Write camp data to the TXT file
                writer.write("Camp Name: " + camp.getCampName() + "\n");
                writer.write("Dates: " + camp.getDates() + "\n");
                writer.write("Registration Closing Date: " + camp.getRegistrationClosingDate() + "\n");
                writer.write("User Group: " + camp.getUserGroup() + "\n");
                writer.write("Location: " + camp.getLocation() + "\n");
                writer.write("Total Slots: " + camp.getTotalSlots() + "\n");
                writer.write("Camp Committee Slots: " + camp.getCampCommitteeSlots() + "\n");
                writer.write("Description: " + camp.getDescription() + "\n");
                writer.write("Staff in Charge: " + camp.getStaffInCharge().getNtuNetworkId() + "\n");
                writer.write("\n"); // Add a separator between camps
            }
        } catch (IOException e) {
            System.err.println("Error saving camp data to TXT: " + e.getMessage());
        }
    }
}
