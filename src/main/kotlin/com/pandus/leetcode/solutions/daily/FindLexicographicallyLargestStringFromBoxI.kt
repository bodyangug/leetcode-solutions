package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i
class FindLexicographicallyLargestStringFromBoxI {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) {
            return word
        }
        val n = word.length
        var res = ""
        for (i in 0..<n) {
            val s = word.substring(i, min((i + n - numFriends + 1), n))
            if (res <= s) {
                res = s
            }
        }
        return res
    }
}
