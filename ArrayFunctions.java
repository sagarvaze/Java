import java.util.Random;

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

    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while(j >= 0 && key < data[j]) {
                data[j+1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIdx] > data[j]) {
                    minIdx = j;
                }
            }
            int temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }
    }
    public static void randomFill(int[] data, int max) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(max);
        }
    }

    public static void randomFill(int[] data) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt();
        }
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
        insertionSort(data);
        System.out.print("Sorted array: ");
        display(data);
        String[] testStrings = {"ABC", "abc", "xyz", "XYZ"};
        System.out.println("Search for XYZ: " + linearSearch(testStrings,"XYZ"));

        int[] dataInsertionSort = new int[100000];
        int[] dataSelectionSort = new int[100000];
        randomFill(dataInsertionSort);
        for (int i = 0; i < dataInsertionSort.length; i++) dataSelectionSort[i] = dataInsertionSort[i];

        // display(data2);
        long start = System.currentTimeMillis();
        insertionSort(dataInsertionSort);
        long elapsed = System.currentTimeMillis() - start;
        // display(data2);
        System.out.println(elapsed + "ms");

        start = System.currentTimeMillis();
        selectionSort(dataSelectionSort);
        elapsed = System.currentTimeMillis() - start;
        // display(data2);
        System.out.println(elapsed + "ms");
    }
}