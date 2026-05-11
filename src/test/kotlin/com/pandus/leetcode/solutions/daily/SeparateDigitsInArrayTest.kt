package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SeparateDigitsInArrayTest {

    private val solution = SeparateDigitsInArray()

    @Test
    fun `multi-digit numbers are separated`() {
        assertArrayEquals(intArrayOf(1, 3, 2, 5, 8, 3, 7, 7), solution.separateDigits(intArrayOf(13, 25, 83, 77)))
    }

    @Test
    fun `single-digit numbers remain unchanged`() {
        assertArrayEquals(intArrayOf(7, 1, 3, 9), solution.separateDigits(intArrayOf(7, 1, 3, 9)))
    }

    @Test
    fun `single element array`() {
        assertArrayEquals(intArrayOf(1, 0, 0), solution.separateDigits(intArrayOf(100)))
    }

    @Test
    fun `mixed single and multi-digit numbers`() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.separateDigits(intArrayOf(1, 23)))
    }
}
