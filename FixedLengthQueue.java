public class FixedLengthQueue<E> extends ArrayQueue<E> {
    private int drops;

    public FixedLengthQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(E item) {
        if (size == data.length) 
            drops++;
        else
            super.enqueue(item);
    }

    public int drops() {
        return drops;
    }

    public static void main(String[] args) {
        FixedLengthQueue<Integer> s = new FixedLengthQueue<Integer>(10);
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 12; i++) {
            s.enqueue(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek() + " Drops: " + s.drops());
            System.out.println(s.toString());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}