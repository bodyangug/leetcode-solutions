package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfArrayIsGoodTest {
    private val solution = CheckIfArrayIsGood()

    @Test
    fun `example 1 - not enough elements`() {
        assertEquals(false, solution.isGood(intArrayOf(2, 1, 3)))
    }

    @Test
    fun `example 2 - valid permutation of base 3`() {
        assertEquals(true, solution.isGood(intArrayOf(1, 3, 3, 2)))
    }

    @Test
    fun `example 3 - valid permutation of base 1`() {
        assertEquals(true, solution.isGood(intArrayOf(1, 1)))
    }

    @Test
    fun `example 4 - too many elements`() {
        assertEquals(false, solution.isGood(intArrayOf(3, 4, 4, 1, 2, 1)))
    }
}
