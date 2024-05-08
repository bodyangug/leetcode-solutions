package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import java.util.Stack

//Reference: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
class DoubleNumberRepresentedAsLinkedList {
    fun doubleIt(head: ListNode?): ListNode? {
        var head = head
        val values = Stack<Int>()
        var `val` = 0

        // Traverse the linked list and push its values onto the stack
        while (head != null) {
            values.push(head.`val`)
            head = head.next
        }

        var newTail: ListNode? = null

        // Iterate over the stack of values and the carryover
        while (!values.isEmpty() || `val` != 0) {
            // Create a new ListNode with value 0 and the previous tail as its next node
            newTail = ListNode(0, newTail)

            // Calculate the new value for the current node
            // by doubling the last digit, adding carry, and getting the remainder
            if (!values.isEmpty()) {
                `val` += values.pop() * 2
            }
            newTail.`val` = `val` % 10
            `val` /= 10
        }
        return newTail
    }
}
