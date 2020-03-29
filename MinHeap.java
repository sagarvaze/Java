import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<? super E>> extends Heap<E> {
    protected boolean isHigher(int i, int j) {
        if (i >= size || j >= size) throw new NoSuchElementException();
        if (data[i].compareTo(data[j]) < 0) return true;
        else return false;
    }


    public static void main(String[] args) {
        MinHeap<Integer> s = new MinHeap<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 25; i++) {
            s.add(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek());
            System.out.println(s.toString());
        }
        for (int i = 0; i < 25; i++) {
            System.out.println(s.remove());
            System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}