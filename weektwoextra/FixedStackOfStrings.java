package weektwoextra;

public class FixedStackOfStrings {
    private final String[] s;
    private int N = 0;

    public FixedStackOfStrings (int size) {
        s = new String[size];
    }

    public void push(String item){
        s[N++] = item;
    }

    public String pop() {
        return s[N--];
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
