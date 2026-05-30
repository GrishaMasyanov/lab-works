package six;
import java.util.*;
public class SalesManager {
    private final List<Product> sales = new ArrayList<>();

    public void addSale(Product product) {
        sales.add(product);
    }

    public void printAllSales() {
        System.out.println("--- Sales list ---");
        for (Product p : sales) {
            System.out.println(p);
        }
    }

    public double calculateTotalSum() {
        double total = 0;
        for (Product p : sales) {
            total += p.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        if (sales.isEmpty()) return "No sales";
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Product p : sales) {
            String name = p.getName();
            frequencyMap.put(name, frequencyMap.getOrDefault(name, 0) + 1);
        }

        String mostPopular = "";
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular + " (sold " + maxCount + " times)";
    }
}
