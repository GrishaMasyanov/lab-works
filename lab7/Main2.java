package seven;
class MaxFinder implements Runnable {
    private final int[] row;
    private int maxInRow;

    public MaxFinder(int[] row) {
        this.row = row;
        this.maxInRow = Integer.MIN_VALUE;
    }

    public int getMaxInRow() {
        return maxInRow;
    }

    @Override
    public void run() {
        for (int value : row) {
            if (value > maxInRow) {
                maxInRow = value;
            }
        }
        System.out.println("Thread finished: found max " + maxInRow + " in its row.");
    }
}

public class Main2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 3},
                {9, 2, 8},
                {4, 6, 7}
        };

        Thread[] threads = new Thread[matrix.length];
        MaxFinder[] tasks = new MaxFinder[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            tasks[i] = new MaxFinder(matrix[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      
        int globalMax = Integer.MIN_VALUE;
        for (MaxFinder task : tasks) {
            if (task.getMaxInRow() > globalMax) {
                globalMax = task.getMaxInRow();
            }
        }
        System.out.println("Global maximum in matrix: " + globalMax);
    }
}
