package com.pandus.leetcode.solutions.google;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int n1;
            if (l1 == null) {
                n1 = 0;
            } else {
                n1 = l1.val;
            }

            int n2;
            if (l2 == null) {
                n2 = 0;
            } else {
                n2 = l2.val;
            }

            int sum = n1 + n2 + carry;
            int newVal = sum % 10;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            tail.next = new ListNode(newVal);
            tail = tail.next;
        }
        return dummy.next;
    }
}
