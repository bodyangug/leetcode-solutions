package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
class KLexicographicalStringOfAllHappyStringsOfLengthN {
    private var count = 0
    private var result: String? = null

    fun getHappyString(n: Int, k: Int): String {
        generateHappyStrings(n, "", k)
        return result ?: ""
    }

    private fun generateHappyStrings(n: Int, current: String, k: Int) {
        if (current.length == n) {
            count++
            if (count == k) {
                result = current
            }
            return
        }
        for (ch in listOf('a', 'b', 'c')) {
            if (current.isNotEmpty() && current.last() == ch) continue
            generateHappyStrings(n, current + ch, k)
            if (result != null) return
        }
    }
}
