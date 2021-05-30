package org.learning.dynamicconnectivity;

public class UFquickFind {

    int[] id;

    public UFquickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        int commonId = id[p];
        int idOfQ = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idOfQ) {
                id[i] = commonId;
            }
        }
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    int find(int p) {
        return -1;
    }

    int count() {
        return -1;
    }
}
