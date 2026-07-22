package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-active-section-with-trade-ii
class MaximizeActiveSectionWithTradeII {
    fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
        val totalOnes = s.count { it == '1' }

        val starts = mutableListOf<Int>()
        val ends = mutableListOf<Int>()
        var i = 0
        while (i < s.length) {
            if (s[i] == '0') {
                var j = i
                while (j < s.length && s[j] == '0') j++
                starts.add(i)
                ends.add(j - 1)
                i = j
            } else {
                i++
            }
        }

        val runCount = starts.size
        fun runLength(k: Int) = ends[k] - starts[k] + 1

        // Trading the one-run between adjacent zero-runs k and k+1 gains their combined length.
        val pairSum = IntArray(maxOf(runCount - 1, 0)) { runLength(it) + runLength(it + 1) }
        val sparse = SparseTable(pairSum)

        return queries.map { (l, r) ->
            val a = firstRunEndingAtOrAfter(ends, l)
            val b = lastRunStartingAtOrBefore(starts, r)
            var gain = 0
            if (a < runCount && a < b) {
                val clippedA = ends[a] - maxOf(starts[a], l) + 1
                val clippedB = minOf(ends[b], r) - starts[b] + 1
                gain = if (b == a + 1) {
                    clippedA + clippedB
                } else {
                    var best = maxOf(clippedA + runLength(a + 1), runLength(b - 1) + clippedB)
                    if (a + 1 <= b - 2) best = maxOf(best, sparse.max(a + 1, b - 2))
                    best
                }
            }
            totalOnes + gain
        }
    }

    private fun firstRunEndingAtOrAfter(ends: List<Int>, l: Int): Int {
        var lo = 0
        var hi = ends.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (ends[mid] >= l) hi = mid else lo = mid + 1
        }
        return lo
    }

    private fun lastRunStartingAtOrBefore(starts: List<Int>, r: Int): Int {
        var lo = 0
        var hi = starts.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (starts[mid] <= r) lo = mid + 1 else hi = mid
        }
        return lo - 1
    }

    private class SparseTable(values: IntArray) {
        private val log = IntArray(values.size + 1)
        private val table: Array<IntArray>

        init {
            for (i in 2..values.size) log[i] = log[i / 2] + 1
            val levels = if (values.isEmpty()) 1 else log[values.size] + 1
            table = Array(levels) { IntArray(values.size) }
            if (values.isNotEmpty()) values.copyInto(table[0])
            for (j in 1 until table.size) {
                for (i in 0..values.size - (1 shl j)) {
                    table[j][i] = maxOf(table[j - 1][i], table[j - 1][i + (1 shl (j - 1))])
                }
            }
        }

        fun max(l: Int, r: Int): Int {
            val j = log[r - l + 1]
            return maxOf(table[j][l], table[j][r - (1 shl j) + 1])
        }
    }
}
