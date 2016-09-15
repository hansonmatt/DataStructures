package com.matthanson.datastructures.list;

/**
 * Created by Matt on 9/14/16.
 */
public class LinkedList {
    public static class Node {
        int value;
        Node next;
    }

    public Node head;

    public void add(int value) {
        Node n = new Node();
        n.value = value;

        n.next = head;
        head = n;
    }

    public void delete(int value) {
        if (head != null && head.value == value) {
            head = head.next;
            return;
        }

        Node parent = head;
        while (parent.next != null && parent.next.value != value) {
            parent = parent.next;
        }

        if (parent.next != null) {
            parent.next = parent.next.next;
        }
    }

    public void deleteRecursive(int value) {
        if (head != null && head.value == value) {
            head = head.next;
            return;
        }

        deleteRecursive(head, value);
    }

    private void deleteRecursive(Node parent, int value) {
        if (parent == null || parent.next == null) {
            return;
        }

        if (parent.next.value == value) {
            parent.next = parent.next.next;
            return;
        }

        deleteRecursive(parent.next, value);
    }

    public Node find(int value) {
        Node n = head;
        while (n != null && n.value != value) {
            n = n.next;
        }

        return n;
    }
}
