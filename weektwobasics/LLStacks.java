package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LLStacks<Item> {
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

    public static void main(String[] args) {
        LLStacks stack = new LLStacks();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stack.push(item);
            StdOut.println(stack.pop());
        }

    }

}
