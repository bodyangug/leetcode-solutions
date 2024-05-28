package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.max

//Reference: https://leetcode.com/problems/get-equal-substrings-within-budget
class GetEqualSubstringsWithinBudget {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val N = s.length

        var maxLen = 0
        var start = 0
        var currCost = 0

        for (i in 0 until N) {
            currCost += abs((s[i].code - t[i].code))

            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= abs((s[start].code - t[start].code))
                start++
            }

            maxLen = max(maxLen, (i - start + 1))
        }

        return maxLen
    }
}