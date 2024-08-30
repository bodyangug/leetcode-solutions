package com.pandus.leetcode.solutions.weekly

import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
class LongestSubstringWithAtMostKDistinctCharacters {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val n = s.length
        var maxSize = 0
        val counter: MutableMap<Char, Int> = HashMap()

        var left = 0
        for (right in 0 until n) {
            counter[s[right]] = counter.getOrDefault(s[right], 0) + 1
            while (counter.size > k) {
                counter[s[left]] = counter[s[left]]!! - 1
                if (counter[s[left]] == 0) {
                    counter.remove(s[left])
                }
                left++
            }
            maxSize = max(maxSize, (right - left + 1))
        }
        return maxSize
    }
}
