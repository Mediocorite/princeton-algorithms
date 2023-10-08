package weektwoextra;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {
    // Implement a inner class
    private class Node {
        String item; // <== String item
        Node next; // <== Reference to next
    }
    private Node root;
    private int size;

    // Creates an empty stack
    public LinkedStackOfStrings() {
        root = null;
        size = 0;
    }

    // Inserts a new string onto stack
    public void push(String item) {
        Node oldRoot = root;
        root = new Node();
        root.item = item;
        root.next = oldRoot;
        size++;
    }

    // Remove and returns the string most recently added
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            String item = root.item;
            root = root.next;
            size--;
            return item;
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Gives the size of the string
    public int size() {
        return size;
    }

    // Client
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop());
            else              stack.push(s);
        }
    }
}
