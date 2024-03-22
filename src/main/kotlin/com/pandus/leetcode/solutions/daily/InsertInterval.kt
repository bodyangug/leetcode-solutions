package com.pandus.leetcode.solutions.daily

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.ArrayList


//Reference: https://leetcode.com/problems/insert-interval
class InsertInterval {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val n = intervals.size
        var i = 0
        val res: MutableList<IntArray> = ArrayList()

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i])
            i++
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i++
        }
        res.add(newInterval)

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i])
            i++
        }

        // Convert List to array
        return Array(res.size) { res[it] }
    }
}
