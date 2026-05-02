package five;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
public class NumberFinder {
    public static void main(String[] args) {
        String text = "Order №502: price -19.99$, sale 5%, remaining stock 0.";
        try {
            List<String> numbers = findAllNumbers(text);

            if (numbers.isEmpty()) {
                System.out.println("No number in the text.");
            } else {
                System.out.println("The numbers found:");
                for (String num : numbers) {
                    System.out.println(num);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) { 
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public static List<String> findAllNumbers(String text) {
        if (text == null) {
            throw new IllegalArgumentException("The text can't be null.");
        }
        List<String> foundNumbers = new ArrayList<>();
        
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            foundNumbers.add(matcher.group());
        }
        return foundNumbers;
    }
}
