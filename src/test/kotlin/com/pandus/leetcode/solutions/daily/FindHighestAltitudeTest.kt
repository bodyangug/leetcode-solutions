package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindHighestAltitudeTest {

    private val solution = FindHighestAltitude()

    @Test
    @DisplayName("Example 1: [-5, 1, 5, 0, -7] -> 1")
    fun testExample1() {
        val gain = intArrayOf(-5, 1, 5, 0, -7)
        assertEquals(1, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Example 2: [-4, -3, -2, -1, 4, 3, 2] -> 0 (all altitudes non-positive)")
    fun testExample2() {
        val gain = intArrayOf(-4, -3, -2, -1, 4, 3, 2)
        assertEquals(0, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Single positive gain")
    fun testSinglePositiveGain() {
        val gain = intArrayOf(5)
        assertEquals(5, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Single negative gain returns 0 (starting altitude)")
    fun testSingleNegativeGain() {
        val gain = intArrayOf(-3)
        assertEquals(0, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("All zero gains")
    fun testAllZeroGains() {
        val gain = intArrayOf(0, 0, 0, 0)
        assertEquals(0, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("All positive gains - peak at the end")
    fun testAllPositiveGains() {
        val gain = intArrayOf(1, 2, 3, 4)
        assertEquals(10, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("All negative gains - never goes above 0")
    fun testAllNegativeGains() {
        val gain = intArrayOf(-1, -2, -3, -4)
        assertEquals(0, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Peak in the middle")
    fun testPeakInMiddle() {
        val gain = intArrayOf(2, 3, -5, 1, -2)
        // altitudes: [0, 2, 5, 0, 1, -1] -> max = 5
        assertEquals(5, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Empty gain array returns starting altitude 0")
    fun testEmptyGain() {
        val gain = intArrayOf()
        assertEquals(0, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Goes negative then climbs back to a new peak")
    fun testDipThenPeak() {
        val gain = intArrayOf(-2, -1, 5, 3)
        // altitudes: [0, -2, -3, 2, 5] -> max = 5
        assertEquals(5, solution.largestAltitude(gain))
    }

    @Test
    @DisplayName("Climbs to peak then descends")
    fun testClimbThenDescend() {
        val gain = intArrayOf(3, 4, -2, -10)
        // altitudes: [0, 3, 7, 5, -5] -> max = 7
        assertEquals(7, solution.largestAltitude(gain))
    }
}
