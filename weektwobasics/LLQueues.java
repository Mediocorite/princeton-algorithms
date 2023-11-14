package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LLQueues<Item> implements Iterable<Item>{
    private Node first = null, last = null;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item dequeue ()
    {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Item item = first.item;
        first.item = null;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Iterator<Item> iterator()
    {return new ListQueueIterator(); }

    public class ListQueueIterator implements Iterator<Item>{
        private Node head = first;

        public boolean hasNext(){
            return head != null;
        }
        public Item next() {
            Item item = head.item;
            head = head.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LLQueues<String> queue = new LLQueues<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
        }
        for(String q: queue)
            System.out.println(q);
        System.out.println("Now for dequeue");
        while(!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
        }
    }
}
