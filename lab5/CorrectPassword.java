package five;
import java.util.regex.*;
public class CorrectPassword {
    public static void main(String[] args) {
        String[] passwords = {"Pass1234", "short1A", "onlyletters", "12345678", "ValidPassword1", null};
        for (String p : passwords) {
            try {
                if (validate(p)) {
                    System.out.println("Password '" + p + "' is VALID");
                } else {
                    System.out.println("Password '" + p + "' is INVALID");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
        String regex = "^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,16}$";
        return password.matches(regex);
    }
}
