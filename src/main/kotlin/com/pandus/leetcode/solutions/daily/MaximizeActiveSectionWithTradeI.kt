package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-active-section-with-trade-i
class MaximizeActiveSectionWithTradeI {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        val t = "1" + s + "1"
        val totalOnes = s.count { it == '1' }

        val runs = mutableListOf<Pair<Char, Int>>()
        var i = 0
        while (i < t.length) {
            var j = i
            while (j < t.length && t[j] == t[i]) j++
            runs.add(t[i] to (j - i))
            i = j
        }

        var bestGain = 0
        for (k in 1 until runs.size - 1) {
            if (runs[k].first == '1') {
                bestGain = maxOf(bestGain, runs[k - 1].second + runs[k + 1].second)
            }
        }

        return totalOnes + bestGain
    }
}
