package weektwoextra;

public class FixedStackOfStrings {
    private final String[] s;
    private int N = 0;

    // Cheat is used. Realistically we won't know
    // the max size of the stack.
    public FixedStackOfStrings (int size) {
        s = new String[size];
    }

    public void push(String item){
        s[N++] = item;
    }

    public String pop() {
        // This creates Loitering
        //return s[N--];

        String i = s[--N]; // Avoids Loitering
        s[N] = null; // Garbage collector reclaims mem
        return i;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
