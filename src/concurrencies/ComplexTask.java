package concurrencies;

public class ComplexTask {

    public void execute(Thread thread) {
        try {
            thread.wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
