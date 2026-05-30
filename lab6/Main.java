package six;
public class Main {
    public static void main(String[] args) {
        SalesManager manager = new SalesManager();

        manager.addSale(new Product("Milk", 80.0));
        manager.addSale(new Product("Bread", 45.0));
        manager.addSale(new Product("Milk", 80.0));
        manager.addSale(new Product("Coffee", 350.0));
        manager.addSale(new Product("Bread", 45.0));
        manager.addSale(new Product("Milk", 80.0));

        manager.printAllSales();
        System.out.println("\n----------------------------");
        System.out.println("Total income: " + manager.calculateTotalSum() + " rub.");
        System.out.println("Most populat item: " + manager.getMostPopularProduct());
    }
}
