package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
class ConvertBinaryNumberInLinkedListToInteger {
    fun getDecimalValue(head: ListNode?): Int {
        var ans = 0
        var node = head
        while (node != null) {
            ans = (ans shl 1) or node.`val`
            node = node.next
        }
        return ans
    }
}
