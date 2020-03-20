import java.util.Random;

public class QueueSimulator {

    private static int addRandomTask(Processor testProcessor, double taskChance, int maxTaskTime) {
        Random rand = new Random();
        double r = rand.nextDouble();
        if (r < taskChance) {
            int taskTime = rand.nextInt(maxTaskTime);
            testProcessor.addTask(taskTime);
            return 1;
        }
        return 0;
    }

    public static void run(int queueLength, int minTime, int maxTaskTime, double taskChance) {
        Processor testProcessor = new Processor(queueLength);
        int t = 0;
        int taskCounter = 0;
        while (t < minTime || !testProcessor.free()) {
            if (t < minTime) {
                taskCounter += addRandomTask(testProcessor, taskChance, maxTaskTime);
            }
            testProcessor.tick();
            t++;
        }
        System.out.format("Tasks processed: %d\tTasks dropped: %d\tExtra Time: %d\n", taskCounter, testProcessor.drops(), t - minTime);
    }

    public static void main(String[] args) {
        int minTime = 10000;
        double taskChance = 0.3;
        int maxTaskTime = 10;
        for (int iQueue = 5; iQueue <= 2000; iQueue++) {
            run(iQueue, minTime, maxTaskTime, taskChance);
        }
    }
}