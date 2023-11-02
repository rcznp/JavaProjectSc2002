package BE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class FilesCreation {
	public static void Logger()
	{
		System.out.println("reading file....");
	}
	public static void copyFile(String sourcePath, String destinationPath) throws IOException {
        Path source = Path.of(sourcePath);
        Path destination = Path.of(destinationPath);

        // Create the directories if they don't exist
        Files.createDirectories(destination.getParent());

        // Copy the file to the destination
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

}
