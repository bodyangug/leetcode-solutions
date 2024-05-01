package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/reverse-prefix-of-word
class ReversePrefixOfWord {
    fun reversePrefix(word: String, ch: Char): String {
        val chIndex = word.indexOf(ch)
        if (chIndex == -1) {
            return word
        }

        val result = StringBuilder()

        for (i in word.indices) {
            // Add characters through ch to the result in reverse order
            if (i <= chIndex) {
                result.append(word[chIndex - i])
            } else {
                result.append(word[i])
            }
        }

        return result.toString()
    }
}
