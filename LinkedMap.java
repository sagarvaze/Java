public class LinkedMap<K, V> implements Map<K, V> {
    private class KeyValuePair<K, V> {
        protected K key;
        protected V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object test) {
            if (test == this) return true;
            if (!(test instanceof KeyValuePair)) return false;
            KeyValuePair<K, V> testKeyValuePair = (KeyValuePair<K, V>) test;
            return key.equals(testKeyValuePair.key);
        } 

        public String toString() {
            return "Key: " + key.toString() + ", Value: " + value.toString();
        }
    }

    private LinkedList<KeyValuePair<K, V>> list;

    public LinkedMap() {
        list = new LinkedList<KeyValuePair<K, V>>();
    }

    public boolean containsKey(K key) {
        KeyValuePair<K, V> testKey = new KeyValuePair<K, V>(key, null);
        return list.indexOf(testKey) != -1;
    }

    public V get(K key) {
        KeyValuePair<K, V> searchKey = new KeyValuePair<K, V>(key, null);
        int idx = list.indexOf(searchKey);
        if (idx != -1) {
            KeyValuePair<K, V> findkey = list.get(idx);
            return findkey.value;
        } else return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public V put(K key, V value) {
        KeyValuePair<K, V> searchKey = new KeyValuePair<K, V>(key, value);
        int idx = list.indexOf(searchKey);
        if (idx != -1) {
            KeyValuePair<K, V> existingKey = list.set(idx, searchKey);
            return existingKey.value;
        } else {
            list.add(searchKey);
            return null;
        }
    }

    public V remove(K key) {
        KeyValuePair<K, V> searchKey = new KeyValuePair<K, V>(key, null);
        int idx = list.indexOf(searchKey);
        if (idx != -1) {
            KeyValuePair<K, V> existingKey = list.removeAt(idx);
            return existingKey.value;
        } else return null;
    }

    public int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LinkedMap<Integer, String> m = new LinkedMap<>();
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
    }
}