import java.math.BigInteger;

public class Recursion {
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int add(int m, int n) {
        if (n == 0) return m;
        return 1 + add(m, n - 1);
    }

    public static long fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // improved to not double calculate, can support huge values
    public static BigInteger fib(int n, BigInteger[] record) {
        if (n <= 2) return BigInteger.valueOf(1);
        if (record[n] != null) return record[n];
        record[n] = fib(n - 1, record).add(fib(n - 2, record));
        return record[n];
    }

    public static <T extends Comparable<? super T>> int binarySearch(T[] data, T target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    private static <T extends Comparable<? super T>> int binarySearch(T[] data, T target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        int result = target.compareTo(data[mid]);
        if (result == 0) return mid;
        else if (result > 0) return binarySearch(data, target, mid + 1, high);
        else return binarySearch(data, target, 0, mid - 1);
    }

    public static String lcs(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return "";
        if (s1.charAt(0) == s2.charAt(0)) return s1.charAt(0) + lcs(s1.substring(1), s2.substring(1));
        else {
            String s11 = lcs(s1, s2.substring(1));
            String s22 = lcs(s1.substring(1), s2);
            if (s11.length() > s22.length()) return s11;
            else return s22;
        }
    }

    public static void hanoi(int n, char src, char intermed, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + src + " to " + dest);
            return;
        } 
        hanoi(n - 1, src, dest, intermed);
        System.out.println("Move disk " + n + " from rod " + src + " to " + dest);
        hanoi(n - 1, intermed, src, dest);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // System.out.println(fib(50));
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        start = System.currentTimeMillis();
        System.out.println(fib(2222, new BigInteger[2223]));
        elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        BigInteger fibArray[] = new BigInteger[100];
        BigInteger record[] = new BigInteger[101];
        for (int i = 1; i < 100; i++) {
            fibArray[i - 1] = fib(i, record);
        }
        System.out.println(binarySearch(fibArray, fib(30, record)));
        System.out.println(lcs("Sagar", "Data Structures in Java"));
        hanoi(4, 'A', 'B', 'C');
    }
}