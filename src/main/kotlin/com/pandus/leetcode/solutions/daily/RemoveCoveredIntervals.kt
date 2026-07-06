package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/remove-covered-intervals
class RemoveCoveredIntervals {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({ it[0] }, { -it[1] }))

        var count = 0
        var end = 0

        for (interval in intervals) {
            // If the current interval's end is greater than the previous end, it's not covered
            if (interval[1] > end) {
                count++
                end = interval[1]
            }
        }
        return count
    }
}
