package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/palindrome-linked-list
class PalindromeLinkedList {
    // O(n)
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        val list = ArrayList<Int>()
        list.add(head.`val`)

        var next = head.next
        while (next != null) {
            list.add(next.`val`)
            next = next.next
        }
        return list == list.reversed()
    }

    // O(1)
    fun isPalindrome2(head: ListNode?): Boolean {
        if (head?.next == null) return true // empty or single-node lists are palindromes

        // go to the middle of the list
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // reverse the second half of the list
        var prev: ListNode? = null
        var current = slow
        while (current != null) {
            val nextTemp = current.next
            current.next = prev
            prev = current
            current = nextTemp
        }

        // compare the first and the second half
        var p1 = head
        var p2 = prev
        while (p1 != null && p2 != null) {
            if (p1.`val` != p2.`val`) return false
            p1 = p1.next
            p2 = p2.next
        }
        return true
    }
}
