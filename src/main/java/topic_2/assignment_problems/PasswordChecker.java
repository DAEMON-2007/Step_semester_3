package topic_2.assignment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() <= 9) {
            return "Medium";
        }
        return "Strong";
    }
}
