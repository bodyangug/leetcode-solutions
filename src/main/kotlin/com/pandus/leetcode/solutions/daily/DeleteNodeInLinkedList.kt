package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/delete-node-in-a-linked-list
class DeleteNodeInLinkedList {
    fun deleteNode(node: ListNode) {
        // Overwrite data of next node on current node.
        node.`val` = node.next!!.`val`
        // Make current node point to next of next node.
        node.next = node.next!!.next
    }
}
