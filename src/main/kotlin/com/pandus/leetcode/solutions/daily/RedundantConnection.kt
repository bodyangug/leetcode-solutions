package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/redundant-connection
class RedundantConnection {
    fun findRedundantConnection(g: Array<IntArray>): IntArray {
        val u = IntArray(g.size + 1) { it }
        fun f(a: Int): Int = if (a == u[a]) a else f(u[a]).also { u[a] = it }
        return g.first { (a, b) -> f(a) == f(b).also { u[u[a]] = u[b] } }
    }
}
