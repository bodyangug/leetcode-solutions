package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i
class CheckIfStringsCanBeMadeEqualWithOperationsI {
    fun canBeEqual(s1: String, s2: String): Boolean {
        val evenS1 = charArrayOf(s1[0], s1[2]).apply { sort() }
        val evenS2 = charArrayOf(s2[0], s2[2]).apply { sort() }
        val oddS1 = charArrayOf(s1[1], s1[3]).apply { sort() }
        val oddS2 = charArrayOf(s2[1], s2[3]).apply { sort() }
        return evenS1.contentEquals(evenS2) && oddS1.contentEquals(oddS2)
    }
}
