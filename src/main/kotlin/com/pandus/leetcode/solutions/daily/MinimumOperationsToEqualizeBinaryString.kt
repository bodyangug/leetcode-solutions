package com.pandus.leetcode.solutions.daily

import java.util.TreeSet

// Reference: https://leetcode.com/problems/minimum-operations-to-equalize-binary-string
class MinimumOperationsToEqualizeBinaryString {
    fun minOperations(s: String, k: Int): Int {
        val n = s.length
        var m = s.count { c -> c == '0' }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val nodeSets = listOf(TreeSet<Int>(), TreeSet<Int>())

        for (i in 0..n) {
            nodeSets[i % 2].add(i)
        }

        val queue = ArrayDeque<Int>()
        queue.addLast(m)
        dist[m] = 0
        nodeSets[m % 2].remove(m)

        while (queue.isNotEmpty()) {
            m = queue.removeFirst()
            val c1 = maxOf(k - n + m, 0)
            val c2 = minOf(m, k)
            val lnode = m + k - 2 * c2
            val rnode = m + k - 2 * c1
            val nodeSet = nodeSets[lnode % 2]

            var m2 = nodeSet.ceiling(lnode)
            while (m2 != null && m2 <= rnode) {
                dist[m2] = dist[m] + 1
                queue.addLast(m2)
                nodeSet.remove(m2)
                m2 = nodeSet.ceiling(lnode)
            }
        }
        return if (dist[0] == Int.MAX_VALUE) -1 else dist[0]
    }
}
