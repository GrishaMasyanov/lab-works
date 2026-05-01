public class Order {
    private final String items;      
    private final String address;    
    private final double totalCost;  

    public Order(String items, String address, double totalCost) {
        this.items = items;
        this.address = address;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{Items: '" + items + "', Address: '" + address + "', Cost: $" + totalCost + "}";
    }
}
