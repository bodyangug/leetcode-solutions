package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced
class MinimumNumberOfSwapsToMakeTheStringBalanced {
    fun minSwaps(s: String): Int {
        val stack: Stack<Char?> = Stack()
        var unbalanced = 0
        for (element in s) {
            if (element == '[') stack.push(element)
            else {
                if (!stack.isEmpty()) stack.pop()
                else unbalanced++
            }
        }
        return (unbalanced + 1) / 2
    }
}
