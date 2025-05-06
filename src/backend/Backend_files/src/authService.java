import java.io.*;
import java.sql.Timestamp;

public class authService {
    private static final String USERS_FILE = "data/users.txt";

    public user authenticate(String usernameOrEmail, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && (usernameOrEmail.equals(parts[1]) || usernameOrEmail.equals(parts[2]))) {
                    if (password.equals(parts[3])) {
                        return new user(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            parts[3],
                            new Timestamp(Long.parseLong(parts[4]))
                        );
                    }
                }
            }
        }
        return null;
    }

    public boolean registerUser(String username, String email, String password) throws IOException {
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        if (emailExists(email)) return false;

        int newId = getNextId();
        try (PrintWriter out = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            out.printf("%d,%s,%s,%s,%d%n",
                newId, username, email, password, System.currentTimeMillis());
            return true;
        }
    }

    private boolean emailExists(String email) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && email.equals(parts[2])) return true;
            }
        }
        return false;
    }

    private int getNextId() throws IOException {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line.split(",")[0]);
                if (id > maxId) maxId = id;
            }
        }
        return maxId + 1;
    }
}