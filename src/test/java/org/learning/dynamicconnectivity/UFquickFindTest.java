package org.learning.dynamicconnectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UFquickFindTest {

    @Test
    public void testOnlyTwoNumbersUnionAndTheyAreConnected() {
        UFquickFind uf = new UFquickFind(10);
        uf.union(4, 3);
        assertTrue(uf.connected(4, 3));
    }

    @Test
    public void testOnlyTwoNumbersUnionAreConnectedButReflexive() {
        UFquickFind uf = new UFquickFind(10);
        uf.union(4, 3);
        assertTrue(uf.connected(4, 3));
        assertTrue(uf.connected(3, 4));
    }

    @Test
    public void givenTwoUnionsWhichAreNotTransitive_whenTestForConnectedThem_thenReturnTrue() {
        UFquickFind uf = new UFquickFind(5);
        uf.union(0, 1);
        uf.union(3, 4);
        assertTrue(uf.connected(0, 1));
        assertTrue(uf.connected(3, 4));
    }

    @Test
    public void givenTwoUnionsWhichAreTransitive_whenTestForNotDirectlyUnionNumbers_thenReturnTrue() {
        UFquickFind uf = new UFquickFind(5);
        uf.union(1, 3);
        uf.union(3, 4);

        assertTrue(uf.connected(1, 3));
        assertTrue(uf.connected(3, 4));
        assertTrue(uf.connected(1, 4));
    }

    @Test
    public void givenComponentsAndUnionToConnectThem_whenTestForConnectivity_thenReturnCopyTheSecondComponentIntoOneAndReturnTrue() {
        UFquickFind uf = new UFquickFind(10);
        uf.union(2, 8);
        uf.union(7, 4);
        uf.union(8, 5);
        uf.union(7, 9);
        uf.union(8, 9);

        assertTrue(uf.connected(2, 9));
        assertTrue(uf.connected(8, 4));
    }

    @Test
    public void testForBiggerPool() {
        UFquickFind uf = new UFquickFind(10);
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
