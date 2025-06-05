package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/lexicographically-smallest-equivalent-string
class LexicographicallySmallestEquivalentString {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val parent = IntArray(26) { it }

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX == rootY) return
            if (rootX < rootY) parent[rootY] = rootX else parent[rootX] = rootY
        }

        for (i in s1.indices) {
            union(s1[i] - 'a', s2[i] - 'a')
        }

        return baseStr.map { ch ->
            ('a' + find(ch - 'a'))
        }.joinToString("")
    }
}
