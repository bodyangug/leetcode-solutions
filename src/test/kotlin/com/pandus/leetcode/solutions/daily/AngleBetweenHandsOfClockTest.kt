package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AngleBetweenHandsOfClockTest {
    private val solution = AngleBetweenHandsOfClock()
    private val delta = 1e-6

    @Test
    fun angleClock_example1_returns165() {
        assertEquals(165.0, solution.angleClock(12, 30), delta)
    }

    @Test
    fun angleClock_example2_returns75() {
        assertEquals(75.0, solution.angleClock(3, 30), delta)
    }

    @Test
    fun angleClock_example3_returns7Point5() {
        assertEquals(7.5, solution.angleClock(3, 15), delta)
    }

    @Test
    fun angleClock_midnight_returns0() {
        assertEquals(0.0, solution.angleClock(12, 0), delta)
    }

    @Test
    fun angleClock_noon_returns0() {
        // hour 12 maps to 0 internally; minute 0 -> both at 0
        assertEquals(0.0, solution.angleClock(12, 0), delta)
    }

    @Test
    fun angleClock_threeOClock_returns90() {
        assertEquals(90.0, solution.angleClock(3, 0), delta)
    }

    @Test
    fun angleClock_sixOClock_returns180() {
        assertEquals(180.0, solution.angleClock(6, 0), delta)
    }

    @Test
    fun angleClock_nineOClock_returns90() {
        // raw diff = 270, smaller = 90
        assertEquals(90.0, solution.angleClock(9, 0), delta)
    }

    @Test
    fun angleClock_oneFortyFive_returnsCorrectAngle() {
        // hour = 30 + 22.5 = 52.5; minute = 270; diff = 217.5; smaller = 142.5
        assertEquals(142.5, solution.angleClock(1, 45), delta)
    }

    @Test
    fun angleClock_elevenFiftyNine_returnsSmallAngle() {
        // hour = 330 + 29.5 = 359.5; minute = 354; diff = 5.5
        assertEquals(5.5, solution.angleClock(11, 59), delta)
    }

    @Test
    fun angleClock_fourTwenty_returnsZero() {
        // hour = 120 + 10 = 130; minute = 120; diff = 10
        assertEquals(10.0, solution.angleClock(4, 20), delta)
    }
}
