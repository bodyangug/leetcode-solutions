package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i
class FindLongestSpecialSubstringThatOccursThriceI {
    fun maximumLength(s: String): Int {
        val occurs = Array(26) { IntArray(s.length + 1) }
        var start = 0
        var end = 0
        var longest = -1
        while (end <= s.length) {
            if (end == s.length || s[start] != s[end]) {
                val length = end - start
                for (i in 1..length) {
                    val charIndex = s[start] - 'a'
                    occurs[charIndex][i] += length - i + 1

                    if (occurs[charIndex][i] >= 3) {
                        longest = maxOf(longest, i)
                    }
                }
                start = end
            }
            end++
        }
        return longest
    }
}
