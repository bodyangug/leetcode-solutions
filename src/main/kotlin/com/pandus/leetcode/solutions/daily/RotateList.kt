package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/rotate-list
class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || head.next == null || k == 0) return head

        // Compute the length of the list and get the tail node
        var length = 1
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
            length++
        }

        // Connect the tail to the head to make it circular
        tail?.next = head

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        val stepsToNewHead = length - k % length
        var newTail = head
        for (i in 1 until stepsToNewHead) {
            newTail = newTail?.next
        }
        val newHead = newTail?.next

        // Break the circle
        newTail?.next = null

        return newHead
    }
}
