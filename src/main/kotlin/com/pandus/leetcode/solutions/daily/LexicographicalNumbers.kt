package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/lexicographical-numbers
class LexicographicalNumbers {
    val result = ArrayList<Int>()

    fun lexicalOrder(n: Int): List<Int> {
        for (i in 1..9) {
            dfs(i, n)
        }
        return result
    }

    private fun dfs(number: Int, n: Int) {
        if (number > n) return
        result.add(number)
        for (i in 0..9) {
            dfs(number * 10 + i, n)
        }
    }
}
