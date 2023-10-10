package weektwoextra;

import java.util.Iterator;

public class ResizingStackOfItemsWithIterator<Item> implements Iterable<Item> {

    private int N = 0;
    @SuppressWarnings("unchecked")
    private Item[] stack = (Item[]) new Object[1];

    public boolean isEmpty()
    { return N == 0; }


    public void push(Item item) {
        if (N == stack.length) resize(stack.length * 2);
        stack[N++] = item;
    }

    public Item pop () {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        if(N > 0 && N < stack.length / 4) resize(stack.length/2);
        Item i = stack[--N];
        stack[N] = null;
        return i;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = stack[i];
        stack = copy;
    }

    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return stack[--i] ;}
    }

}
