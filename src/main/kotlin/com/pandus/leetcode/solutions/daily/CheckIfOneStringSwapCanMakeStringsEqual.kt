package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal
class CheckIfOneStringSwapCanMakeStringsEqual {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val diffs = s1.indices.filter { s1[it] != s2[it] }
        return diffs.isEmpty() || (diffs.size == 2 && s1[diffs[0]] == s2[diffs[1]] && s1[diffs[1]] == s2[diffs[0]])
    }
}
