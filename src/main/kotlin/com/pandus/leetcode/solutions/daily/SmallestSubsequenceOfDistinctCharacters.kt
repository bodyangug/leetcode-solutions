package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
class SmallestSubsequenceOfDistinctCharacters {
    fun smallestSubsequence(s: String): String {
        val stack = mutableListOf<Char>()
        val seen = mutableSetOf<Char>()
        val lastIndex = mutableMapOf<Char, Int>()

        for (i in s.indices) {
            lastIndex[s[i]] = i
        }

        for (i in s.indices) {
            val c = s[i]
            if (c !in seen) {
                while (stack.isNotEmpty() && stack.last() > c && lastIndex[stack.last()]!! > i) {
                    seen.remove(stack.removeAt(stack.size - 1))
                }
                stack.add(c)
                seen.add(c)
            }
        }

        return stack.joinToString("")
    }
}
