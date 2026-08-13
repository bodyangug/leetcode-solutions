package com.pandus.leetcode.solutions.google;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }

        int toRemove = counter - n;
        counter = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = dummy;
        while (tail != null) {
            if (counter == toRemove) {
                tail.next = tail.next.next;
                return dummy.next;
            }

            tail = tail.next;
            counter++;
        }
        return dummy.next;
    }
}
