package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RemoveCoveredIntervalsTest {
    private val solution = RemoveCoveredIntervals()

    @Test
    @DisplayName("Example 1: [[1,4],[3,6],[2,8]] - should return 2")
    fun testExample1() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(2, result, "[3,6] is covered by [2,8], so it is removed")
    }

    @Test
    @DisplayName("Example 2: [[1,4],[2,3]] - should return 1")
    fun testExample2() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "[2,3] is covered by [1,4], so it is removed")
    }

    @Test
    @DisplayName("Single interval: [[1,10]] - should return 1")
    fun testSingleInterval() {
        val intervals = arrayOf(intArrayOf(1, 10))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "A single interval cannot be covered")
    }

    @Test
    @DisplayName("No overlap: [[1,2],[3,4],[5,6]] - should return 3")
    fun testNoOverlap() {
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(3, result, "Disjoint intervals cover none of each other")
    }

    @Test
    @DisplayName("All covered by one: [[1,10],[2,3],[4,5],[6,7]] - should return 1")
    fun testAllCoveredByOne() {
        val intervals = arrayOf(intArrayOf(1, 10), intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(6, 7))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "All smaller intervals are covered by [1,10]")
    }

    @Test
    @DisplayName("Same start, different ends: [[1,4],[1,6],[1,3]] - should return 1")
    fun testSameStart() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(1, 6), intArrayOf(1, 3))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "[1,6] covers both [1,4] and [1,3]")
    }

    @Test
    @DisplayName("Identical intervals: [[2,5],[2,5]] - should return 1")
    fun testIdenticalIntervals() {
        val intervals = arrayOf(intArrayOf(2, 5), intArrayOf(2, 5))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "Duplicate interval is considered covered")
    }

    @Test
    @DisplayName("Same end, different starts: [[1,8],[3,8],[5,8]] - should return 1")
    fun testSameEnd() {
        val intervals = arrayOf(intArrayOf(1, 8), intArrayOf(3, 8), intArrayOf(5, 8))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(1, result, "[1,8] covers [3,8] and [5,8]")
    }

    @Test
    @DisplayName("Partial overlaps, none covered: [[1,4],[2,6],[5,8]] - should return 3")
    fun testPartialOverlapsNoneCovered() {
        val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(2, 6), intArrayOf(5, 8))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(3, result, "Overlapping but no interval fully contains another")
    }

    @Test
    @DisplayName("Unsorted input: [[3,10],[4,10],[5,11]] - should return 2")
    fun testUnsortedInput() {
        val intervals = arrayOf(intArrayOf(3, 10), intArrayOf(4, 10), intArrayOf(5, 11))
        val result = solution.removeCoveredIntervals(intervals)
        assertEquals(2, result, "[4,10] is covered by [3,10]; [5,11] remains")
    }
}
