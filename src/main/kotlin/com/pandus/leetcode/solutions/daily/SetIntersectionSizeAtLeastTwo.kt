package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/set-intersection-size-at-least-two
class SetIntersectionSizeAtLeastTwo {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        // Sort by start ascending, then by end descending
        intervals.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })

        val todo = IntArray(intervals.size) { 2 }
        var ans = 0

        for (t in intervals.indices.reversed()) {
            val (start, _) = intervals[t]
            val needed = todo[t]

            repeat(needed) { offset ->
                val p = start + offset
                for (i in 0..t) {
                    if (todo[i] > 0 && p <= intervals[i][1]) {
                        todo[i]--
                    }
                }
                ans++
            }
        }
        return ans
    }
}
