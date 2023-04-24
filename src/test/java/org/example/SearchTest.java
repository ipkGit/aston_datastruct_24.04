package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Search.binarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    @Test
    void binarySearchTest() {
        int[] sortedArr = new int[]{-11, 11, 13, 51, 61, 171, 222};

        assertEquals(0, binarySearch(sortedArr, -11));
        assertEquals(4, binarySearch(sortedArr, 61));
        assertEquals(6, binarySearch(sortedArr, 222));
        assertEquals(-1, binarySearch(sortedArr, 33));
    }
}