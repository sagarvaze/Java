public interface Stack<E> {
    void push(E item);
    E peek();
    E pop();
    int size();
    boolean isEmpty();
}