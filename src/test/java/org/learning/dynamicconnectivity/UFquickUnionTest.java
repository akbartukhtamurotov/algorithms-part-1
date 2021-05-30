package org.learning.dynamicconnectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UFquickUnionTest {

    @Test
    public void testOnlyTwoNumbersUnionAndTheyAreConnected() {
        UFquickUnion uf = new UFquickUnion(10);
        uf.union(4, 3);
        assertTrue(uf.connected(4, 3));
    }

    @Test
    public void test2() {
        UFquickUnion uf = new UFquickUnion(10);
        uf.union(4, 3);
        uf.union(3, 8);
        assertTrue(uf.connected(3, 8));
    }

    @Test
    public void testMergeComponents() {
        UFquickUnion uf = new UFquickUnion(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        assertTrue(uf.connected(3, 8));
    }

    @Test
    public void testForBiggerPool() {
        UFquickUnion uf = new UFquickUnion(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);

        assertFalse(uf.connected(0, 7));
        assertTrue(uf.connected(8, 9));

        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);

        assertTrue(uf.connected(0, 7));
    }
}
