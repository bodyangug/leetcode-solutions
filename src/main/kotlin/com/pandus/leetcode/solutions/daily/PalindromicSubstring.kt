package com.pandus.leetcode.solutions.daily

//Refers: https://leetcode.com/problems/palindromic-substrings/description/?envType=daily-question&envId=2024-02-10
class PalindromicSubstring {
    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) { BooleanArray(n) }
        var ans = 0

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1])
                if (dp[i][j]) ans++
            }
        }
        return ans
    }
}
