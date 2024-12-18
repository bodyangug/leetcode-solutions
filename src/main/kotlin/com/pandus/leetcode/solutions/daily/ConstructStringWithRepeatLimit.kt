package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/construct-string-with-repeat-limit
class ConstructStringWithRepeatLimit {
    fun repeatLimitedString(s: String, repeatLimit: Int) = buildString {
        val f = IntArray(26)
        for (c in s) f[c - 'a']++
        var cnt = 0
        var i = 25
        var j = i
        while (i >= 0) {
            if (f[i] == 0) {
                i--
                continue
            }
            if (isEmpty() || get(length - 1) == 'a' + i) cnt++ else cnt = 1
            if (cnt > repeatLimit) {
                j = min(j, i - 1)
                while (j >= 0 && f[j] == 0) j--
                if (j >= 0) {
                    append('a' + j)
                    f[j]--
                } else break
            } else {
                append('a' + i)
                f[i]--
            }
        }
    }
}
