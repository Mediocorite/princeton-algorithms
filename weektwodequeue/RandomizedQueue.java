package weektwodequeue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size;
    private final Random rand;

    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
        size = 0;
        rand = new Random();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item not allowed");
        }
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = rand.nextInt(size);
        Item item = arr[index];
        arr[index] = arr[--size];
        arr[size] = null;

        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[rand.nextInt(size)];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(arr, 0, copy, 0, size);
        arr = copy;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;
        private final Item[] shuffledArray;

        public RandomizedQueueIterator() {
            i = 0;
            shuffledArray = (Item[]) new Object[size];
            System.arraycopy(arr, 0, shuffledArray, 0, size);
            shuffle(shuffledArray);
        }

        public boolean hasNext() {
            return i < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items");
            }
            return shuffledArray[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }

        private void shuffle(Item[] array) {
            for (int j = size - 1; j > 0; j--) {
                int k = rand.nextInt(j + 1);
                Item temp = array[j];
                array[j] = array[k];
                array[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        System.out.println("Is empty? " + rq.isEmpty());

        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);

        System.out.println("Size: " + rq.size());
        System.out.println("Sample: " + rq.sample());

        Iterator<Integer> it1 = rq.iterator();
        Iterator<Integer> it2 = rq.iterator();

        System.out.println("Iterator 1:");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();

        System.out.println("Iterator 2:");
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println();

        System.out.println("Dequeue: " + rq.dequeue());
        System.out.println("Size after dequeue: " + rq.size());
    }
}
