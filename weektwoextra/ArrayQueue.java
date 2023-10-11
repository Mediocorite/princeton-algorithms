package weektwoextra;

import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] queue = (Item[]) new Object[1];
    private int first, last = 0;

    public boolean isEmpty()
    { return last - first == 0; }

    public void enqueue(Item item) {
        if (last == queue.length)
            resize(queue.length * 2);
        queue[last++] = item;
    }

    public Item dequeue() {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");
        Item i = queue[first++];
        if (last - first <= queue.length/4) {
            resize(queue.length/2);
        }
        return i;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Item[] copy = (Item[]) new Object[capacity];
        int j = 0;
        for (int i = first; i < last; i++)
            copy[j++] = queue[i];
        first = 0;
        last = j;
        queue = copy;
    }

    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<Item> {
        private int f = first, l = last;
        public boolean hasNext()
        { return l - f != 0; }
        public Item next()
        { return queue[f++];}
    }
}
