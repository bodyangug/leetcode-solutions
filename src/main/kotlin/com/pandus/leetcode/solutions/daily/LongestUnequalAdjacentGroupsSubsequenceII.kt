package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii
class LongestUnequalAdjacentGroupsSubsequenceII {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val n = words.size
        val dp = IntArray(n) { 1 }
        val prev = IntArray(n) { -1 }
        var maxIndex = 0

        for (i in 1 until n) {
            for (j in 0 until i) {
                if (groups[i] != groups[j] &&
                    dp[j] + 1 > dp[i] &&
                    differsByOneChar(words[i], words[j])
                ) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i
            }
        }

        val result = mutableListOf<String>()
        var index = maxIndex
        while (index >= 0) {
            result.add(words[index])
            index = prev[index]
        }
        result.reverse()
        return result
    }

    private fun differsByOneChar(a: String, b: String): Boolean {
        if (a.length != b.length) return false
        var diff = 0
        for (i in a.indices) {
            if (a[i] != b[i] && ++diff > 1) return false
        }
        return diff == 1
    }
}
