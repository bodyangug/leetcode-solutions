package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoElementsInArrayTest {
    private val solution = MaximumProductOfTwoElementsInArray()

    @Test
    fun maxProduct_example1_returns12() {
        assertEquals(12, solution.maxProduct(intArrayOf(3, 4, 5, 2)))
    }

    @Test
    fun maxProduct_example2_returns16() {
        assertEquals(16, solution.maxProduct(intArrayOf(1, 5, 4, 5)))
    }

    @Test
    fun maxProduct_example3_returns12() {
        assertEquals(12, solution.maxProduct(intArrayOf(3, 7)))
    }

    @Test
    fun maxProduct_twoOnes_returns0() {
        assertEquals(0, solution.maxProduct(intArrayOf(1, 1)))
    }

    @Test
    fun maxProduct_largestAtEnd_returnsCorrect() {
        assertEquals(12, solution.maxProduct(intArrayOf(1, 2, 4, 5)))
    }

    @Test
    fun maxProduct_largestAtStart_returnsCorrect() {
        assertEquals(12, solution.maxProduct(intArrayOf(5, 4, 2, 1)))
    }

    @Test
    fun maxProduct_duplicateMaxValues_returnsCorrect() {
        assertEquals(81, solution.maxProduct(intArrayOf(10, 10, 3, 2)))
    }

    @Test
    fun maxProduct_allEqualValues_returnsCorrect() {
        assertEquals(16, solution.maxProduct(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun maxProduct_ascendingOrder_returnsProductOfTwoLargest() {
        assertEquals(72, solution.maxProduct(intArrayOf(1, 2, 3, 9, 10)))
    }

    @Test
    fun maxProduct_descendingOrder_returnsProductOfTwoLargest() {
        assertEquals(72, solution.maxProduct(intArrayOf(10, 9, 3, 2, 1)))
    }
}
