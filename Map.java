public interface Map<K, V> {
    boolean containsKey(K key);
    V get(K key);
    boolean isEmpty();
    V put(K key, V value);
    V remove(K key);
    int size();
}