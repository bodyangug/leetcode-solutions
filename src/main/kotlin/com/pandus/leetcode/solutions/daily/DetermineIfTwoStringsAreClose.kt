package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/determine-if-two-strings-are-close
class DetermineIfTwoStringsAreClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }

        val word1Map = word1.groupingBy { it }.eachCount()
        val word2Map = word2.groupingBy { it }.eachCount()

        if (word1Map.keys != word2Map.keys) {
            return false
        }
        return word1Map.values.sorted() == word2Map.values.sorted()
    }
}
