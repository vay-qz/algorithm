package pers;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private final int capacity;

    private int size;

    private LinkedList<Integer> value;

    private ReentrantLock lock = new ReentrantLock();

    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        value = new LinkedList<>();
    }

    public void enqueue(int element) {
        lock.lock();
        try {
            while (size == capacity) {
                this.full.wait();
            }
            value.addLast(element);
            this.size++;
            this.empty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() {
        int integer = 0;
        lock.lock();
        try {
            while (size == 0) {
                this.empty.wait();
            }
            integer = value.removeFirst();
            this.size--;
            this.full.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return integer;
    }

    public int size() {
        return this.size;
    }

}
