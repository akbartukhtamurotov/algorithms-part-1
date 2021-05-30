package org.learning.dynamicconnectivity;

public class UFquickUnion {

    private int[] id;

    public UFquickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootOfP = findRoot(p);
        int rootOfQ = findRoot(q);
        id[rootOfP] = rootOfQ;
    }

    private int findRoot(int q) {
        if (id[q] == q) return q;
        return findRoot(id[q]);
    }

    boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }
}
