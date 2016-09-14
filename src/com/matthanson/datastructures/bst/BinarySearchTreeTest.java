package com.matthanson.datastructures.bst;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/14/16.
 */
public class BinarySearchTreeTest {
    @Test
    public void insert() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(15);
        bst.insert(5);
        bst.insert(50);
        assertEquals(20, bst.head.value);
        assertEquals(10, bst.head.left.value);
        assertEquals(5, bst.head.left.left.value);
        assertEquals(15, bst.head.left.right.value);
        assertEquals(50, bst.head.right.value);
    }

    @Test
    public void testSearch() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(50);

        BinarySearchTree.Node n = bst.search(50);
        assertNotNull(n);
        assertEquals(50, n.value);

        n = bst.search(25);
        assertNull(n);
    }

    @Test
    public void testMinimum() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        assertEquals(20, bst.minimum().value);
        bst.insert(10);
        assertEquals(10, bst.minimum().value);
        bst.insert(50);
        assertEquals(10, bst.minimum().value);
        bst.insert(2);
        assertEquals(2, bst.minimum().value);
    }

}