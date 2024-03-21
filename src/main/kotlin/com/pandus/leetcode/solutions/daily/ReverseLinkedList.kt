package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode


//Reference: https://leetcode.com/problems/reverse-linked-list
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }
}