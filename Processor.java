public class Processor {
    private boolean free;
    private FixedLengthQueue<Integer> processQueue;
    private int depth;
    private int currentTask;

    public Processor(int depth) {
        this.depth = depth;
        this.processQueue = new FixedLengthQueue<Integer>(depth);
        this.free = true;
        this.currentTask = 0;
    }

    public void addTask(int taskTime) {
        if (free) {
            currentTask = taskTime;
            free = false;
        } else {
            processQueue.enqueue(taskTime);
        }
    }

    public int drops() {
        return processQueue.drops();
    }

    public boolean free() {
        return free;
    }

    public void tick() {
        if (!free) {
            if (currentTask > 0) {
                currentTask--;
            }
            else {
                if (!processQueue.isEmpty()) 
                    currentTask = processQueue.dequeue();
                else
                    free = true;
            }
        }
    }

    public int depth() {
        return depth;
    }
}