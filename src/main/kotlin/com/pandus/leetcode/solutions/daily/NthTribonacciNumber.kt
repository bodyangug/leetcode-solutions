package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/n-th-tribonacci-number
class NthTribonacciNumber {
    private val dp: MutableMap<Int, Int> = mutableMapOf(Pair(0, 0), Pair(1, 1), Pair(2, 1))

    private fun dfs(i: Int): Int {
        if (dp.containsKey(i)) {
            return dp[i]!!
        }

        val answer = dfs(i - 1) + dfs(i - 2) + dfs(i - 3)
        dp[i] = answer
        return answer
    }

    fun tribonacci(n: Int): Int {
        return dfs(n)
    }
}
