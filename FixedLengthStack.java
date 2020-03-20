public class FixedLengthStack<E> extends ArrayStack<E> {
    private int drops;

    public FixedLengthStack(int capacity) {
        super(capacity);
    }

    @Override
    public void push(E item) {
        if (top == data.length - 1) 
            drops++;
        else 
            super.push(item);
    }

    public int drops() {
        return drops;
    }

    public static void main(String[] args) {
        FixedLengthStack<Integer> s = new FixedLengthStack<Integer>(10);
        System.out.println("Empty: " + s.isEmpty());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 12; i++) {
            s.push(i);
            System.out.println("Size: " + s.size() + " Top: " + s.peek() + " Drops: " + s.drops());
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed + "ms");
        System.out.println("Empty: " + s.isEmpty());
    }
}