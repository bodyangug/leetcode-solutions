package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet
class FindBuildingWhereAliceAndBobCanMeet {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val r = IntArray(queries.size)
        val q = ArrayList<Int>()
        var j = heights.lastIndex
        for (i in queries.indices.sortedBy { -queries[it].max() }) {
            val (a, b) = (queries[i].min() to queries[i].max())
            if (a == b || heights[a] < heights[b]) {
                r[i] = b
                continue
            }
            while (j > b) {
                while (q.size > 0 && heights[q.last()] < heights[j]) q.removeLast()
                q += j--
            }
            var lo = 0
            var hi = q.lastIndex
            r[i] = -1
            while (lo <= hi) {
                val m = lo + (hi - lo) / 2
                if (heights[q[m]] > heights[a]) {
                    r[i] = q[m]
                    lo = m + 1
                } else hi = m - 1
            }
        }
        return r
    }
}
