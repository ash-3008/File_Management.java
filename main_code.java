import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Define a constant Path for logging operations to "operation_log.txt".
public class FileUtility {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Path logPath = Paths.get("operation_log.txt");

    public static void main(String[] args) {
        int choice = 0;  // Initialize to avoid compilation error

        //Handle invalid input using try-catch for `NumberFormatException` and skip iteration on error.
        do {
            System.out.println("\n=== FILE HANDLING UTILITY ===");
            System.out.println("1. Read File");
            System.out.println("2. Write to File");
            System.out.println("3. Append to File");
            System.out.println("4. Delete File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue; // Restart loop on invalid input
            }

            switch (choice) {
                case 1 -> readFile();
                case 2 -> writeFile();
                case 3 -> appendFile();
                case 4 -> deleteFile();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);
    }

//Method to read and display contents of a file.
    private static void readFile() {
        System.out.print("Enter file name to read: ");
        String filename = scanner.nextLine();
        Path path = Paths.get(filename);

        /*
         * NOTE: To use this option, make sure the file exists.
         * You can create or add content with options 2 or 3.
         */
        try {
            if (Files.exists(path)) {
                Files.lines(path).forEach(System.out::println);
                logAction("Read", filename);
            } else {
                System.out.println("File does not exist. Please create it first.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    //Method to write new content to a file.
    private static void writeFile() {
        System.out.print("Enter file name to write: ");
        String filename = scanner.nextLine();
        System.out.print("Enter content to write: ");
        String content = scanner.nextLine();
        Path path = Paths.get(filename);

        try {
            Files.writeString(path, content);
            logAction("Write", filename);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    //Method to append content to a file.
    private static void appendFile() {
        System.out.print("Enter file name to append: ");
        String filename = scanner.nextLine();
        System.out.print("Enter content to append: ");
        String content = scanner.nextLine();
        Path path = Paths.get(filename);

        try {
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            logAction("Append", filename);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

//Method to delete a file.
    private static void deleteFile() {
        System.out.print("Enter file name to delete: ");
        String filename = scanner.nextLine();
        Path path = Paths.get(filename);

        try {
            if (Files.deleteIfExists(path)) {
                logAction("Delete", filename);
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    //Method to log every action (Read, Write, Append, Delete) into operation_log.txt.
    private static void logAction(String action, String file) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s] %s: %s%n", timestamp, action, file);

        try {
            Files.writeString(logPath, logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Failed to log action.");
        }
    }
}
