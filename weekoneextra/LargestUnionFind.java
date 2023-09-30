package weekoneextra;

public class LargestUnionFind {
    private final int[] id;
    private final int[] size;
    private final int[] largest;

    public LargestUnionFind (int N) {
        id = new int[N];
        size = new int[N];
        largest = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            largest[i] = i;
            size[i] = 1;
        }
    }

    // Compressed trees -> O(log* N) times
    public int root(int x) {
        int currentWeight = x;
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
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]) {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
            largest[rootP] = Math.max(largest[rootP], largest[rootQ]);
        } else {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
            largest[rootQ] = Math.max(largest[rootP], largest[rootQ]);
        }
    }

    public int find(int i) {
        int rootI = root(i);
        return largest[rootI];
    }
}
