import java.util.Arrays;

public class Utils {

    // ==========================================
    // ARRAY UTILITIES
    // ==========================================

    /**
     * Prints an integer array in a readable format [a, b, c].
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Reads a line of space-separated integers from input string into an array.
     */
    public static int[] parseArray(String input) {
        if (input == null || input.trim().isEmpty()) return new int[0];
        String[] parts = input.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    /**
     * Swaps two elements in an array by index.
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Reverses an array in-place.
     */
    public static void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // ==========================================
    // BITWISE UTILITIES (0-indexed k)
    // ==========================================

    /**
     * Checks if the k-th bit of n is set (1).
     */
    public static boolean isKthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    /**
     * Sets the k-th bit of n to 1.
     */
    public static int setKthBit(int n, int k) {
        return n | (1 << k);
    }

    /**
     * Clears the k-th bit of n (sets it to 0).
     */
    public static int clearKthBit(int n, int k) {
        return n & ~(1 << k);
    }

    /**
     * Toggles the k-th bit of n (0 -> 1 or 1 -> 0).
     */
    public static int toggleKthBit(int n, int k) {
        return n ^ (1 << k);
    }

    /**
     * Counts the total number of set bits (1s) in integer n.
     */
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1); // clears the lowest set bit
            count++;
        }
        return count;
    }

    /**
     * Checks if n is a power of 2.
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // ==========================================
    // MATH UTILITIES
    // ==========================================

    /**
     * Calculates Greatest Common Divisor (GCD) using Euclid's algorithm.
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Calculates Least Common Multiple (LCM).
     */
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Checks if a number is prime.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
