package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
class NumberOfWaysToFormTargetStringGivenDictionary {
    fun numWays(words: Array<String>, target: String): Int {
        val fr = Array(words[0].length) { IntArray(26) }
        for (w in words) for (i in w.indices) fr[i][w[i] - 'a']++
        val dp = Array(fr.size + 1) { LongArray(target.length + 1) { -1L } }
        fun dfs(posF: Int, posT: Int): Long =
            dp[posF][posT].takeIf { it >= 0 } ?: (
                    if (posT == target.length) 1L else if (posF == fr.size) 0L else {
                        val notTake = dfs(posF + 1, posT)
                        val curr = fr[posF][target[posT] - 'a'].toLong()
                        val take = if (curr > 0) curr * dfs(posF + 1, posT + 1) else 0
                        val res = take + notTake
                        res % 1_000_000_007L
                    }
                    ).also { dp[posF][posT] = it }
        return dfs(0, 0).toInt()
    }
}
