package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeAreaOfSquareHoleInGridTest {
    private val solution = MaximizeAreaOfSquareHoleInGrid()

    @Test
    fun `example 1 - consecutive bars on both axes`() {
        val n = 2
        val m = 1
        val hBars = intArrayOf(2, 3)
        val vBars = intArrayOf(2)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        assertEquals(4, result)
    }

    @Test
    fun `example 2 - single bar on both axes`() {
        val n = 1
        val m = 1
        val hBars = intArrayOf(2)
        val vBars = intArrayOf(2)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        assertEquals(4, result)
    }

    @Test
    fun `example 3 - non-consecutive bars`() {
        val n = 2
        val m = 3
        val hBars = intArrayOf(2, 3)
        val vBars = intArrayOf(2, 4)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        assertEquals(4, result)
    }

    @Test
    fun `single horizontal bar and single vertical bar`() {
        val n = 1
        val m = 1
        val hBars = intArrayOf(1)
        val vBars = intArrayOf(1)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        assertEquals(4, result)
    }

    @Test
    fun `multiple consecutive horizontal bars with single vertical bar`() {
        val n = 5
        val m = 1
        val hBars = intArrayOf(2, 3, 4, 5)
        val vBars = intArrayOf(2)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 4, max consecutive vertical: 1
        // Min(4, 1) + 1 = 2, area = 2*2 = 4
        assertEquals(4, result)
    }

    @Test
    fun `single horizontal bar with multiple consecutive vertical bars`() {
        val n = 1
        val m = 5
        val hBars = intArrayOf(2)
        val vBars = intArrayOf(2, 3, 4, 5)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 1, max consecutive vertical: 4
        // Min(1, 4) + 1 = 2, area = 2*2 = 4
        assertEquals(4, result)
    }

    @Test
    fun `equal consecutive bars on both axes`() {
        val n = 3
        val m = 3
        val hBars = intArrayOf(2, 3, 4)
        val vBars = intArrayOf(2, 3, 4)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 3, max consecutive vertical: 3
        // Min(3, 3) + 1 = 4, area = 4*4 = 16
        assertEquals(16, result)
    }

    @Test
    fun `unordered bars should be sorted`() {
        val n = 3
        val m = 3
        val hBars = intArrayOf(4, 2, 3)
        val vBars = intArrayOf(3, 4, 2)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // After sorting: hBars = [2, 3, 4], vBars = [2, 3, 4]
        // Max consecutive horizontal: 3, max consecutive vertical: 3
        // Min(3, 3) + 1 = 4, area = 4*4 = 16
        assertEquals(16, result)
    }

    @Test
    fun `gaps in sequences`() {
        val n = 5
        val m = 5
        val hBars = intArrayOf(2, 3, 5, 6)
        val vBars = intArrayOf(2, 4, 5, 6)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // hBars: [2, 3] and [5, 6] -> max consecutive = 2
        // vBars: [2], [4, 5, 6] -> max consecutive = 3
        // Min(2, 3) + 1 = 3, area = 3*3 = 9
        assertEquals(9, result)
    }

    @Test
    fun `large consecutive horizontal sequence`() {
        val n = 10
        val m = 2
        val hBars = intArrayOf(2, 3, 4, 5, 6, 7, 8)
        val vBars = intArrayOf(2, 3)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 7, max consecutive vertical: 2
        // Min(7, 2) + 1 = 3, area = 3*3 = 9
        assertEquals(9, result)
    }

    @Test
    fun `large consecutive vertical sequence`() {
        val n = 2
        val m = 10
        val hBars = intArrayOf(2, 3)
        val vBars = intArrayOf(2, 3, 4, 5, 6, 7, 8)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 2, max consecutive vertical: 7
        // Min(2, 7) + 1 = 3, area = 3*3 = 9
        assertEquals(9, result)
    }

    @Test
    fun `no consecutive bars on horizontal axis`() {
        val n = 5
        val m = 3
        val hBars = intArrayOf(2, 4, 6)
        val vBars = intArrayOf(2, 3, 4)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 1, max consecutive vertical: 3
        // Min(1, 3) + 1 = 2, area = 2*2 = 4
        assertEquals(4, result)
    }

    @Test
    fun `no consecutive bars on vertical axis`() {
        val n = 3
        val m = 5
        val hBars = intArrayOf(2, 3, 4)
        val vBars = intArrayOf(2, 4, 6)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 3, max consecutive vertical: 1
        // Min(3, 1) + 1 = 2, area = 2*2 = 4
        assertEquals(4, result)
    }

    @Test
    fun `maximum possible square`() {
        val n = 5
        val m = 5
        val hBars = intArrayOf(2, 3, 4, 5, 6)
        val vBars = intArrayOf(2, 3, 4, 5, 6)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 5, max consecutive vertical: 5
        // Min(5, 5) + 1 = 6, area = 6*6 = 36
        assertEquals(36, result)
    }

    @Test
    fun `multiple gaps creating smaller sequences`() {
        val n = 8
        val m = 8
        val hBars = intArrayOf(2, 4, 6, 7, 8)
        val vBars = intArrayOf(3, 5, 6, 8)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // hBars: [2], [4], [6, 7, 8] -> max consecutive = 3
        // vBars: [3], [5, 6], [8] -> max consecutive = 2
        // Min(3, 2) + 1 = 3, area = 3*3 = 9
        assertEquals(9, result)
    }

    @Test
    fun `alternating bars with no consecutive pairs`() {
        val n = 6
        val m = 6
        val hBars = intArrayOf(2, 4, 6, 8)
        val vBars = intArrayOf(2, 4, 6, 8)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 1, max consecutive vertical: 1
        // Min(1, 1) + 1 = 2, area = 2*2 = 4
        assertEquals(4, result)
    }

    @Test
    fun `rectangular grid with different dimensions`() {
        val n = 10
        val m = 3
        val hBars = intArrayOf(2, 3, 4, 5)
        val vBars = intArrayOf(2, 3)

        val result = solution.maximizeSquareHoleArea(n, m, hBars, vBars)

        // Max consecutive horizontal: 4, max consecutive vertical: 2
        // Min(4, 2) + 1 = 3, area = 3*3 = 9
        assertEquals(9, result)
    }
}
