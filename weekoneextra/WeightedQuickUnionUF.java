package weekoneextra;

public class WeightedQuickUnionUF {

    private final int[] id;
    private final int[] size;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1; // All the nodes are isolated and have size 1
        }
    }

    // Better trees -> O(log N) times
    public int root(int x) {
        while(x != id[x]) x = id[x];
        return x;
    }

    // Better trees -> O(log N) times
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Better trees -> O(log N) times
    public void union(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);

        // We will now only combine the smaller
        // trees into the larger trees. Thus
        // preventing root function from being
        // too bad (i.e. the trees will be shorter in height)
        if (size[rootOfp] > size[rootOfq]) {
            id[rootOfq] = rootOfp;
            size[rootOfp] += size[rootOfq];
        } else {
            id[rootOfp] = rootOfq;
            size[rootOfq] += size[rootOfp];
        };

    }


}
