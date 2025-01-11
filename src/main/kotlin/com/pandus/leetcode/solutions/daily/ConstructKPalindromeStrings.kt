package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-k-palindrome-strings
class ConstructKPalindromeStrings {
    fun canConstruct(s: String, k: Int): Boolean {
        if (s.length < k) return false
        val charCount = IntArray(26)
        for (c in s) charCount[c - 'a']++
        var oddCount = 0
        charCount.forEach { oddCount += (it and 1) }
        return k >= oddCount
    }
}
