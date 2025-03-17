//import java.util.LinkedList;

public class TwinPrimeGenerator {
    public static int generateTwinPrime(int min, int max) { //Maybe make an array to reduce rechecking?
        //LinkedList<Integer> primes = new LinkedList<Integer>();
        for (int num = min; num <= max - 2; num++) {
            if (isPrime(num) && isPrime(num + 2)) {
                return num + 2;
            }
        }

        return -1;

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}