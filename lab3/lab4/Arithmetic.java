public class Arithmetic {
    public static void main(String[] args) {
        String[] arr = {"1", "2.5", "abc", "4", "5"};
        double sum = 0;
        int count = 0;
        for (int i = 0; i <= arr.length; i++) {
            try {
                double value = Double.parseDouble(arr[i]);
                sum += value;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Error: One of the array elements is not an integer.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Attempt to access an out-of-bounds array index.");
            }
        }
        if (count > 0) {
            System.out.println("Arithmetic mean: " + sum / count);
            System.out.println("Partially calculated sum: " + sum);
        }
    }
}
