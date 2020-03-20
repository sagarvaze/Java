public interface Queue<E> {
    boolean isEmpty();
    int size();
    void enqueue(E item);
    E dequeue();
    E peek();
}