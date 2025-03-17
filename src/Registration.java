import java.io.*;
import java.util.*;
public class Registration {
    private static final String FILE_NAME = "users.txt";
    private HashMap<String, String> users = new HashMap<>();
    public Registration() {
        loadUsers();
    }
    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Користувач з таким логіном вже існує!");
        } else {
            users.put(username, password);
            saveUsers();
            System.out.println("Реєстрація успішна! Тепер ви можете увійти.");
        }
    }
    public boolean userExists(String username) {
        return users.containsKey(username);
    }
    public String getPassword(String username) {
        return users.get(username);
    }
    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (var entry : users.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Помилка збереження користувачів: " + e.getMessage());
        }
    }
    private void loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка завантаження користувачів: " + e.getMessage());
        }
    }
}
