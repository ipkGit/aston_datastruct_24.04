package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Sort.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {

    @Test
    void quickSortTest() {

        int[] unsortedArr = new int[]{1, -11, 56, -11, 32, 121, 2, 16};
        sort(unsortedArr);          //-11, -11, 1, 2, 16, 32, 56, 121

        assertEquals(-11, unsortedArr[0]);
        assertEquals(121, unsortedArr[7]);
        assertEquals(2, unsortedArr[3]);
    }
}