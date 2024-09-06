package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
class DeleteNodesFromLinkedListPresentInArray {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val deletedNodes = nums.toSet()
        val sudoHead = ListNode(0)
        sudoHead.next = head

        var curNode = sudoHead
        while (curNode.next != null) {
            if (deletedNodes.contains(curNode.next!!.`val`)) {
                curNode.next = curNode.next!!.next
            } else {
                curNode = curNode.next!!
            }
        }
        return sudoHead.next
    }
}
