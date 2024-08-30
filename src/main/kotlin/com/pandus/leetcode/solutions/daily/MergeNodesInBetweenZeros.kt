package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/merge-nodes-in-between-zeros
class MergeNodesInBetweenZeros {
    fun mergeNodes(head: ListNode): ListNode? {
        var modify = head.next
        var nextSum = modify

        while (nextSum != null) {
            var sum = 0
            while (nextSum!!.`val` != 0) {
                sum += nextSum.`val`
                nextSum = nextSum.next
            }

            modify!!.`val` = sum
            nextSum = nextSum.next
            modify.next = nextSum
            modify = modify.next
        }
        return head.next
    }
}
