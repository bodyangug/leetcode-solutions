package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-score-after-removals-on-a-tree
class MinimumScoreAfterRemovalsOnTree {
    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
        val n = nums.size
        val graph = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        val subtreeXor = IntArray(n)
        val inTime = IntArray(n)
        val outTime = IntArray(n)
        var time = 0

        fun dfs(node: Int, parent: Int): Int {
            inTime[node] = time++
            var xorSum = nums[node]
            for (neighbor in graph[node]) {
                if (neighbor != parent) {
                    xorSum = xorSum xor dfs(neighbor, node)
                }
            }
            subtreeXor[node] = xorSum
            outTime[node] = time++
            return xorSum
        }

        dfs(0, -1)
        val totalXor = subtreeXor[0]
        var minScore = Int.MAX_VALUE

        for (i in 1 until n) {
            for (j in i + 1 until n) {
                val a: Int
                val b: Int
                val c: Int

                fun isAncestor(u: Int, v: Int): Boolean =
                    inTime[u] <= inTime[v] && outTime[v] <= outTime[u]

                if (isAncestor(i, j)) {
                    a = subtreeXor[j]
                    b = subtreeXor[i] xor subtreeXor[j]
                    c = totalXor xor subtreeXor[i]
                } else if (isAncestor(j, i)) {
                    a = subtreeXor[i]
                    b = subtreeXor[j] xor subtreeXor[i]
                    c = totalXor xor subtreeXor[j]
                } else {
                    a = subtreeXor[i]
                    b = subtreeXor[j]
                    c = totalXor xor a xor b
                }

                minScore = minOf(minScore, maxOf(a, b, c) - minOf(a, b, c))
            }
        }
        return minScore
    }
}
