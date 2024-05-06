package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

//Reference: https://leetcode.com/problems/remove-nodes-from-linked-list
class RemoveNodesFromLinkedList {
    fun removeNodes(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val nextNode = removeNodes(head.next)

        // If the next node has greater value than head, delete the head
        // Return next node, which removes the current head and makes next the new head
        if (head.`val` < nextNode!!.`val`) {
            return nextNode
        }
        // Keep the head
        head.next = nextNode
        return head
    }
}
