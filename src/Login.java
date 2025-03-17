public class Login {
    private Registration registration;
    public Login(Registration registration) {
        this.registration = registration;
    }
    public boolean loginUser(String username, String password) {
        if (!registration.userExists(username)) {
            System.out.println("Користувач не знайдений. Спочатку зареєструйтесь.");
            return false;
        }
        if (registration.getPassword(username).equals(password)) {
            System.out.println("Вхід успішний! Ласкаво просимо, " + username);
            return true;
        } else {
            System.out.println("Неправильний пароль!");
            return false;
        }
    }
}
