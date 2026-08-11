package com.pandus.leetcode.solutions.google;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;

            if (v1 > v2) {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            } else {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
