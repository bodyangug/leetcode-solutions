package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii
class NumberOfWaysToAssignEdgeWeightsII {
    fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007L
        val n = edges.size + 1
        val adj = Array(n + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val log = maxOf(1, 32 - Integer.numberOfLeadingZeros(n))
        val depth = IntArray(n + 1)
        val parent = Array(log) { IntArray(n + 1) }
        // BFS from root 1
        val queue = ArrayDeque<Int>()
        queue.add(1)
        val visited = BooleanArray(n + 1)
        visited[1] = true
        parent[0][1] = 0
        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            for (v in adj[u]) {
                if (!visited[v]) {
                    visited[v] = true
                    depth[v] = depth[u] + 1
                    parent[0][v] = u
                    queue.add(v)
                }
            }
        }
        for (k in 1 until log) {
            for (v in 1..n) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]]
            }
        }
        fun lca(a: Int, b: Int): Int {
            var x = a
            var y = b
            if (depth[x] < depth[y]) {
                val t = x
                x = y
                y = t
            }
            var diff = depth[x] - depth[y]
            var k = 0
            while (diff > 0) {
                if (diff and 1 == 1) x = parent[k][x]
                diff = diff shr 1
                k++
            }
            if (x == y) return x
            for (i in log - 1 downTo 0) {
                if (parent[i][x] != parent[i][y]) {
                    x = parent[i][x]
                    y = parent[i][y]
                }
            }
            return parent[0][x]
        }
        // Precompute powers of 2
        val pow2 = LongArray(n + 1)
        pow2[0] = 1L
        for (i in 1..n) pow2[i] = pow2[i - 1] * 2L % mod
        val ans = IntArray(queries.size)
        for (i in queries.indices) {
            val u = queries[i][0]
            val v = queries[i][1]
            if (u == v) {
                ans[i] = 0
                continue
            }
            val l = lca(u, v)
            val len = depth[u] + depth[v] - 2 * depth[l]
            ans[i] = if (len == 0) 0 else pow2[len - 1].toInt()
        }
        return ans
    }
}
