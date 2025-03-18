/**
 * Generate the smallest twin prime number between a range (returns the larger of the two twins)
 * 
 * @author Seth McDaniel
 */
public class TwinPrimeGenerator {

    /**
     * Generate a twin prime between a range of numbers
     * 
     * @param min Lower bound on range
     * @param max Upper bound on range
     * @return The larger prime of the smallest twin prime in the range, else -1 if no twin prime in the range
     */
    public static int generateTwinPrime(int min, int max) {
        for (int num = min; num <= max - 2; num++) {
            if (isPrime(num) && isPrime(num + 2)) {
                return num + 2;
            }
        }
        return -1;
    }

    /**
     * Check if num is prime
     * 
     * @param num to check if prime
     * @return true if num is prime, false otherwise
     */
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