package weektwoextra;

public class LinkedStackOfItems<Item> {
    private Node root = null;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return root == null;}

    public void push(Item item) {
        Node oldFirst = root;
        root = new Node();
        root.item = item;
        root.next = oldFirst;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Item i = root.item;
        root = root.next;
        return i;
    }
}
