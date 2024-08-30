package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
class AppendCharactersToStringToMakeSubsequence {
    fun appendCharacters(s: String, t: String): Int {
        var first = 0
        var longestPrefix = 0
        while (first < s.length && longestPrefix < t.length) {
            if (s[first] == t[longestPrefix]) {
                longestPrefix++
            }
            first++
        }
        return t.length - longestPrefix
    }
}
