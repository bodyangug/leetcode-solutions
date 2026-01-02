package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NRepeatedElementInSize2NArrayTest {
    private val solver = NRepeatedElementInSize2NArray()

    @Test
    @DisplayName("Example 1: [1,2,3,3] -> 3")
    fun repeatedNTimes_example1() {
        val nums = intArrayOf(1, 2, 3, 3)
        val expected = 3
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Example 2: [2,1,2,5,3,2] -> 2")
    fun repeatedNTimes_example2() {
        val nums = intArrayOf(2, 1, 2, 5, 3, 2)
        val expected = 2
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Example 3: [5,1,5,2,5,3,5,4] -> 5")
    fun repeatedNTimes_example3() {
        val nums = intArrayOf(5, 1, 5, 2, 5, 3, 5, 4)
        val expected = 5
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Edge case: Minimum size array [1,1] -> 1")
    fun repeatedNTimes_minimumSize() {
        val nums = intArrayOf(1, 1)
        val expected = 1
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Repeated element at the beginning: [7,7,3,4] -> 7")
    fun repeatedNTimes_atBeginning() {
        val nums = intArrayOf(7, 7, 3, 4)
        val expected = 7
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Repeated element at the end: [1,2,9,9] -> 9")
    fun repeatedNTimes_atEnd() {
        val nums = intArrayOf(1, 2, 9, 9)
        val expected = 9
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Repeated element scattered: [4,1,4,2,4,3] -> 4")
    fun repeatedNTimes_scattered() {
        val nums = intArrayOf(4, 1, 4, 2, 4, 3)
        val expected = 4
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Large array with repeated element: [10,20,10,30,10,40] -> 10")
    fun repeatedNTimes_largerArray() {
        val nums = intArrayOf(10, 20, 10, 30, 10, 40)
        val expected = 10
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Consecutive repeated elements: [8,8,5,6] -> 8")
    fun repeatedNTimes_consecutive() {
        val nums = intArrayOf(8, 8, 5, 6)
        val expected = 8
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Negative numbers: [-1,2,-1,3] -> -1")
    fun repeatedNTimes_negativeNumbers() {
        val nums = intArrayOf(-1, 2, -1, 3)
        val expected = -1
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Zero as repeated element: [0,0,1,2] -> 0")
    fun repeatedNTimes_withZero() {
        val nums = intArrayOf(0, 0, 1, 2)
        val expected = 0
        assertEquals(expected, solver.repeatedNTimes(nums))
    }

    @Test
    @DisplayName("Array size 4 with element appearing exactly twice: [6,7,6,8] -> 6")
    fun repeatedNTimes_size() {
        val nums = intArrayOf(6, 7, 6, 8)
        val expected = 6
        assertEquals(expected, solver.repeatedNTimes(nums))
    }
}
