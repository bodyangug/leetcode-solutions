package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones
class CountTheNumberOfSubstringsWithDominantOnes {
    fun numberOfSubstrings(s: String): Int {
        val n = s.length
        val pre = IntArray(n + 1) { -1 }

        for (i in 0..<n) {
            pre[i + 1] = if (i == 0 || s[i - 1] == '0') i else pre[i]
        }

        var res = 0
        for (i in 1..n) {
            var cnt0 = if (s[i - 1] == '0') 1 else 0
            var j = i

            while (j > 0 && cnt0 * cnt0 <= n) {
                val cnt1 = (i - pre[j]) - cnt0
                if (cnt0 * cnt0 <= cnt1) {
                    res += min(j - pre[j], cnt1 - cnt0 * cnt0 + 1)
                }
                j = pre[j]
                cnt0++
            }
        }
        return res
    }
}
