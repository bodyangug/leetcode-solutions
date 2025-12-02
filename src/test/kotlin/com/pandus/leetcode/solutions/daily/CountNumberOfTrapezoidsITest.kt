package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountNumberOfTrapezoidsITest {
    private val solution = CountNumberOfTrapezoidsI()

    @Test
    @DisplayName("Basic example with 4 points forming 1 trapezoid")
    fun basicExample_fourPoints_returnsOne() {
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
    @DisplayName("All points on same y-coordinate returns 0")
    fun allPointsSameY_returnsZero() {
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
    @DisplayName("Points with two different y-coordinates forming trapezoids")
    fun twoDifferentYCoordinates_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 2),
            intArrayOf(5, 2)
        )
        // Points at y=1: 3 points -> C(3,2) = 3 edges
        // Points at y=2: 2 points -> C(2,2) = 1 edge
        // Result: 3 * 1 = 3
        val expected = 3
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Points with three different y-coordinates")
    fun threeDifferentYCoordinates_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 2),
            intArrayOf(5, 3),
            intArrayOf(6, 3)
        )
        // Points at y=1: 2 points -> C(2,2) = 1 edge
        // Points at y=2: 2 points -> C(2,2) = 1 edge
        // Points at y=3: 2 points -> C(2,2) = 1 edge
        // Calculation: 1 * 0 + 1 * 1 + 1 * (1+1) = 0 + 1 + 2 = 3
        val expected = 3
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Larger example with multiple y-coordinates")
    fun largerExample_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 2),
            intArrayOf(5, 2),
            intArrayOf(6, 2),
            intArrayOf(7, 3)
        )
        // Points at y=1: 3 points -> C(3,2) = 3 edges
        // Points at y=2: 3 points -> C(3,2) = 3 edges
        // Points at y=3: 1 point -> C(1,2) = 0 edges
        // Calculation: 3 * 0 + 3 * 3 + 0 * (3+3) = 0 + 9 + 0 = 9
        val expected = 9
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Multiple points at each y-coordinate")
    fun multiplePointsPerY_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 10),
            intArrayOf(3, 10),
            intArrayOf(4, 10),
            intArrayOf(5, 20),
            intArrayOf(6, 20),
            intArrayOf(7, 20)
        )
        // Points at y=10: 4 points -> C(4,2) = 6 edges
        // Points at y=20: 3 points -> C(3,2) = 3 edges
        // Calculation: 6 * 0 + 3 * 6 = 0 + 18 = 18
        val expected = 18
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Points forming maximum combinations")
    fun maximumCombinations_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 1),
            intArrayOf(5, 1),
            intArrayOf(6, 2),
            intArrayOf(7, 2),
            intArrayOf(8, 2),
            intArrayOf(9, 2),
            intArrayOf(10, 2)
        )
        // Points at y=1: 5 points -> C(5,2) = 10 edges
        // Points at y=2: 5 points -> C(5,2) = 10 edges
        // Calculation: 10 * 0 + 10 * 10 = 0 + 100 = 100
        val expected = 100
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Points with single point at one y-coordinate")
    fun singlePointAtOneY_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 2),
            intArrayOf(4, 2)
        )
        // Points at y=1: 1 point -> C(1,2) = 0 edges
        // Points at y=2: 3 points -> C(3,2) = 3 edges
        // Calculation: 0 * 0 + 3 * 0 = 0
        val expected = 0
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Complex example with four different y-coordinates")
    fun fourDifferentYCoordinates_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 2),
            intArrayOf(5, 2),
            intArrayOf(6, 3),
            intArrayOf(7, 3),
            intArrayOf(8, 4),
            intArrayOf(9, 4)
        )
        // Points at y=1: 2 points -> C(2,2) = 1 edge
        // Points at y=2: 3 points -> C(3,2) = 3 edges
        // Points at y=3: 2 points -> C(2,2) = 1 edge
        // Points at y=4: 2 points -> C(2,2) = 1 edge
        // Calculation: 1*0 + 3*1 + 1*(1+3) + 1*(1+3+1) = 0 + 3 + 4 + 5 = 12
        val expected = 12
        assertEquals(expected, solution.countTrapezoids(points))
    }

    @Test
    @DisplayName("Duplicate points at same coordinates")
    fun duplicatePoints_returnsTrapezoids() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 2)
        )
        // Points at y=1: 2 points -> C(2,2) = 1 edge
        // Points at y=2: 2 points -> C(2,2) = 1 edge
        // Calculation: 1 * 0 + 1 * 1 = 1
        val expected = 1
        assertEquals(expected, solution.countTrapezoids(points))
    }
}
