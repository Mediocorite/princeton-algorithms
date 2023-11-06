package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LLQueues<Item> {
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

    public static void main(String[] args) {
        LLQueues<String> queue = new LLQueues<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
            StdOut.println(queue.dequeue());
        }
    }
}
