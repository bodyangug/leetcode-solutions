package com.pandus.leetcode.solutions.daily

// Reference:https://leetcode.com/problems/palindrome-partitioning
class PalindromePartitioning {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val currentList = mutableListOf<String>()
        val memo = Array(s.length) { BooleanArray(s.length) }
        dfs(0, s, currentList, result, memo)
        return result
    }

    private fun dfs(
        start: Int,
        s: String,
        currentList: MutableList<String>,
        result: MutableList<List<String>>,
        memo: Array<BooleanArray>
    ) {
        if (start >= s.length) {
            result.add(ArrayList(currentList))
            return
        }
        for (end in start until s.length) {
            if (s[start] == s[end] && (end - start <= 2 || memo[start + 1][end - 1])) {
                memo[start][end] = true
                currentList.add(s.substring(start, end + 1))
                dfs(end + 1, s, currentList, result, memo)
                currentList.removeAt(currentList.size - 1)
            }
        }
    }
}
