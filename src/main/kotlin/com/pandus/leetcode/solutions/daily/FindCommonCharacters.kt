package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-common-characters
class FindCommonCharacters {
    fun commonChars(words: Array<String>): List<String> {
        val commonCharacterCounts = IntArray(26) { Int.MAX_VALUE }

        for (word in words) {
            val currentCharacterCounts = IntArray(26)
            for (ch in word) {
                currentCharacterCounts[ch - 'a']++
            }
            for (i in 0 until 26) {
                commonCharacterCounts[i] = minOf(commonCharacterCounts[i], currentCharacterCounts[i])
            }
        }

        val result = mutableListOf<String>()
        for (i in 0 until 26) {
            repeat(commonCharacterCounts[i]) {
                result.add(('a' + i).toString())
            }
        }

        return result
    }
}
