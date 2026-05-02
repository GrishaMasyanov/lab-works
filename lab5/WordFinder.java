package five;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple, banana, Apricot, avocado and cherry. Яблоко, ананас, Арбуз!";
        char targetLetter = 'a';

        try {
            List<String> results = findWordsStartingWith(text, targetLetter);

            if (results.isEmpty()) {
                System.out.println("No words found starting with '" + targetLetter + "'.");
            } else {
                System.out.println("Words starting with '" + targetLetter + "':");
                for (String word : results) {
                    System.out.println(word);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public static List<String> findWordsStartingWith(String text, char letter) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Target character must be a letter.");
        }
        List<String> foundWords = new ArrayList<>();

        String regex = "\\b" + letter + "[\\wа-яА-Я]*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            foundWords.add(matcher.group());
        }

        return foundWords;
    }
}
