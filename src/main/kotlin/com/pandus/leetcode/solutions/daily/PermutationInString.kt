package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/permutation-in-string
class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val sortedS1 = s1.toCharArray().sorted()

        for (i in 0..s2.length - s1.length) {
            val substring = s2.substring(i, i + s1.length).toCharArray().sorted().toCharArray()
            if (sortedS1.toCharArray().contentEquals(substring)) {
                return true
            }
        }

        return false
    }
}
