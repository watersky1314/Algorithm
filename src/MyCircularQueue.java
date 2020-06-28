import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

    private List<Integer> data;
    private Integer k;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.k = k;
        data = new ArrayList<>(k);
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        return data.add(value);
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        return data.remove(new Integer(k - 1));
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return data.get(0);
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return data.get(k - 1);
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return data.size() == 0 ? true : false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return data.size() == k ? true : false;
    }
}