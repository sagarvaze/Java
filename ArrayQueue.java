import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = rear = -1;
        size = 0;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(E item) {
        if (size == data.length) resize(2 * data.length);
        rear = (rear + 1) % data.length;
        if (size == 0) front = rear = 0;
        data[rear] = item;
        size++;
    }

    public E dequeue() {
        if (size == 0) throw new NoSuchElementException();
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (size == 1) front = rear = -1;
        size--;
        if (size >= 10 && size == data.length / 2) resize(data.length / 2);
        return result;
    }

    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0, j = front; i < size; i++, j = (j + 1) % data.length) newData[i] = data[j];
        data = newData;
        front = 0;
        rear = size - 1;
    }
    
    public String toString() {
        if (size == 0) throw new NoSuchElementException();
        StringBuilder s = new StringBuilder();
        // for (int i = 0; i < size; i++) {
        //     s.append(data[(front + i) % data.length].toString() + " ");
        // }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null)
                s.append(data[i].toString() + " ");
            else
                s.append("* ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> s = new ArrayQueue<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            s.enqueue(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek());
            System.out.println(s.toString());
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(s.dequeue());
            System.out.println(s.toString());
        }
        for (int i = 5; i < 14; i++) {
            s.enqueue(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek());
            System.out.println(s.toString());
        }
        for (int i = 4; i < 14; i++) {
            System.out.println(s.dequeue());
            System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}