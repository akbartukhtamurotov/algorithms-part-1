package org.learning.dynamicconnectivity;

import java.util.Arrays;

public class UFmySolution {
    private final int[][] components;

    public UFmySolution(int n) {
        components = new int[n][];
        for (int i = 0; i < n; i++) {
            components[i] = new int[n];
            Arrays.fill(components[i], -1);
            components[i][0] = i;
        }
    }

    public void union(int p, int q) {
        int compIndOfP = getComponentIndex(p);
        int compIndOfQ = getComponentIndex(q);

        if (compIndOfP == -1 && compIndOfQ == -1) {
            int nextEmptyComponentIndex = findNextEmptyComponentIndex();
            if (nextEmptyComponentIndex != -1) {
                components[nextEmptyComponentIndex][0] = p;
                components[nextEmptyComponentIndex][1] = q;
            }
        } else if (compIndOfP != -1 && compIndOfQ == -1) {
            int slotIndex = findNextEmptySlotInComponent(compIndOfP);
            components[compIndOfP][slotIndex] = q;
        } else if (compIndOfP == -1) {
            int slotIndex = findNextEmptySlotInComponent(compIndOfQ);
            components[compIndOfQ][slotIndex] = p;
        } else {
            copyComponent(getComponentIndex(p), getComponentIndex(q));
        }
    }

    private void copyComponent(int mainComponentIndex, int secondaryComponentIndex) {
        for (int i = 0; i < components[mainComponentIndex].length; i++) {
            if (components[mainComponentIndex][i] == -1) {
                for (int j = 0; j < components[secondaryComponentIndex].length; j++) {
                    if (components[secondaryComponentIndex][j] != -1) {
                        components[mainComponentIndex][i] = components[secondaryComponentIndex][j];
                        components[secondaryComponentIndex][j] = -1;
                        break;
                    }
                }
            }
        }
    }

    private int findNextEmptyComponentIndex() {
        for (int i = 0; i < components.length; i++) {
            if (components[i][0] == -1) {
                return i;
            }
        }
        return -1;
    }

    private int findNextEmptySlotInComponent(int componentIndex) {
        for (int i = 0; i < components[componentIndex].length; i++) {
            if (components[componentIndex][i] == -1) {
                return i;
            }
        }

        return -1;
    }

    boolean connected(int p, int q) {
        int compInd = getComponentIndex(p);
        return indexOfNumberInComponent(q, compInd) != -1;
    }

    private int getComponentIndex(int m) {
        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].length; j++) {
                if (components[i][j] == m) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int indexOfNumberInComponent(int m, int componentIndex) {
        for (int i = 0; i < components[componentIndex].length; i++) {
            if (components[componentIndex][i] == m) {
                return i;
            }
        }

        return -1;
    }

    int find(int p) {
        return -1;
    }

    int count() {
        return -1;
    }
}
