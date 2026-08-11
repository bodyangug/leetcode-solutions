package com.pandus.leetcode.solutions.google;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> storage = new HashMap<>();
        Node copyNode = head;
        while (copyNode != null) {
            Node n = new Node(copyNode.val);
            storage.put(copyNode, n);
            copyNode = copyNode.next;
        }

        copyNode = head;
        while (copyNode != null) {
            Node c = storage.get(copyNode);
            c.next = storage.get(copyNode.next);
            c.random = storage.get(copyNode.random);
            copyNode = copyNode.next;
        }
        return storage.get(head);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}