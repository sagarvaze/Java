public class LinkedHashMap<K, V> implements Map<K, V>{
    private static final int DEFAULT_TABLE_SIZE = 10;
    private LinkedMap<K, V>[] table;
    private int tableSize;
    protected int size; 

    public LinkedHashMap() {
        this(DEFAULT_TABLE_SIZE);
        tableSize = DEFAULT_TABLE_SIZE;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap(int tableSize) {
        table = (LinkedMap<K, V>[]) new LinkedMap[tableSize];
        this.tableSize = tableSize;
        size = 0;
    }

    private int hash(K key) {
        int hash = key.hashCode() % tableSize;
        if (hash < 0) {
            hash += tableSize;
        }
        return hash;
    }

    public boolean containsKey(K key) {
        if (table[hash(key)] == null) return false;
        else return table[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return table[hash(key)].get(key);
    }

    public V put(K key, V value) {
        if (table[hash(key)] == null) table[hash(key)] = new LinkedMap<K, V>();
        V existingVal = table[hash(key)].put(key, value);
        if (existingVal == null) size++;
        return existingVal;
    }

    public V remove(K key) {
        V existingVal = table[hash(key)].remove(key);
        if (existingVal != null) size--;
        return existingVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            sb.append(i + ": " + (table[i] == null ? " " : table[i].toString()) + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Integer, String> m = new LinkedHashMap<>();
        m.put(5, "five");
        System.out.println(m.toString());
        m.put(3, "three");
        System.out.println(m.toString());
        System.out.println(m.containsKey(2));
        m.put(5, "FIVE");
        System.out.println(m.toString());
        m.put(2, "two");
        System.out.println(m.toString());
        System.out.println(m.get(5));
        m.put(1, "one");
        System.out.println(m.toString());
        System.out.println("Size: " + m.size());
        m.remove(3);
        System.out.println(m.toString());
        m.remove(5);
        m.remove(2);
        System.out.println(m.isEmpty());
        m.remove(1);
        System.out.println(m.isEmpty());
    }

}