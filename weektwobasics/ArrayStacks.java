package weektwobasics;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayStacks<Item> {
    private int N = 0;
    private Item[] stack;

    @SuppressWarnings("unchecked")
    public ArrayStacks()
    { stack = (Item[]) new Object[1]; }

    public boolean isEmpty()
    { return N == 0;}

    public void push(Item item) {
        stack[N++] = item;
        if (stack.length == N) {
            resize(stack.length * 2);
        }
    }
    @SuppressWarnings("unchecked")
    private void resize (int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i ++)
            copy[i] = stack[i];
        stack = copy;
    }

    public Item pop() {
        Item item = stack[--N];
        stack[N] = null;
        if (N > 0 && stack.length / 4 == N) {
            resize(stack.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        ArrayStacks<String> stack = new ArrayStacks<>();
        while (!StdIn.isEmpty()) {
            String el = StdIn.readString();
            stack.push(el);
            StdOut.println(stack.pop());
        }

    }
}
