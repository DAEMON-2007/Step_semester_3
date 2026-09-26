package topic_2.assignment_problems;

public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        String[] parts = fullName.trim().split("\\s+", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Full name must include first and last name");
        }
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
