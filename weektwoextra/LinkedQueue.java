package weektwoextra;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item>{

    private Node first, last = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else          oldLast.next = last;
    }

    public Item dequeue() {
        if (first == null)
            throw new IllegalStateException("Queue is empty");
        Item i = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return i;
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
