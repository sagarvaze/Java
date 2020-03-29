public interface PriorityQueue<E>{
    void add(E item);
    boolean isEmpty();
    E peek();
    E remove();
    int size();
}