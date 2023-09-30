package weekoneextra;

public class SocialNetworkUF {
    private final int[] id;
    private final int[] size;
    private int components;

    public SocialNetworkUF(int N) {
        id = new int[N];
        size = new int[N];
        components = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int x) {
        while (x != id[x]) {
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]) {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        components--;
    }

    public int getComponents() {
        return components;
    }

    public static void main(String[] args) {
        // Initialize with N = 5 members
        SocialNetworkUF sn = new SocialNetworkUF(5);

        // Sample log entries: (member1, member2, timestamp)
        int[][] logs = {{0, 1, 1}, {2, 3, 2}, {1, 4, 3}, {3, 4, 4}, {0, 4, 5}};

        for (int[] log : logs) {
            int p = log[0];
            int q = log[1];
            int time = log[2];

            if (!sn.connected(p, q)) {
                sn.union(p, q);
            }

            if (sn.getComponents() == 1) {
                System.out.println("All members are connected at time: " + time);
                break;
            }
        }
    }
}
