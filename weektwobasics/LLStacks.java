package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LLStacks<Item> implements Iterable<Item>{
    private Node first;
    private class Node {
        Item item;
        Node next;
    }

    public LLStacks()
    { first = null; }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop () {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Item item = first.item;
        first.item = null;
        first = first.next;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListStackIterator();
    }

    public class ListStackIterator implements Iterator<Item>{
        private Node head = first;
        public boolean hasNext()
        { return head != null; }
        public Item next() {
            Item item = head.item;
            head = head.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LLStacks<String> stack = new LLStacks<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
        }
        for( String s : stack)
            StdOut.println(s);
        StdOut.println("Now to pop");
        while(!stack.isEmpty()){
            StdOut.println(stack.pop());
        }

    }

}
