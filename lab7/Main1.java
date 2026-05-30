package seven;
class SumCalculator implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private long partialSum;
    public SumCalculator(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
        System.out.println("Thread finished: sum from index " + start + " to " + (end - 1) + " = " + partialSum);
    }
}
public class Main1 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = data.length / 2;

        SumCalculator task1 = new SumCalculator(data, 0, mid);
        SumCalculator task2 = new SumCalculator(data, mid, data.length);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalSum = task1.getPartialSum() + task2.getPartialSum();
        System.out.println("Total sum: " + totalSum);
    }
}
