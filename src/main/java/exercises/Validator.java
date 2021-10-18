package exercises;

/**
 * Validates passwords only.
 */
public class Validator {

    public static final int MIN_LENGTH = 8;

    private final String username;
    private String password;

    public Validator(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public boolean meetsAllRequirements() {
        return !containsUsername() && hasSpecialCharacter()
                && hasUppercaseLetter() && isLongEnough();
    }

    public boolean containsUsername() {
        return password.contains(username);
    }

    public boolean hasSpecialCharacter() {
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)))
                return true;
        }
        return false;
    }


    public boolean hasUppercaseLetter() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean isLongEnough() {
        return password.length() >= MIN_LENGTH;
    }


    public void setPassword(String password) {
        if (!password.equals(this.password)){
            this.password = password;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
