import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int top = -1;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E result = data[top];
        data[top--] = null;
        return result;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top];
    }

    public void push(E item) {
        if (top == data.length) resize(2 * data.length);
        data[++top] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) newData[i] = data[i];
        data = newData;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            s.push(i);
            // System.out.println("Size: " + s.size() + " Top: " + s.peek());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}