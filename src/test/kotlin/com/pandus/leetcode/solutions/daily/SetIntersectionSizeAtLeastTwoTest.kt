package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SetIntersectionSizeAtLeastTwoTest {

    private val solution = SetIntersectionSizeAtLeastTwo()

    @Test
    @DisplayName("Basic case with overlapping intervals")
    fun testBasicCase() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 5)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(3, result, "Should return 3 elements in the set")
    }

    @Test
    @DisplayName("Case with non-overlapping intervals")
    fun testNonOverlappingIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(4, 5)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(5, result, "Should return 5 elements in the set")
    }

    @Test
    @DisplayName("Single interval")
    fun testSingleInterval() {
        val intervals = arrayOf(intArrayOf(1, 5))
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(2, result, "Should return 2 elements for single interval")
    }

    @Test
    @DisplayName("Two identical intervals")
    fun testIdenticalIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(1, 5)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(2, result, "Should return 2 elements for identical intervals")
    }

    @Test
    @DisplayName("Intervals with same start, different ends")
    fun testSameStartDifferentEnds() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(1, 5)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(2, result, "Should return 2 elements when intervals share same start")
    }

    @Test
    @DisplayName("Nested intervals")
    fun testNestedIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 9),
            intArrayOf(3, 8),
            intArrayOf(4, 7)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(2, result, "Should return 2 elements for nested intervals")
    }

    @Test
    @DisplayName("Consecutive small intervals")
    fun testConsecutiveSmallIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(5, result, "Should return 5 elements for consecutive intervals")
    }

    @Test
    @DisplayName("Intervals with partial overlap")
    fun testPartialOverlap() {
        val intervals = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(4, 8),
            intArrayOf(7, 10)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(4, result, "Should return 4 elements for partially overlapping intervals")
    }

    @Test
    @DisplayName("Large interval containing smaller ones")
    fun testLargeIntervalContainingSmaller() {
        val intervals = arrayOf(
            intArrayOf(1, 100),
            intArrayOf(2, 3),
            intArrayOf(5, 6)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(4, result, "Should return 4 elements when large interval contains smaller ones")
    }

    @Test
    @DisplayName("All intervals share a common range")
    fun testCommonRange() {
        val intervals = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 10),
            intArrayOf(3, 10),
            intArrayOf(4, 10)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(2, result, "Should return 2 elements when all intervals share common range")
    }

    @Test
    @DisplayName("Minimum size intervals (length 2)")
    fun testMinimumSizeIntervals() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(6, result, "Should return 6 elements for separate minimum intervals")
    }

    @Test
    @DisplayName("Complex case with mixed overlaps")
    fun testComplexMixedOverlaps() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 7),
            intArrayOf(5, 7),
            intArrayOf(7, 8)
        )
        val result = solution.intersectionSizeTwo(intervals)
        assertEquals(5, result, "Should return 5 elements for complex overlaps")
    }
}
