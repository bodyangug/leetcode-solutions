package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii
class MaximumNumberOfEventsThatCanBeAttendedII {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortBy { it[0] }
        val n = events.size
        val dp = Array(k + 1) { IntArray(n) { -1 } }

        fun dfs(curIndex: Int, count: Int): Int {
            if (count == 0 || curIndex == n) return 0
            if (dp[count][curIndex] != -1) return dp[count][curIndex]

            val nextIndex = bisectRight(events, events[curIndex][1])
            val skip = dfs(curIndex + 1, count)
            val take = events[curIndex][2] + dfs(nextIndex, count - 1)
            dp[count][curIndex] = maxOf(skip, take)
            return dp[count][curIndex]
        }

        return dfs(0, k)
    }

    private fun bisectRight(events: Array<IntArray>, target: Int): Int {
        var left = 0
        var right = events.size
        while (left < right) {
            val mid = (left + right) ushr 1
            if (events[mid][0] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
