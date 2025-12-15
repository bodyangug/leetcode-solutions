package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSmoothDescentPeriodsOfStockTest {
    private val solution = NumberOfSmoothDescentPeriodsOfStock()

    @Test
    fun `should return 7 for prices 3,2,1,4`() {
        val prices = intArrayOf(3, 2, 1, 4)
        assertEquals(7, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 4 for prices 8,6,7,7`() {
        val prices = intArrayOf(8, 6, 7, 7)
        assertEquals(4, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 1 for single price`() {
        val prices = intArrayOf(1)
        assertEquals(1, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 3 for two consecutive descending prices`() {
        val prices = intArrayOf(5, 4)
        assertEquals(3, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 2 for two non-consecutive prices`() {
        val prices = intArrayOf(5, 3)
        assertEquals(2, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 6 for three consecutive descending prices`() {
        val prices = intArrayOf(10, 9, 8)
        assertEquals(6, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 10 for four consecutive descending prices`() {
        val prices = intArrayOf(5, 4, 3, 2)
        assertEquals(10, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should return 15 for five consecutive descending prices`() {
        val prices = intArrayOf(6, 5, 4, 3, 2)
        assertEquals(15, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle prices with no descent periods longer than one`() {
        val prices = intArrayOf(1, 3, 5, 7)
        assertEquals(4, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle prices with same values`() {
        val prices = intArrayOf(5, 5, 5, 5)
        assertEquals(4, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle mixed descent and non-descent periods`() {
        val prices = intArrayOf(10, 9, 8, 10, 9)
        assertEquals(9, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle descent period followed by ascending prices`() {
        val prices = intArrayOf(5, 4, 3, 5, 7)
        assertEquals(8, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle multiple separate descent periods`() {
        val prices = intArrayOf(4, 3, 10, 9, 8)
        assertEquals(9, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle long consecutive descent period`() {
        val prices = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        assertEquals(55, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle descent with interruption and continuation`() {
        val prices = intArrayOf(7, 6, 5, 7, 6, 5, 4)
        assertEquals(16, solution.getDescentPeriods(prices))
    }

    @Test
    fun `should handle two element arrays with various patterns`() {
        val prices1 = intArrayOf(10, 9)
        assertEquals(3, solution.getDescentPeriods(prices1))

        val prices2 = intArrayOf(10, 10)
        assertEquals(2, solution.getDescentPeriods(prices2))

        val prices3 = intArrayOf(10, 11)
        assertEquals(2, solution.getDescentPeriods(prices3))
    }

    @Test
    fun `should handle large descent difference`() {
        val prices = intArrayOf(100, 50, 49, 48)
        assertEquals(7, solution.getDescentPeriods(prices))
    }
}
