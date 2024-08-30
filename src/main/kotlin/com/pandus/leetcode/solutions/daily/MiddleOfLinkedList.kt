package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/middle-of-the-linked-list
class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        val temp = arrayOfNulls<ListNode>(100)
        var h = head
        var idx = 0
        while (h != null) {
            temp[idx++] = h
            h = h.next
        }
        return temp[idx / 2]
    }
}
