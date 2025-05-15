package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
class LongestUnequalAdjacentGroupsSubsequenceI {
    fun getLongestSubsequence(words: Array<String?>, groups: IntArray): MutableList<String?> {
        val n = words.size
        val dp = IntArray(n) { 1 }
        val prev = IntArray(n) { -1 }
        var maxLen = 1
        var endIndex = 0

        for (i in 1 until n) {
            for (j in i - 1 downTo 0) {
                if (groups[i] != groups[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i]
                endIndex = i
            }
        }

        val result = mutableListOf<String?>()
        var i = endIndex
        while (i != -1) {
            result.add(words[i])
            i = prev[i]
        }
        result.reverse()
        return result
    }
}
