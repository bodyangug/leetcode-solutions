package com.pandus.leetcode.solutions.weekly

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/winner-of-the-linked-list-game
class WinnerOfLinkedListGame {
    fun gameResult(head: ListNode?): String {
        var even = head
        var evenPoints = 0
        var oddPoints = 0

        while (even != null) {
            val odd = even.next ?: break
            if (even.`val` > odd.`val`) {
                evenPoints += 1
            } else {
                oddPoints += 1
            }
            even = odd.next
        }

        return when {
            oddPoints > evenPoints -> "Odd"
            oddPoints < evenPoints -> "Even"
            else -> "Tie"
        }
    }
}
