import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;
        
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(E data) {
        top = new Node<E>(data, top);
        size++;
    }

    public E pop() {
        if (top == null) throw new EmptyStackException();
        E result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public E peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new LinkedStack<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            s.push(i);
            System.out.println("Size: " + s.size() + " Top: " + s.pop());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}