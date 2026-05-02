package five;
import java.util.regex.*;
public class CamelCase {
    public static void main(String[] args) {
        String[] testInputs = {
                "eBay is a famous website",
                "thisIsCamelCaseStyle",
                "Normal text with ABC and abc",
                "iPhone and iPad",
                null
        };

        for (String input : testInputs) {
            try {
                String result = CheckCamelCase(input);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static String CheckCamelCase(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        String regex = "([a-z])([A-Z])";
        return text.replaceAll(regex, "!$1$2!");
    }
}
