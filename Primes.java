public class Primes {
    public static void main(String args[]) {
//цикл
        for (int n = 2; n < 100; n++) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
    }
    //метод
    public static boolean isPrime(int n) {
        //цикл
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}