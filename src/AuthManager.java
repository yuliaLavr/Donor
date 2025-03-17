import java.util.*;
public class AuthManager {
    private Registration registration;
    private Login login;
    private Scanner scanner;
    public AuthManager() {
        this.registration = new Registration();
        this.login = new Login(registration);
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> loginUser();
                case 2 -> registerUser();
                case 3 -> exitProgram();
                default -> System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
        }
    }
    private void showMenu() {
        System.out.println("Оберіть дію:");
        System.out.println("1 - Вхід");
        System.out.println("2 - Реєстрація");
        System.out.println("3 - Вихід");
    }
    private int getUserChoice() {
        System.out.print("Ваш вибір: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Будь ласка, введіть число!");
            scanner.next();
        }
        return scanner.nextInt();
    }
    private void loginUser() {
        scanner.nextLine(); // Очищення буфера
        System.out.print("Введіть логін: ");
        String username = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        if (login.loginUser(username, password)) {
            System.out.println("Ви увійшли в систему.");
        }
    }
    private void registerUser() {
        scanner.nextLine(); // Очищення буфера
        System.out.print("Введіть новий логін: ");
        String username = scanner.nextLine();
        System.out.print("Введіть новий пароль: ");
        String password = scanner.nextLine();

        registration.register(username, password);
    }
    private void exitProgram() {
        System.out.println("Програма завершена.");
        scanner.close();
        System.exit(0);
    }
}