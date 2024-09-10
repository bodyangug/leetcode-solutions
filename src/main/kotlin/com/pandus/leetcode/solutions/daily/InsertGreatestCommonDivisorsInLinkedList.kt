package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list
class InsertGreatestCommonDivisorsInLinkedList {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var currentNode = head
        while (currentNode?.next != null) {
            val nextNode = currentNode.next

            val gcdNode = ListNode(gcd(currentNode.`val`, nextNode!!.`val`))
            gcdNode.next = nextNode
            currentNode.next = gcdNode

            currentNode = nextNode
        }
        return head
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
