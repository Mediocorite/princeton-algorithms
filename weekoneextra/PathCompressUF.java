package weekoneextra;

public class PathCompressUF {
    private final int[] id;
    private final int[] size;

    public PathCompressUF (int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    // Compressed trees -> O(log* N) times
    public int root(int x) {
        while(x != id[x]) {
            id [x] = id[id[x]]; // <- Make every other node in path point to its grandparent (thereby halving path length).
            x = id[x];
        }
        return x;
    }

    // Compressed trees -> O(log* N) times
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Compressed trees -> O(log* N) times
    public void union(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);

        if (size[rootOfp] > size[rootOfq]) {
            id[rootOfq] = rootOfp;
            size[rootOfp] += size[rootOfq];
        } else {
            id[rootOfp] = rootOfq;
            size[rootOfq] += size[rootOfp];
        };

    }

}
