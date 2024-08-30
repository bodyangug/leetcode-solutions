package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference:https://leetcode.com/problems/reorder-list
class ReorderList {
    fun reorderList(head: ListNode?) {
        if (head == null) return
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }

        var prev: ListNode? = null
        var curr = slow
        var tmp: ListNode?
        while (curr != null) {
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        }

        var first = head
        var second = prev
        while (second!!.next != null) {
            tmp = first!!.next
            first.next = second
            first = tmp
            tmp = second.next
            second.next = first
            second = tmp
        }
    }
}
