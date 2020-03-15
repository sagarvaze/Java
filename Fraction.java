public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        this.num = Integer.signum(den) * num;
        this.den = Integer.signum(den) * den;
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public void addOn(Fraction f) {
        num = num * f.den + den * f.num;
        den *= f.den;
    }

    public void addOn(int n) {
        num += den * n;
    }

    public void subtractOff(Fraction f) {
        num = num * f.den - den * f.num;
        den *= f.den;
    }

    public void multiplyBy(Fraction f) {
        num *= f.num;
        den *= f.den;
    }

    public void divideBy(Fraction f) {
        num *= f.den;
        den *= f.num;
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int n = f1.num * f2.den + f1.den * f2.num;
        int d = f1.den * f2.den;
        return new Fraction(n, d);
    }

    public static Fraction subtract(Fraction f1, Fraction f2) {
        int n = f1.num * f2.den - f1.den * f2.num;
        int d = f1.den * f2.den;
        return new Fraction(n, d);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        int n = f1.num * f2.num;
        int d = f1.den * f2.den;
        return new Fraction(n, d);
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        int n = f1.num * f2.den;
        int d = f1.den * f2.num;
        return new Fraction(n, d);
    }

    public void reduce() {
        int gcd = NumericFunctions.gcd(Math.abs(num), den);
        num /= gcd;
        den /= gcd;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, -4);
        Fraction f2 = new Fraction(1, 3);

        System.out.print(f1 + " + " + f2 + " = ");
        System.out.println(add(f1, f2));
        System.out.print(f1 + " - " + f2 + " = ");
        System.out.println(subtract(f1, f2));
        System.out.print(f1 + " * " + f2 + " = ");
        System.out.println(multiply(f1, f2));
        System.out.print(f1 + " / " + f2 + " = ");
        System.out.println(divide(f1, f2));

        f1.addOn(f2);
        System.out.println("Using addOn() changes f1 to " + f1);
        f1.subtractOff((f2));
        System.out.println("Using subtractOff() changes f1 to " + f1);
        f1.multiplyBy(f2);
        System.out.println("Using multiplyBy() changes f1 to " + f1);
        f1.divideBy(f2);
        System.out.println("Using multiplyBy() changes f1 to " + f1);
        f1.reduce();
        System.out.println("Reduced f1: " + f1);
    }
}