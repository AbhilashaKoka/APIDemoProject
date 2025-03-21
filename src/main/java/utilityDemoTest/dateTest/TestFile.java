package utilityDemoTest.dateTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

    public class TestFile {
        public static void main(String[] args) {
            // Specify the folder and file name
            String folderPath = "C:\\Users\\Abhilasha\\Downloads"; // Change this to your directory
            String fileName = "sampleFile (5).jpeg"; // Change to your target file name
            String newFolderName = "NewFolder"; // New folder to be created

            File folder = new File(folderPath);
            File newFolder = new File(folderPath + "/" + newFolderName);

            // Create new folder if it doesn't exist
            if (!newFolder.exists()) {
                if (newFolder.mkdir()) {
                    System.out.println("New folder created: " + newFolder.getAbsolutePath());
                } else {
                    System.out.println("Failed to create the new folder.");
                    return;
                }
            }

            // Search for the file and move it
            boolean fileFound = false;
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    Path sourcePath = file.toPath();
                    Path destinationPath = new File(newFolder, fileName).toPath();
                    try {
                        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("File moved to: " + destinationPath.toString());
                    } catch (IOException e) {
                        System.err.println("Error moving file: " + e.getMessage());
                    }
                    fileFound = true;
                    break;
                }
            }

            if (!fileFound) {
                System.out.println("File not found: " + fileName);
            }
        }
    }

