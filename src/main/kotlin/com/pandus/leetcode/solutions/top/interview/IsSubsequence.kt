package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/is-subsequence
class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var hit = 0
        val orig = t.toCharArray()
        val sub = s.toCharArray()
        var lastIndex = 0
        for (charSub in sub) {
            for (indxOrig in lastIndex..<orig.size) {
                if (charSub == orig[indxOrig]) {
                    hit++
                    lastIndex = indxOrig + 1
                    break
                }
            }
        }
        return hit == s.length
    }
}