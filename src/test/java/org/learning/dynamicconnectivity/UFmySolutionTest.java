package org.learning.dynamicconnectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UFmySolutionTest {

    @Test
    public void testOnlyTwoNumbersUnionAndTheyAreConnected() {
        UFmySolution UFmySolution = new UFmySolution(10);
        UFmySolution.union(4, 3);
        assertTrue(UFmySolution.connected(4, 3));
    }

    @Test
    public void testOnlyTwoNumbersUnionAreConnectedButReflexive() {
        UFmySolution UFmySolution = new UFmySolution(10);
        UFmySolution.union(4, 3);
        assertTrue(UFmySolution.connected(4, 3));
        assertTrue(UFmySolution.connected(3, 4));
    }

    @Test
    public void givenTwoUnionsWhichAreNotTransitive_whenTestForConnectedThem_thenReturnTrue() {
        UFmySolution UFmySolution = new UFmySolution(5);
        UFmySolution.union(0, 1);
        UFmySolution.union(3, 4);
        assertTrue(UFmySolution.connected(0, 1));
        assertTrue(UFmySolution.connected(3, 4));
    }

    @Test
    public void givenTwoUnionsWhichAreTransitive_whenTestForNotDirectlyUnionNumbers_thenReturnTrue() {
        UFmySolution UFmySolution = new UFmySolution(5);
        UFmySolution.union(1, 3);
        UFmySolution.union(3, 4);

        assertTrue(UFmySolution.connected(1, 3));
        assertTrue(UFmySolution.connected(3, 4));
        assertTrue(UFmySolution.connected(1, 4));
    }

    @Test
    public void givenComponentsAndUnionToConnectThem_whenTestForConnectivity_thenReturnCopyTheSecondComponentIntoOneAndReturnTrue() {
        UFmySolution UFmySolution = new UFmySolution(10);
        UFmySolution.union(2, 8);
        UFmySolution.union(7, 4);
        UFmySolution.union(8, 5);
        UFmySolution.union(7, 9);
        UFmySolution.union(8, 9);

        assertTrue(UFmySolution.connected(2, 9));
        assertTrue(UFmySolution.connected(8, 4));
    }

    @Test
    public void test() {
        UFmySolution UFmySolution = new UFmySolution(10);
        UFmySolution.union(4, 3);
        UFmySolution.union(3, 8);
        UFmySolution.union(6, 5);
        UFmySolution.union(9, 4);
        UFmySolution.union(2, 1);

        assertFalse(UFmySolution.connected(0, 7));
        assertTrue(UFmySolution.connected(8, 9));

        UFmySolution.union(5, 0);
        UFmySolution.union(7, 2);
        UFmySolution.union(6, 1);
        UFmySolution.union(1, 0);

        assertTrue(UFmySolution.connected(0, 7));
    }
}
