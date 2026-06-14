package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
class MaximumTwinSumOfLinkedList {
    fun pairSum(head: ListNode?): Int {
        if (head == null) return 0

        // Step 1: Find the middle of the linked list using the fast and slow pointer technique
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: Reverse the second half of the linked list
        var prev: ListNode? = null
        var current: ListNode? = slow?.next
        while (current != null) {
            val nextTemp = current.next
            current.next = prev
            prev = current
            current = nextTemp
        }

        // Step 3: Calculate the twin sums and find the maximum
        var maxTwinSum = 0
        var firstHalfPointer: ListNode? = head
        var secondHalfPointer: ListNode? = prev
        while (secondHalfPointer != null) {
            val twinSum = firstHalfPointer!!.`val` + secondHalfPointer.`val`
            maxTwinSum = maxOf(maxTwinSum, twinSum)
            firstHalfPointer = firstHalfPointer.next
            secondHalfPointer = secondHalfPointer.next
        }

        return maxTwinSum
    }
}
