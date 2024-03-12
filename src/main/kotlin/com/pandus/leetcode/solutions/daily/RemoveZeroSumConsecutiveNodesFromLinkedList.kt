package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode


//Reference: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val front = ListNode(0, head)
        var start: ListNode? = front
        while (start != null) {
            var prefixSum = 0
            var end = start.next
            while (end != null) {
                prefixSum += end.`val`
                if (prefixSum == 0) {
                    start.next = end.next
                }
                end = end.next
            }
            start = start.next
        }
        return front.next
    }
}