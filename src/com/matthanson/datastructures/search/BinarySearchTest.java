package com.matthanson.datastructures.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/16/16.
 */
public class BinarySearchTest {
    @Test
    public void binarySearch() throws Exception {
        BinarySearch<Integer> bs = new BinarySearch<>();

        // even length array
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(4, bs.binarySearch(a, 5));
        assertEquals(-1, bs.binarySearch(a, 100));

        // odd length array
        assertEquals(1, bs.binarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
        assertEquals(4, bs.binarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
        assertEquals(7, bs.binarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 8));
        assertEquals(-1, bs.binarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1000));

        // single element array
        assertEquals(0, bs.binarySearch(new Integer[]{50}, 50));
        assertEquals(-1, bs.binarySearch(new Integer[]{50}, 100));

        // null/empty array
        assertEquals(-1, bs.binarySearch(new Integer[0], 50));
        assertEquals(-1, bs.binarySearch(null, 50));
    }

}