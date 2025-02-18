package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-smallest-number-from-di-string
class ConstructSmallestNumberFromDIString {
    fun smallestNumber(p: String): String {
        fun dfs(i: Int, n: Int, m: Int): Int? =
            if (i > p.length) n else (1..9).firstNotNullOfOrNull { x ->
                if (1 shl x and m > 0 || (i > 0 && (p[i - 1] > 'D') != (x > n % 10)))
                    null else dfs(i + 1, n * 10 + x, 1 shl x or m)
            }
        return "${dfs(0, 0, 0)}"
    }
}
