package seven;
import java.util.ArrayList;
import java.util.List;
class Item {
    int weight;
    public Item(int weight) {
        this.weight = weight;
    }
}
class Warehouse {
    private final List<Item> items = new ArrayList<>();
    private int currentWeight = 0;
    public synchronized void addItems(String loaderName) {
        int load = 50;
        if (currentWeight + load <= 150) {
            currentWeight += load;
            System.out.println(loaderName + " picked up " + load + "kg. Total weight: " + currentWeight + "kg.");
        }
        if (currentWeight == 150) {
            System.out.println(loaderName + " is heading to the delivery warehouse with 150kg!");
            currentWeight = 0;
        }
    }
}
class Loader extends Thread {
    private final Warehouse warehouse;
    public Loader(Warehouse warehouse, String name) {
        super(name);
        this.warehouse = warehouse;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            warehouse.addItems(getName());
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException _) {
            }
        }
    }
}
public class Main3 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        for (int i = 1; i <= 3; i++) {
            new Loader(warehouse, "Loader-" + i).start();
        }
    }
}
