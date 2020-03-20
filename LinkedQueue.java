import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(E item) {
        if (size > 0) {
            rear.next = new Node<E>(item, null);
            rear = rear.next;
        }
        else {
            front = rear = new Node<E>(item, null);
        }
        size++;
    }

    public E dequeue() {
        if (size == 0) throw new NoSuchElementException();
        E result = front.data;
        front = front.next;
        size--;
        if (size == 0) front = rear = null;
        return result;
    }

    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (size == 0) throw new NoSuchElementException();
        StringBuilder s = new StringBuilder();
        Node<E> iter = front;
        for (int i = 0; i < size; i++) {
            s.append(iter.data.toString() + " ");
            iter = iter.next;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> s = new LinkedQueue<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            s.enqueue(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek());
            System.out.println(s.toString());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(s.dequeue());
            System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}