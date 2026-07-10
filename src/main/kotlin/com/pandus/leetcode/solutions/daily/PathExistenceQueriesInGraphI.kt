package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/path-existence-queries-in-a-graph-i
class PathExistenceQueriesInGraphI {
    fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
        val component = IntArray(n)
        for (i in 1 until n) {
            component[i] = component[i - 1] + if (nums[i] - nums[i - 1] > maxDiff) 1 else 0
        }
        val answer = BooleanArray(queries.size)
        for (i in queries.indices) {
            val u = queries[i][0]
            val v = queries[i][1]
            answer[i] = component[u] == component[v]
        }
        return answer
    }
}
