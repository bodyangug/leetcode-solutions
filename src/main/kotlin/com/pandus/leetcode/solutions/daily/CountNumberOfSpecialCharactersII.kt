package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-special-characters-ii
class CountNumberOfSpecialCharactersII {
    fun numberOfSpecialChars(word: String): Int {
        val lastLower = IntArray(26) { -1 }
        val firstUpper = IntArray(26) { -1 }

        for (i in word.indices) {
            val c = word[i]
            if (c.isLowerCase()) {
                lastLower[c - 'a'] = i
            } else {
                if (firstUpper[c - 'A'] == -1) {
                    firstUpper[c - 'A'] = i
                }
            }
        }

        var count = 0
        for (i in 0 until 26) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                count++
            }
        }
        return count
    }
}
