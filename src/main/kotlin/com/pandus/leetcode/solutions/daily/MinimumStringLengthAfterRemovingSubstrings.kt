package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-string-length-after-removing-substrings
class MinimumStringLengthAfterRemovingSubstrings {
    fun minLength(s: String): Int {
        val stack = mutableListOf<Char>()
        for (c in s) {
            if (stack.isNotEmpty()) {
                val last = stack.last()
                if ((last == 'A' && c == 'B') || (last == 'C' && c == 'D')) {
                    stack.removeAt(stack.size - 1)
                } else {
                    stack.add(c)
                }
            } else {
                stack.add(c)
            }
        }
        return stack.size
    }
}
