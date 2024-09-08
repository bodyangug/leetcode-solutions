package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/split-linked-list-in-parts
class SplitLinkedListInParts {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var (len, p) = 0 to head
        while(p != null) {
            p = p.next
            len++
        }
        var (baseLen, reminder) = (len / k - 1) to (len % k)
        val res = Array<ListNode?>(k) { null }
        p = head

        repeat(k) {
            res[it] = p
            repeat(baseLen + if(reminder > 0) 1 else 0) { p = p?.next }
            if (reminder > 0) reminder--
            p?.next = null.also { p = p?.next }
        }
        return res
    }
}