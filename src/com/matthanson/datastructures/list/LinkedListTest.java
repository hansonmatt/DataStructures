package com.matthanson.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/15/16.
 */
public class LinkedListTest {
    @Test
    public void add() throws Exception {
        LinkedList list = new LinkedList();
        assertNull(list.head);
        list.add(1);
        assertEquals(1, list.head.value);

        list.add(2);
        assertEquals(2, list.head.value);
        assertEquals(1, list.head.next.value);
    }

    @Test
    public void delete() throws Exception {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(4);
        assertEquals(3, list.head.value);

        list.delete(2);
        assertEquals(1, list.head.next.value);
    }

    @Test
    public void find() throws Exception {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        LinkedList.Node n = list.find(3);
        assertNotNull(n);
        assertEquals(3, n.value);

        assertNull(list.find(500));
    }

}