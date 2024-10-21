package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings
class SplitIntoMaxNumberOfUniqueSubstrings {
    fun maxUniqueSplit(s: String): Int {
        val seen: MutableSet<String> = HashSet()
        return backtrack(s, 0, seen)
    }

    private fun backtrack(s: String, start: Int, seen: MutableSet<String>): Int {
        if (start == s.length) return 0
        var maxCount = 0
        for (end in start + 1..s.length) {
            val substring = s.substring(start, end)
            if (!seen.contains(substring)) {
                seen.add(substring)
                maxCount = max(maxCount, (1 + backtrack(s, end, seen)))
                seen.remove(substring)
            }
        }
        return maxCount
    }
}
