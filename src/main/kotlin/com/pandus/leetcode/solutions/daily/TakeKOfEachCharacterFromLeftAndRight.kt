package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/prblems/take-k-of-each-character-from-left-and-right/
class TakeKOfEachCharacterFromLeftAndRight {
    fun takeCharacters(s: String, k: Int): Int {
        val count = IntArray(3)
        val n = s.length

        for (c in s.toCharArray()) {
            count[c.code - 'a'.code]++
        }

        for (i in 0..2) {
            if (count[i] < k) return -1
        }

        val window = IntArray(3)
        var left = 0
        var maxWindow = 0

        for (right in 0 until n) {
            window[s[right].code - 'a'.code]++
            while (left <= right &&
                (count[0] - window[0] < k || count[1] - window[1] < k || count[2] - window[2] < k)
            ) {
                window[s[left].code - 'a'.code]--
                left++
            }
            maxWindow = max(maxWindow, (right - left + 1))
        }
        return n - maxWindow
    }
}
