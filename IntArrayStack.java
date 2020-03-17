import java.util.EmptyStackException;

public class IntArrayStack implements IntStack {
    private int top = -1;
    private int[] data;
    private static final int DEFAULT_CAPACITY = 10;

    public IntArrayStack(int size) {
        data = new int[size];
    }

    public IntArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        if (top < 0) return true;
        else return false;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top];
    }

    public void push(int item) {
        if (top == data.length - 1) resize(2 * data.length);
        data[++top] = item;
    }

    public int size() {
        return top + 1;
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {
        IntStack s = new IntArrayStack();
        System.out.println("Empty: " + s.isEmpty());
        for (int i = 0; i < 500; i++) {
            s.push(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek());
        }
        System.out.println("Empty: " + s.isEmpty());
    }
}