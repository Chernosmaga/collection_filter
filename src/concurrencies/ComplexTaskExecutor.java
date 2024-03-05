package concurrencies;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private int tasksNumber;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(tasksNumber);

    public ComplexTaskExecutor(int tasksNumber) {
        this.tasksNumber = tasksNumber;
    }

    public void executeTasks(int tasksNumber) {
        for (int i = 0; i < tasksNumber; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println("Выполняю задачу: " + finalI);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException exception) {
                    System.out.println("Выполнил задачи");
                }
            });
        }
    }
}
