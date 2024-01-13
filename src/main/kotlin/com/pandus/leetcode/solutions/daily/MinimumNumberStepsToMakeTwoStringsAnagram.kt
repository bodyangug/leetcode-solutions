package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
class MinimumNumberStepsToMakeTwoStringsAnagram {
    fun minSteps(s: String, t: String): Int {
        val count = IntArray(26)
        var ans = 0
        for (i in s.indices) {
            count[t[i] - 'a']++
            count[s[i] - 'a']--
        }
        count.forEach { if (it > 0) ans += it }
        return ans
    }
}