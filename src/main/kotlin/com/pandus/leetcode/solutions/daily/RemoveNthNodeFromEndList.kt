package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/remove-nth-node-from-end-of-list
class RemoveNthNodeFromEndList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var length = 0
        var first = head
        while (first != null) {
            length++
            first = first.next
        }
        length -= n
        first = dummy
        while (length > 0) {
            length--
            first = first!!.next
        }
        first!!.next = first.next!!.next
        return dummy.next
    }
}
