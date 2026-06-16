package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
class DeleteMiddleNodeOfLinkedList {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null
        var slow = head
        var fast: ListNode? = head.next?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        slow?.next = slow?.next?.next
        return head
    }
}