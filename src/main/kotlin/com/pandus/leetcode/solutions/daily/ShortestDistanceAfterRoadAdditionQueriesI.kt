package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i
class ShortestDistanceAfterRoadAdditionQueriesI {
    private fun findMinDistance(
        adjList: List<MutableList<Int>>,
        n: Int,
        currentNode: Int,
        dp: IntArray
    ): Int {
        if (currentNode == n - 1) return 0

        if (dp[currentNode] != -1) return dp[currentNode]

        var minDistance = n

        for (neighbor in adjList[currentNode]) {
            minDistance = min(
                minDistance,
                (findMinDistance(adjList, n, neighbor, dp) + 1)
            )
        }
        return minDistance.also { dp[currentNode] = it }
    }

    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val dp = IntArray(n)
        for (i in 0 until n) {
            dp[i] = -1
        }
        val adjList: MutableList<MutableList<Int>> = ArrayList(n)

        for (i in 0 until n) {
            adjList.add(ArrayList())
        }
        for (i in 0 until n - 1) {
            adjList[i].add(i + 1)
        }

        val answer: MutableList<Int> = ArrayList()

        for (road in queries) {
            val u = road[0]
            val v = road[1]

            adjList[u].add(v)

            answer.add(findMinDistance(adjList, n, 0, dp))

            for (i in 0 until n) {
                dp[i] = -1
            }
        }
        val result = IntArray(answer.size)
        for (i in answer.indices) {
            result[i] = answer[i]
        }
        return result
    }
}
