package eight;
public class Main {

    public static void main(String[] args) {

        DataManager manager =
                new DataManager();

        manager.registerDataProcessor(
                new FilterProcessor()
        );

        manager.registerDataProcessor(
                new UpperCaseProcessor()
        );

        manager.registerDataProcessor(
                new SortProcessor()
        );

        manager.loadData("input.txt");
        manager.processData();
        manager.saveData("output.txt");
    }
}
