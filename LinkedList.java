public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        private Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        private Node() {
            this(null, null, null);
        }
    }

    public LinkedList() {
        head = new Node<E>();
        size = 0;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> p = getNode(index);
        Node<E> prev = p.prev;
        Node<E> next = p.next;
        E result = p.data;
        prev.next = next;
        if (next != null) next.prev = prev;
        size--;
        return result;
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            Node <E> p = getNode(size - 1);
            p.next = new Node<E>(data, null, p);
        } else {
            Node<E> p = getNode(index);
            Node<E> prev = p.prev;
            Node<E> newP = new Node<E>(data, p, prev);
            prev.next = newP;
            p.prev = newP;
        }
        size++;
    }

    public void add(E data) {
        add(size, data);
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> p = getNode(index);
        return p.data;
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> p = getNode(index);
        E result = p.data;
        p.data = item;
        return result;
    }

    public int indexOf(E item) {
        Node<E> p = head;
        for (int i = -1; i < size; i++) {
            if (p != null && item.equals(p.data)) return i;
            p = p.next;
        }
        return -1;

    }
    
    private Node<E> getNode(int index) {
        Node<E> p = head;
        for (int i = -1; i < index; i++) p = p.next;
        return p;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> p = head;
        for (int i = -1; i < size; i++) {
            if (p == null) s.append("END");
            else {
                if (p.data == null) s.append("* ");
                else s.append(p.data + " ");
                p = p.next;
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        List<Integer> s = new LinkedList<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            s.add(i);
            s.get(i);
            // System.out.println("Size: " + s.size() + " Top: " + s.get(i));
            // System.out.println(s.toString());
        }
        for (int i = 0; i < 3000; i++) {
            s.removeAt(0);
            // System.out.println("Size: " + s.size() + " Top: " + s.removeAt(1));
            // System.out.println(s.toString());
        }
        for (int i = 0; i < 14000; i++) {
            s.add(1, i);
            s.get(i);
            // System.out.println("Size: " + s.size() + " Top: " + s.get(i));
            // System.out.println(s.toString());
        }
        for (int i = 4; i < 6000; i++) {
            s.removeAt(i);
            // System.out.println(s.removeAt(i));
            // System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}