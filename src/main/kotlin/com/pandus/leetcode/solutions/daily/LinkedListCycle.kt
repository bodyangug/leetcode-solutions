package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode


//Reference: https://leetcode.com/problems/linked-list-cycle
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val nodesSeen = HashSet<ListNode>()
        var current = head
        while (current != null) {
            if (nodesSeen.contains(current)) {
                return true
            }
            nodesSeen.add(current)
            current = current.next
        }
        return false
    }
}
