package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindGreatestCommonDivisorOfArrayTest {
    private val solution = FindGreatestCommonDivisorOfArray()

    @Test
    fun `test example 1`() {
        assertEquals(2, solution.findGCD(intArrayOf(2, 5, 6, 9, 10)))
    }

    @Test
    fun `test example 2`() {
        assertEquals(1, solution.findGCD(intArrayOf(7, 5, 6, 8, 3)))
    }

    @Test
    fun `test example 3`() {
        assertEquals(3, solution.findGCD(intArrayOf(3, 3)))
    }

    @Test
    fun `test single element`() {
        assertEquals(6, solution.findGCD(intArrayOf(6)))
    }

    @Test
    fun `test min divides max`() {
        assertEquals(4, solution.findGCD(intArrayOf(4, 8, 12, 16)))
    }

    @Test
    fun `test all ones`() {
        assertEquals(1, solution.findGCD(intArrayOf(1, 1, 1)))
    }

    @Test
    fun `test unsorted input`() {
        assertEquals(5, solution.findGCD(intArrayOf(25, 10, 5, 20)))
    }
}
