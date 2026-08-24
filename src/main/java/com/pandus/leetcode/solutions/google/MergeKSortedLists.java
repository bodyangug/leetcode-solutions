package com.pandus.leetcode.solutions.google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list == null) continue;
            pq.offer(list);
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = cur;

            if (cur.next != null) pq.offer(cur.next);
        }
        return dummy.next;
    }

}
