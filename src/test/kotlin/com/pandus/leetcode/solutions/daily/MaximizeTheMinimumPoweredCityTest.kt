package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximizeTheMinimumPoweredCityTest {

    @Test
    @DisplayName("Basic test case with small array and limited budget")
    fun maxPower_basicCase() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(1, 2, 4, 5, 0)
        val r = 1
        val k = 2
        val result = solution.maxPower(stations, r, k)
        assertEquals(5L, result, "Should maximize minimum power to 5")
    }

    @Test
    @DisplayName("Test case with zero additional power stations")
    fun maxPower_zeroBudget() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(4, 4, 4, 4)
        val r = 0
        val k = 0
        val result = solution.maxPower(stations, r, k)
        assertEquals(4L, result, "Should return minimum station power when k=0")
    }

    @Test
    @DisplayName("Single station with zero budget")
    fun maxPower_singleStation() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(10)
        val r = 0
        val k = 0
        val result = solution.maxPower(stations, r, k)
        assertEquals(10L, result, "Should return the only station's power")
    }

    @Test
    @DisplayName("Single station with additional budget")
    fun maxPower_singleStationWithBudget() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(5)
        val r = 0
        val k = 10
        val result = solution.maxPower(stations, r, k)
        assertEquals(15L, result, "Should add all budget to single station")
    }

    @Test
    @DisplayName("All stations have equal power")
    fun maxPower_equalStations() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(3, 3, 3, 3)
        val r = 1
        val k = 6
        val result = solution.maxPower(stations, r, k)
        assertEquals(9L, result, "Should distribute budget evenly")
    }

    @Test
    @DisplayName("Test with range covering entire array")
    fun maxPower_fullRangeCoverage() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(2, 4, 6)
        val r = 10
        val k = 3
        val result = solution.maxPower(stations, r, k)
        assertEquals(15L, result, "Should distribute power when range covers all stations")
    }

    @Test
    @DisplayName("Test with two stations and overlapping range")
    fun maxPower_twoStationsOverlap() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(5, 3)
        val r = 1
        val k = 4
        val result = solution.maxPower(stations, r, k)
        assertEquals(12L, result, "Should maximize minimum with overlapping ranges")
    }

    @Test
    @DisplayName("Edge case with minimum values")
    fun maxPower_minimalInput() {
        val solution = MaximizeTheMinimumPoweredCity()
        val stations = intArrayOf(1)
        val r = 0
        val k = 1
        val result = solution.maxPower(stations, r, k)
        assertEquals(2L, result, "Should handle minimal input correctly")
    }
}
