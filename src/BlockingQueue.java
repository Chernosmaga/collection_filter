import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private final Queue<T> queue;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private int size;
    private int maxSize;

    public BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayDeque<>();
        size = 0;
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        try {
            while (size == maxSize)
                notFull.await();
            queue.add(item);
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        lock.lock();
        try {
            while (size == 0)
                notEmpty.await();
            item = queue.remove();
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return item;
    }
    
    public int size() {
        int sizeCopy;
        lock.lock();
        try {
            sizeCopy = size;
        } finally {
            lock.unlock();
        }
        return sizeCopy;
    }
}
