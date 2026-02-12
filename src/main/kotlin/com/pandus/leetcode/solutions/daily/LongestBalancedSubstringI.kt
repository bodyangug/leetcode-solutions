package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-balanced-substring-i
class LongestBalancedSubstringI {
    fun longestBalanced(s: String): Int {
        val n = s.length
        var res = 0
        val cnt = IntArray(26)

        for (i in 0..<n) {
            cnt.fill(0)
            for (j in i..<n) {
                var flag = true
                val c = s[j].code - 'a'.code
                cnt[c]++

                for (x in cnt) {
                    if (x > 0 && x != cnt[c]) {
                        flag = false
                        break
                    }
                }

                if (flag) {
                    res = max(res, j - i + 1)
                }
            }
        }
        return res
    }
}
