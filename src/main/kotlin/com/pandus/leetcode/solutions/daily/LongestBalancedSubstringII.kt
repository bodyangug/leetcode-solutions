package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-balanced-substring-ii
class LongestBalancedSubstringII {
    fun longestBalanced(s: String): Int {
        val n = s.length
        if (n == 0) return 0
        var ans = 1

        // Case 1: All three chars with equal counts
        // Track (ca-cb, ca-cc); same key at two positions ⇒ equal counts in between
        val seen3 = HashMap<Long, Int>()
        seen3[0L] = 0
        var ca = 0
        var cb = 0
        var cc = 0
        for (i in s.indices) {
            when (s[i]) {
                'a' -> ca++
                'b' -> cb++
                'c' -> cc++
            }
            val key = (ca - cb).toLong() * 200001 + (ca - cc)
            seen3.getOrPut(key) { i + 1 }.let { ans = maxOf(ans, i + 1 - it) }
        }

        // Case 2: Exactly two chars (exclude one), equal counts
        val pairs = listOf(
            Triple('c', 'a', 'b'),
            Triple('b', 'a', 'c'),
            Triple('a', 'b', 'c')
        )
        for ((excl, c1, _) in pairs) {
            var start = 0
            while (start < n) {
                if (s[start] == excl) {
                    start++
                    continue
                }
                var end = start
                while (end < n && s[end] != excl) end++
                // Within this excl-free segment, find longest substring with count(c1) == count(c2)
                val seen2 = HashMap<Int, Int>()
                seen2[0] = start
                var diff = 0
                for (i in start until end) {
                    diff += if (s[i] == c1) 1 else -1
                    seen2.getOrPut(diff) { i + 1 }.let { ans = maxOf(ans, i + 1 - it) }
                }
                start = end
            }
        }

        // Case 3: Single character runs
        var i = 0
        while (i < n) {
            var j = i
            while (j < n && s[j] == s[i]) j++
            ans = maxOf(ans, j - i)
            i = j
        }
        return ans
    }
}
