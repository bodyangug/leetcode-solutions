package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/words-within-two-edits-of-dictionary
class WordsWithinTwoEditsOfDictionary {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val result = mutableListOf<String>()
        for (query in queries) {
            for (word in dictionary) {
                if (isWithinTwoEdits(query, word)) {
                    result.add(query)
                    break
                }
            }
        }
        return result
    }

    private fun isWithinTwoEdits(word1: String, word2: String): Boolean {
        var edits = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i]) {
                edits++
                if (edits > 2) return false
            }
        }
        return true
    }
}
