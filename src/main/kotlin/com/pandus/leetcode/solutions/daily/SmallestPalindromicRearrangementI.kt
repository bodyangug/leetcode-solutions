package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-palindromic-rearrangement-i
class SmallestPalindromicRearrangementI {
    fun smallestPalindrome(s: String): String {
        val count = IntArray(26)
        for (c in s) {
            count[c - 'a']++
        }
        val half = StringBuilder()
        var middle = ""
        for (i in 0 until 26) {
            if (count[i] % 2 == 1) {
                middle = ('a' + i).toString()
            }
            half.append((('a' + i).toString()).repeat(count[i] / 2))
        }
        return half.toString() + middle + half.reverse().toString()
    }
}
