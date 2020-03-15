public class NumericFunctions {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
    return result;
    }

    public static long pow(int m, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= m;
        }
        return result;
    }

    public static int gcd(int m, int n) {
        int temp;
        while (n > 0) {
            temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
    public static void main(String[] args) {
        System.out.println("Factorials");
        for (int n = 1; n <= 10; n++) {
            System.out.print(n);
            System.out.print(" ");
            System.out.println(factorial(n));
        }

        System.out.println("Powers");
        for (int m = 1; m < 10; m++) {
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d %d %d\n", m, n, pow(m,n));
            }
        }

        System.out.println("GCD");
        for (int m = 2; m <= 10; m++) {
            for (int n = 2; n <= 10; n++) {
                System.out.printf("%d %d %d\n", m, n, gcd(m,n));
            }
        }
    }
}