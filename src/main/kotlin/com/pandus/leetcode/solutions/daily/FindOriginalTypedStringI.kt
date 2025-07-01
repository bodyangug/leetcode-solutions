package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-original-typed-string-i
class FindOriginalTypedStringI {
    fun possibleStringCount(word: String): Int {
        val n = word.length
        var ans = 1
        for (i in 1..<n) {
            if (word[i - 1] == word[i]) {
                ++ans
            }
        }
        return ans
    }
}
