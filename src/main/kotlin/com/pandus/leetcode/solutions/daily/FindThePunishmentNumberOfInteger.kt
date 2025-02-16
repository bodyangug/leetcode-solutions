package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-punishment-number-of-an-integer
class FindThePunishmentNumberOfInteger {
    fun punishmentNumber(n: Int) = (1..n).sumOf { x ->
        fun dfs(n: Int, s: Int): Boolean = s + n == x ||
                n > 0 && setOf(10, 100, 1000).any { dfs(n / it, s + n % it) }
        if (dfs(x * x, 0)) x * x else 0
    }
}
