package six;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Top10 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Гриша\\Desktop\\lab3\\src\\six\\TopWords.txt";
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {

            Map<String, Integer> wordCounts = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");

                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
            scanner.close();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());

            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            System.out.println("Top 10 most frequent words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : list) {
                if (count >= 10) break;
                System.out.println((count + 1) + ". " + entry.getKey() + ": " + entry.getValue());
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found at " + filePath);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
