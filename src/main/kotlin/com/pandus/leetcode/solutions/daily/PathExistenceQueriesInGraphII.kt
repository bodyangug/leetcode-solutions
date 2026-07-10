package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/path-existence-queries-in-a-graph-ii
class PathExistenceQueriesInGraphII {
    fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): IntArray {
        // Sort node indices by their value.
        val order = (0 until n).sortedBy { nums[it] }.toIntArray()
        val pos = IntArray(n) // original index -> position in sorted order
        val sortedVals = IntArray(n)
        for (p in 0 until n) {
            pos[order[p]] = p
            sortedVals[p] = nums[order[p]]
        }

        // right[p] = farthest sorted position reachable from p in a single hop
        // (largest q with sortedVals[q] - sortedVals[p] <= maxDiff).
        val right = IntArray(n)
        var j = 0
        for (p in 0 until n) {
            if (j < p) j = p
            while (j + 1 < n && sortedVals[j + 1] - sortedVals[p] <= maxDiff) j++
            right[p] = j
        }

        // Binary lifting: up[k][p] = farthest position reachable in 2^k hops.
        var log = 1
        while ((1 shl log) < n) log++
        val up = Array(log + 1) { IntArray(n) }
        up[0] = right
        for (k in 1..log) {
            for (p in 0 until n) {
                up[k][p] = up[k - 1][up[k - 1][p]]
            }
        }

        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            var a = pos[queries[i][0]]
            var b = pos[queries[i][1]]
            if (a > b) {
                val t = a
                a = b
                b = t
            }
            if (a == b) {
                answer[i] = 0
                continue
            }
            // Greedily jump from a as far as possible without passing b.
            var cur = a
            var steps = 0
            for (k in log downTo 0) {
                if (up[k][cur] < b) {
                    cur = up[k][cur]
                    steps += 1 shl k
                }
            }
            answer[i] = if (right[cur] >= b) steps + 1 else -1
        }
        return answer
    }
}
