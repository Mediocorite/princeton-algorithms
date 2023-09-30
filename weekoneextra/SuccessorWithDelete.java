package weekoneextra;

public class SuccessorWithDelete {
    private final int[] id;  // id[i] = parent of i
    private final int[] size; // size[i] = size of subtree rooted at i

    public SuccessorWithDelete(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int x) {
        while (x != id[x]) {
            id[x] = id[id[x]];  // Path compression
            x = id[x];
        }
        return x;
    }

    public void remove(int x) {
        if (x < id.length - 1) {
            // Union x and x + 1
            int rootX = root(x);
            int rootNext = root(x + 1);
            id[rootX] = rootNext;
            size[rootNext] += size[rootX];
        }
    }

    public int findSuccessor(int x) {
        if (x >= id.length) {
            return -1; // No successor exists
        }
        return root(x);
    }

    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete(10);
        swd.remove(2);
        swd.remove(3);
        swd.remove(4);
        System.out.println(swd.findSuccessor(2));  // Should return 5
        System.out.println(swd.findSuccessor(3));  // Should return 5
        System.out.println(swd.findSuccessor(8));  // Should return 8
    }
}
