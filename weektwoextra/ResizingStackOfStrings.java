package weektwoextra;

public class ResizingStackOfStrings {
    private String[] s;
    private int N = 0;

    // Init it with size of 1.
    public ResizingStackOfStrings () {
        s = new String[1];
    }

    public void push(String item) {
        // i.e. We reached end
        if(N == s.length) resize(s.length * 2);
        s[N++] = item;
    }

    public String pop() {
        String i = s[--N];
        s[N] = null;
        // We only resize half way, to avoid thrashing
        // i.e. if the pop and push operations happen at
        // capacity, repetitively.
        if(N>0 && N == s.length/4) resize(s.length/2);
        return i;
    }

    // Rarely happens. Amortized O(1)
    // k array accesses to double to size k
    // (ignoring cost to create new array)
    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }
}
