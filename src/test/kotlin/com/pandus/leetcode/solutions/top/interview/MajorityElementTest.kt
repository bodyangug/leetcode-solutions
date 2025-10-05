package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {

    private val solution = MajorityElement()

    @Test
    fun testExample1() {
        val nums = intArrayOf(3, 2, 3)
        assertEquals(3, solution.majorityElement(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        assertEquals(2, solution.majorityElement(nums))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        assertEquals(1, solution.majorityElement(nums))
    }

    @Test
    fun testAllSameElements() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        assertEquals(5, solution.majorityElement(nums))
    }

    @Test
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -1, -1, 2, 2)
        assertEquals(-1, solution.majorityElement(nums))
    }

    @Test
    fun testLargerArray() {
        val nums = intArrayOf(1, 1, 1, 1, 2, 2, 3)
        assertEquals(1, solution.majorityElement(nums))
    }
}
