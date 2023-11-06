package weektwodequeue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Item[] circularArr;
    private int size = 0, first = 0, last = 0;

    public Deque() {
        circularArr = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = circularArr[(first + i) % circularArr.length];
        }
        first = 0;
        last = size;
        circularArr = copy;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size == circularArr.length) {
            resize(2 * circularArr.length);
        }
        first = (first - 1 + circularArr.length) % circularArr.length;
        circularArr[first] = item;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size == circularArr.length) {
            resize(2 * circularArr.length);
        }
        circularArr[last] = item;
        last = (last + 1) % circularArr.length;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = circularArr[first];
        circularArr[first] = null;
        first = (first + 1) % circularArr.length;
        size--;
        if (size > 0 && size == circularArr.length / 4) {
            resize(circularArr.length / 2);
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        last = (last - 1 + circularArr.length) % circularArr.length;
        Item item = circularArr[last];
        circularArr[last] = null;
        size--;
        if (size > 0 && size == circularArr.length / 4) {
            resize(circularArr.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private int current = first;
        private int count = 0;

        public boolean hasNext() {
            return count < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return");
            }
            Item item = circularArr[current];
            current = (current + 1) % circularArr.length;
            count++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println("Is empty: " + deque.isEmpty());

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("Size: " + deque.size());

        for (int item : deque) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from back: " + deque.removeLast());

        for (int item : deque) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
