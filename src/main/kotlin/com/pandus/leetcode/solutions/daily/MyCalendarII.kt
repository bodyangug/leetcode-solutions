package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/my-calendar-ii
class MyCalendarII {
    private class Interval(private val start: Int, private val end: Int) {
        infix fun hasIntersectionWith(other: Interval) =
            start in with(other) { start..<end } || other.start in start..<end

        infix fun intersectWith(other: Interval): Interval? =
            if (hasIntersectionWith(other)) Interval(max(start, other.start), min(end, other.end)) else null
    }

    private val intervals = mutableListOf<Interval>()
    private val intersections = mutableListOf<Interval>()

    fun book(start: Int, end: Int): Boolean {
        val target = Interval(start, end)
        if (intersections.any { it hasIntersectionWith target }) return false
        intersections.addAll(intervals.mapNotNull { it intersectWith target })
        intervals += target
        return true
    }
}
