package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word
class NumberOfStringsThatAppearAsSubstringsInWord {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        var count = 0
        for (pattern in patterns) {
            if (word.contains(pattern)) {
                count++
            }
        }
        return count
    }
}
