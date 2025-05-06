import java.io.*;
import java.sql.Timestamp;

public class authService {
    private static final String USER_FILE = "data/users.txt";

    // Register a new user by writing to the file
    public static boolean registerUser(String username, String email, String password) {
        // First check if email already exists
        if (emailExists(email)) {
            System.err.println("Registration failed: Email already exists");
            return false;
        }
        
        try {
            int userId = getNextId();
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true));
            writer.write(userId + "," + username + "," + email + "," + password + "," + new Timestamp(System.currentTimeMillis()));
            writer.newLine();
            writer.close();
            System.out.println("User registered with ID: " + userId);
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to user file: " + e.getMessage());
            return false;
        }
    }

    // Check if email already exists in the user file
    private static boolean emailExists(String email) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 3) {  // We need at least 3 parts (id, username, email)
                    String storedEmail = parts[2].trim();
                    if (storedEmail.equals(email)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading user file while checking email: " + e.getMessage());
        }

        return false;
    }

    // Authenticate a user by checking email and password in the file
    public static user authenticate(String username, String password) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            System.err.println("User file not found.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String storedUsername = parts[1].trim();
                    String storedPassword = parts[3].trim();
 
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return new user(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            Timestamp.valueOf(parts[4].trim())
                        );
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading user file: " + e.getMessage());
        }

        return null;
    }

    // Determine the next available user ID based on the file
    public static int getNextId() throws IOException {
        int maxId = 0;
        File file = new File(USER_FILE);

        if (!file.exists()) {
            // Create directory if needed
            new File("data").mkdir();
            return 1;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length > 0) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        if (id > maxId) {
                            maxId = id;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid ID in line: " + line);
                    }
                }
            }
        }

        return maxId + 1;
    }
}