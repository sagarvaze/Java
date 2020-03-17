import java.util.EmptyStackException;

public class IntLinkedStack implements IntStack {
    private Node top;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public IntLinkedStack() {
        top = null;
        size = 0;
    }

    public void push(int item) {
        top = new Node(item, top);
        size++;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        IntStack s = new IntLinkedStack();
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