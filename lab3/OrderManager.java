import java.util.HashMap;
public class OrderManager {
    public static void main(String[] args) {
        HashMap<Integer, Order> orderTable = new HashMap<>();

        orderTable.put(101, new Order("Laptop, Mouse", "123 Maple St", 1200.50));
        orderTable.put(102, new Order("Smartphone", "456 Oak Ave", 800.00));
        orderTable.put(103, new Order("Headphones", "789 Pine Rd", 150.00));

        System.out.println("Orders added. Total count: " + orderTable.size());

        int searchId = 102;
        if (orderTable.containsKey(searchId)) {
            System.out.println("Found Order #" + searchId + ": " + orderTable.get(searchId));
        } else {
            System.out.println("Order #" + searchId + " not found.");
        }

        int removeId = 101;
        orderTable.remove(removeId);
        System.out.println("Order #" + removeId + " removed.");

        System.out.println("Remaining orders: " + orderTable.size());
        System.out.println("Is Order #101 still there? " + orderTable.containsKey(101));
    }
}
