package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/path-with-maximum-probability
class PathWithMaximumProbability {
    fun maxProbability(
        n: Int,
        edges: Array<IntArray>,
        succProb: DoubleArray,
        start_node: Int,
        end_node: Int
    ): Double {
        val maxProb = DoubleArray(n)
        maxProb[start_node] = 1.0

        for (i in 0 until n - 1) {
            var hasUpdate = false
            for (j in edges.indices) {
                val u = edges[j][0]
                val v = edges[j][1]
                val pathProb = succProb[j]
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb
                    hasUpdate = true
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb
                    hasUpdate = true
                }
            }
            if (!hasUpdate) {
                break
            }
        }

        return maxProb[end_node]
    }
}