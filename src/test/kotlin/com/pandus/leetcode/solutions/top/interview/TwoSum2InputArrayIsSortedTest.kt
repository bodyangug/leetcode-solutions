package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSum2InputArrayIsSortedTest {

    private val solution = TwoSum2InputArrayIsSorted()

    @Test
    fun testExample1() {
        val numbers = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSum(numbers, target)
        assertArrayEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun testExample2() {
        val numbers = intArrayOf(2, 3, 4)
        val target = 6
        val result = solution.twoSum(numbers, target)
        assertArrayEquals(intArrayOf(1, 3), result)
    }

    @Test
    fun testExample3() {
        val numbers = intArrayOf(-1, 0)
        val target = -1
        val result = solution.twoSum(numbers, target)
        assertArrayEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun testLargeArray() {
        val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 15
        val result = solution.twoSum(numbers, target)
        assertArrayEquals(intArrayOf(5, 10), result) // 5 + 10 = 15
    }
}
