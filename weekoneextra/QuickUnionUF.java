package weekoneextra;

public class QuickUnionUF {
    // Now we will consider the id array
    // as container of parents/roots of
    // each node.
    private final int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    // New Function root() finds the root/parent of
    // given nodes. The function will keep running
    // until it locates it.
    // Relatively cheap -> O(N) times
    public int root(int x) {
        while(x != id[x]) x = id[x];
        return x;
    }

    // Relatively cheap -> O(N) times
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Relatively cheap -> O(N) times
    public void union(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);

        // Just change the root value
        id[rootOfp] = rootOfq;

    }

}
