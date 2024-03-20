package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode


//Reference: https://leetcode.com/problems/merge-in-between-linked-lists
class MergeInBetweenLinkedLists {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var start: ListNode? = null
        var end = list1
        var tail = list2

        // Find nodes for start and end
        for (index in 0 until b) {
            if (index == a - 1) start = end
            end = end?.next
        }
        // Connect start node to list2
        start?.next = list2

        // Find the tail of list2
        while (tail?.next != null) tail = tail.next
        // Connect tail of list2 to end.next
        tail?.next = end?.next
        end?.next = null
        return list1
    }
}