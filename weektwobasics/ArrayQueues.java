package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayQueues<Item> {

    public Item[] queue;
    public int head = 0;
    public int tail = 0;
    public int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueues() {
        queue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return head - tail == 0;
    }

    public void enqueue(Item item) {
        if (size == queue.length)
            resize(queue.length * 2);
        queue[tail] = item;
        tail = (tail + 1) % queue.length;
        size++;
    }

    public Item dequeue() {
        if (size == queue.length / 4)
            resize(queue.length / 2);
        Item item = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize ( int capacity ){
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++ )
            copy[i] = queue[(head + i) % queue.length];
        queue = copy;
        head = 0;
        tail = size;
    }

    public static void main(String[] args) {
        ArrayQueues<String> q = new ArrayQueues<>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        while(!q.isEmpty()) {
            StdOut.println(q.dequeue());
        }
    }
}
