package weekoneextra;

public class QuickFindUF {
    private final int[] id;

    public QuickFindUF(int N) {
        // N is the number of elements
        // Constructor initializes default ids
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    // Easy Check -> Constant time O(1)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Expensive Union -> Quadratic Time O(N^2)
    public void union(int p, int q) {
        // Convert all p[id]s to q[id]s
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = qid;
        }
    }
}