package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups
class DivideIntervalsIntoMinimumNumberOfGroups {
    fun minGroups(intervals: Array<IntArray>): Int {
        val events = mutableListOf<Pair<Int, Int>>()
        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]
            events.add(Pair(start, 0))
            events.add(Pair(end, 1))
        }
        events.sortWith(compareBy({ it.first }, { it.second }))

        var currentOverlap = 0
        var maxOverlap = 0

        for ((time, type) in events) {
            if (type == 0) {
                currentOverlap++
                maxOverlap = maxOf(maxOverlap, currentOverlap)
            } else {
                currentOverlap--
            }
        }
        return maxOverlap
    }
}
