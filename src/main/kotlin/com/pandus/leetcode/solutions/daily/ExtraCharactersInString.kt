package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/extra-characters-in-a-string
class ExtraCharactersInString {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val n = s.length
        val wordSet = dictionary.toSet()
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        val maxWordLength = dictionary.maxOfOrNull { it.length } ?: 0

        for (i in 1..n) {
            dp[i] = dp[i - 1] + 1
            for (l in 1..minOf(i, maxWordLength)) {
                val substring = s.substring(i - l, i)
                if (substring in wordSet) {
                    dp[i] = minOf(dp[i], dp[i - l])
                }
            }
        }
        return dp[n]
    }
}
