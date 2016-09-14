package com.matthanson.datastructures.bst;

/**
 * Created by Matt on 9/14/16.
 */
public class BinarySearchTree {
    public static class Node {
        int value;
        Node left;
        Node right;
    }

    public Node head;

    public void insert(int value) {
        if (head == null) {
            head = new Node();
            head.value = value;
            return;
        }

        insert(head, value);
    }

    private void insert(Node parent, int value) {
        if (parent.value != value) {
            if (parent.value > value) {
                if (parent.left == null) {
                    parent.left = new Node();
                    parent.left.value = value;
                } else {
                    insert(parent.left, value);
                }
            } else {
                if (parent.right == null) {
                    parent.right = new Node();
                    parent.right.value = value;
                } else {
                    insert(parent.right, value);
                }
            }
        }
    }

    public Node search(int value) {
        Node n = head;
        while (n != null && n.value != value) {
            if (n.value > value) {
                n = n.left;
            } else {
                n = n.right;
            }
        }

        return n;
    }

    public Node minimum() {
        if (head == null) {
            return null;
        }

        Node n = head;
        while (n.left != null) {
            n = n.left;
        }

        return n;
    }

    public void traverseInOrder() {
        traverseInOrder(head);
    }

    private void traverseInOrder(Node n) {
        if (n == null) {
            return;
        }

        traverseInOrder(n.left);
        // visit n
        traverseInOrder(n.right);
    }
}
