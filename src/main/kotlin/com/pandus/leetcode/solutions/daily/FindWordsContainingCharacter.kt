package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-words-containing-character
class FindWordsContainingCharacter {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        return words.mapIndexedNotNull { index, word ->
            if (x in word) index else null
        }
    }
}
