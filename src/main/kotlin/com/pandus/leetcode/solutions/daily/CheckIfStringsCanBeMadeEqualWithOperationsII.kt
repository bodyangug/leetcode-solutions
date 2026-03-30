package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii
class CheckIfStringsCanBeMadeEqualWithOperationsII {
    fun checkStrings(s1: String, s2: String): Boolean {
        val evenS1 = s1.filterIndexed { i, _ -> i % 2 == 0 }.toCharArray().sorted()
        val oddS1 = s1.filterIndexed { i, _ -> i % 2 != 0 }.toCharArray().sorted()
        val evenS2 = s2.filterIndexed { i, _ -> i % 2 == 0 }.toCharArray().sorted()
        val oddS2 = s2.filterIndexed { i, _ -> i % 2 != 0 }.toCharArray().sorted()
        return evenS1 == evenS2 && oddS1 == oddS2
    }
}
