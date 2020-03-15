public class ArrayFunctions {
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) return i;
        }
        return -1;
    }

    public static int linearSearch(String[] data, String target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) return i;
        }
        return -1;
    }

    public static int sum(int[] data)
    {
        int sum = 0;
        for (int elem : data) sum += elem;
        return sum;
    }

    public static int max(int[] data) {
        int max = data[0];
        for (int elem : data) {
            if (elem > max) max = elem;
        }
        return max;
    }

    public static int min(int[] data) {
        int min = data[0];
        for (int elem : data) {
            if (elem < min) min = elem;
        }
        return min;
    }

    public static void display(int[] data)
    {
        for (int elem : data) System.out.print(elem + " ");
        System.out.println();
    }

    public static void main (String[] args) {
        int[] data = {3, 14, 7, 22, 45, 12, 19, 42, 6};
        for (int elem : data) {
            System.out.println("Seaarch for " + elem + ": " + linearSearch(data, elem));
        }
        // System.out.println("search for 7: " + linearSearch(data, 7));
        // System.out.println("Search for 100: " + linearSearch(data, 100));

        System.out.println("Sum: " + sum(data));
        System.out.println("Max: " + max(data));
        System.out.println("Min: " + min(data));
        display(data);

        String[] testStrings = {"ABC", "abc", "xyz", "XYZ"};
        System.out.println("Search for XYZ: " + linearSearch(testStrings,"XYZ"));
    }
}