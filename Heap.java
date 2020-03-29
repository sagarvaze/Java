import java.util.NoSuchElementException;

public abstract class Heap<E extends Comparable<? super E>> implements PriorityQueue<E> {
    protected E[] data;
    protected int size = 0;
    protected static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public Heap() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E item) {
        if (size == data.length) resize(2 * data.length);
        data[size++] = item;
        int idx = size - 1;
        while (isValid(parent(idx)) && !isHigher(parent(idx), idx)) {
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException();
        E result = data[0];
        data[0] = data[size - 1];
        data[--size] = null;
        int largest = 0, idx = 0;
        while(isValid(left(idx)) && !isHigher(idx, left(idx)) || isValid(right(idx)) && !isHigher(idx, right(idx))) {
            if (isValid(left(idx)) && !isHigher(largest, left(idx))) largest = left(idx);
            if (isValid(right(idx)) && !isHigher(largest, right(idx))) largest = right(idx);
            if (idx != largest) swap(idx, largest);
            idx = largest;
        }
        if (size >= 10 && size == data.length / 2) resize(data.length / 2);
        return result;
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return data[size - 1];
    }

    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        E[] newData = (E[]) new Comparable[capacity];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null)
                s.append(data[i].toString() + " ");
            else
                s.append("* ");
        }
        return s.toString();
    }

    // public String toString() {
    //     StringBuilder s = new StringBuilder();
    //     if (size > 0) {
    //         int depth = (int) (Math.log(size) / Math.log(2.0) + 1.0);
    //         int width = (int) Math.pow(2, depth) - 1;
    //         for (int i = 0; i < size; i++) {
    //             int levelDepth = (int) (Math.log(i + 1) / Math.log(2.0) + 1.0);
    //             int levelWidth = (int) Math.pow(2, levelDepth) - 1;
    //             int padding = (width - levelWidth) / 2 + 1;
    //             for (int j = 0; j < padding; j++) s.append(' ');
    //             s.append(data[i]);
    //             if ((int) (Math.log(i + 2) / Math.log(2.0) + 1.0) > (int) (Math.log(i + 1) / Math.log(2.0) + 1.0)) s.append("\n");
    //         }
    //     }
    //     return s.toString();
    // }

    protected int parent(int i) {
        return i > 0 ? (i - 1) / 2 : -1;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    protected void swap(int i, int j) {
        if (!isValid(i) || !isValid(j)) throw new NoSuchElementException();
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    protected boolean isValid(int i) {
        return i >= 0 && i < size;
    }

    protected abstract boolean isHigher(int i, int j);
}