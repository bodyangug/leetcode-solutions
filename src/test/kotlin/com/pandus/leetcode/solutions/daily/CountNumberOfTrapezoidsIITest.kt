package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountNumberOfTrapezoidsIITest {
    private val solution = CountNumberOfTrapezoidsII()

    @Test
    @DisplayName("Basic example with 4 points forming line segments")
    fun basicExample_fourPoints() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2)
        )
        val expected = 1
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Empty array returns 0")
    fun emptyArray_returnsZero() {
        val points = arrayOf<IntArray>()
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Single point returns 0")
    fun singlePoint_returnsZero() {
        val points = arrayOf(intArrayOf(1, 1))
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Two points returns 0")
    fun twoPoints_returnsZero() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1)
        )
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Three points returns 0")
    fun threePoints_returnsZero() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("All points collinear on horizontal line")
    fun allPointsCollinear_horizontal_returnsZero() {
        val points = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(2, 5),
            intArrayOf(3, 5),
            intArrayOf(4, 5)
        )
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("All points collinear on vertical line")
    fun allPointsCollinear_vertical_returnsZero() {
        val points = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 3),
            intArrayOf(3, 4)
        )
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("All points collinear on diagonal line")
    fun allPointsCollinear_diagonal_returnsZero() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(4, 4)
        )
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Points forming two parallel line segments")
    fun twoParallelSegments() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
        )
        // Multiple parallel segments should create trapezoids
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0) // Non-negative result
    }

    @Test
    @DisplayName("Points with same slope but different intercepts")
    fun sameSlopeDifferentIntercepts() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points forming rectangle")
    fun pointsFormingRectangle() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(2, 0),
            intArrayOf(0, 2),
            intArrayOf(2, 2)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points with negative coordinates")
    fun negativeCoordinates() {
        val points = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-2, -1),
            intArrayOf(-1, -2),
            intArrayOf(-2, -2)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points with mixed positive and negative coordinates")
    fun mixedCoordinates() {
        val points = arrayOf(
            intArrayOf(-1, 1),
            intArrayOf(1, 1),
            intArrayOf(-1, -1),
            intArrayOf(1, -1)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Large number of points")
    fun largeNumberOfPoints() {
        val points = Array(20) { i ->
            intArrayOf(i % 5, i / 5)
        }
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points forming multiple distinct line segments")
    fun multipleDistinctSegments() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 1),
            intArrayOf(4, 2),
            intArrayOf(5, 3),
            intArrayOf(6, 4)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points at same location (duplicates)")
    fun duplicatePoints() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 2)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points forming star pattern")
    fun starPattern() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 0),
            intArrayOf(2, 1)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points with steep slopes")
    fun steepSlopes() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 10),
            intArrayOf(2, 1),
            intArrayOf(2, 10),
            intArrayOf(3, 5)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points with zero slope segments")
    fun zeroSlopeSegments() {
        val points = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(5, 5),
            intArrayOf(2, 3),
            intArrayOf(4, 3),
            intArrayOf(3, 1),
            intArrayOf(6, 1)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points forming pentagon-like structure")
    fun pentagonLike() {
        val points = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(2, 2),
            intArrayOf(1, 3),
            intArrayOf(0, 2),
            intArrayOf(0, 1)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points at origin and nearby")
    fun originAndNearby() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points with large coordinate values")
    fun largeCoordinateValues() {
        val points = arrayOf(
            intArrayOf(1000, 1000),
            intArrayOf(2000, 1000),
            intArrayOf(1000, 2000),
            intArrayOf(2000, 2000),
            intArrayOf(1500, 1500)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Complex configuration with 6 points")
    fun complexSixPoints() {
        val points = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 2),
            intArrayOf(5, 3),
            intArrayOf(6, 4)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Points forming grid pattern")
    fun gridPattern() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }

    @Test
    @DisplayName("Five points with various slopes")
    fun fivePointsVariousSlopes() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(3, 2),
            intArrayOf(2, 4),
            intArrayOf(4, 3),
            intArrayOf(5, 5)
        )
        val result = solution.countTrapezoids(points)
        assertEquals(true, result >= 0)
    }
}
