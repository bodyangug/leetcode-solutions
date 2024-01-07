package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var tail: ListNode? = null
        var head: ListNode? = null

        var topNode = l1
        var bottomNode = l2

        var carry = 0 // 1 or 0
        while (topNode != null || bottomNode != null || carry != 0) {

            val top = topNode?.`val` ?: 0
            val bottom = bottomNode?.`val` ?: 0

            val sum = top + bottom + carry
            val newNum = sum % 10
            carry = if (sum > 9) 1 else 0

            val newNode = ListNode(newNum)
            if (tail == null) {
                tail = newNode
                head = tail
            } else {
                head!!.next = newNode
                head = newNode
            }

            topNode = topNode?.next
            bottomNode = bottomNode?.next
        }
        return tail
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}