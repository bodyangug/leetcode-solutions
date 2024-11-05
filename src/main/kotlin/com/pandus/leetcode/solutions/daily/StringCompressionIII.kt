package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/string-compression-iii
class StringCompressionIII {
    fun compressedString(word: String): String {
        val comp = StringBuilder("")
        var pos = 0
        while (pos < word.length) {
            var consecutiveCount = 0

            val currentChar = word[pos]
            while (
                pos < word.length &&
                consecutiveCount < 9 &&
                word[pos] == currentChar
            ) {
                consecutiveCount++
                pos++
            }
            comp.append(consecutiveCount).append(currentChar)
        }
        return comp.toString()
    }
}
