public class ArrayList<E> implements List<E> {
    protected E[] data;
    protected int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == data.length) resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) data[i+1] = data[i];
        data[index] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) newData[i] = data[i];
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        return data[index];
    }

    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) return i;
        }
        return -1;
    }

    public E removeAt(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        E result = data[index];
        for(int i = index; i < size - 1; i++) data[i] = data[i+1];
        data[--size] = null;
        if (size >= DEFAULT_CAPACITY && size == data.length / 2) resize(data.length / 2);
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E set(int index, E item) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        E result = data[index];
        data[index] = item;
        return result;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) throw new IndexOutOfBoundsException();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null)
                s.append(data[i].toString() + " ");
            else
                s.append("* ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            s.add(i);
            System.out.println("Size: " + s.size() + " Top: " + s.get(i));
            System.out.println(s.toString());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Size: " + s.size() + " Top: " + s.removeAt(0));
            System.out.println(s.toString());
        }
        for (int i = 0; i < 14; i++) {
            s.add(0, i);
            System.out.println("Size: " + s.size() + " Top: " + s.get(i));
            System.out.println(s.toString());
        }
        for (int i = 4; i < 6; i++) {
            System.out.println(s.removeAt(i));
            System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}