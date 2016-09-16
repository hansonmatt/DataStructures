package com.matthanson.datastructures.search;

/**
 * Created by Matt on 9/16/16.
 */
public class BinarySearch<T extends Comparable> {
    public int binarySearch(T[] a, T value) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int start = 0;
        int end = a.length - 1;

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (value.compareTo(a[mid]) > 0) {
                start = mid + 1;
            } else if (value.compareTo(a[mid]) < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
