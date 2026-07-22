package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeIITest {
    private val solution = MaximizeActiveSectionWithTradeII()

    @Test
    @DisplayName("Example 1: s=\"01\", single full-range query")
    fun testExample1() {
        val result = solution.maxActiveSectionsAfterTrade("01", arrayOf(intArrayOf(0, 1)))
        assertEquals(listOf(1), result)
    }

    @Test
    @DisplayName("Example 2: s=\"0100\", multiple queries")
    fun testExample2() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(0, 2), intArrayOf(1, 3))
        val result = solution.maxActiveSectionsAfterTrade("0100", queries)
        assertEquals(listOf(4, 3, 1), result)
    }

    @Test
    @DisplayName("Example 3: s=\"1000100\", ones outside the query range still count")
    fun testExample3() {
        val queries = arrayOf(intArrayOf(1, 5), intArrayOf(0, 6), intArrayOf(0, 4))
        val result = solution.maxActiveSectionsAfterTrade("1000100", queries)
        assertEquals(listOf(6, 7, 2), result)
    }

    @Test
    @DisplayName("No zeros: string of all ones has no beneficial trade")
    fun testAllOnes() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))
        val result = solution.maxActiveSectionsAfterTrade("1111", queries)
        assertEquals(listOf(4, 4), result)
    }

    @Test
    @DisplayName("No ones: string of all zeros yields zero active sections")
    fun testAllZeros() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))
        val result = solution.maxActiveSectionsAfterTrade("0000", queries)
        assertEquals(listOf(0, 0), result)
    }

    @Test
    @DisplayName("Single-character range allows no trade, keeping the whole-string active count")
    fun testSingleCharacterRange() {
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(2, 2))
        val result = solution.maxActiveSectionsAfterTrade("1010", queries)
        assertEquals(listOf(2, 2), result)
    }

    @Test
    @DisplayName("Boundary zero-runs are clipped to the query range")
    fun testBoundaryClipping() {
        // s = "00100": interior trade uses both zero runs fully within [0,4].
        val full = solution.maxActiveSectionsAfterTrade("00100", arrayOf(intArrayOf(0, 4)))
        assertEquals(listOf(5), full)
        // Query [1,3] = "010": only one zero on each side is available.
        val clipped = solution.maxActiveSectionsAfterTrade("00100", arrayOf(intArrayOf(1, 3)))
        assertEquals(listOf(3), clipped)
    }

    @Test
    @DisplayName("Interior trade picks the best of several one-runs")
    fun testInteriorBest() {
        // s = "10100100010": best gain comes from the widest surrounding zeros.
        val queries = arrayOf(intArrayOf(0, 10))
        val result = solution.maxActiveSectionsAfterTrade("10100100010", queries)
        assertEquals(listOf(9), result)
    }
}
