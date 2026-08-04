package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindMissingElementsTest {
    private val solver = FindMissingElements()

    @Test
    @DisplayName("Example 1: [1,4,2,5] -> [3]")
    fun findMissingElements_example1() {
        val nums = intArrayOf(1, 4, 2, 5)
        assertEquals(listOf(3), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Example 2: [7,8,6,9] -> []")
    fun findMissingElements_example2() {
        val nums = intArrayOf(7, 8, 6, 9)
        assertEquals(emptyList<Int>(), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Example 3: [5,1] -> [2,3,4]")
    fun findMissingElements_example3() {
        val nums = intArrayOf(5, 1)
        assertEquals(listOf(2, 3, 4), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Edge case: empty array -> []")
    fun findMissingElements_emptyArray() {
        val nums = intArrayOf()
        assertEquals(emptyList<Int>(), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Single element -> []")
    fun findMissingElements_singleElement() {
        val nums = intArrayOf(42)
        assertEquals(emptyList<Int>(), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Two consecutive elements -> []")
    fun findMissingElements_twoConsecutive() {
        val nums = intArrayOf(3, 4)
        assertEquals(emptyList<Int>(), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Result is sorted regardless of input order")
    fun findMissingElements_sortedResult() {
        val nums = intArrayOf(10, 6)
        assertEquals(listOf(7, 8, 9), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Negative range [-3,1] -> [-2,-1,0]")
    fun findMissingElements_negativeRange() {
        val nums = intArrayOf(-3, 1)
        assertEquals(listOf(-2, -1, 0), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Range spanning negative to positive with some present")
    fun findMissingElements_negativeToPositive() {
        val nums = intArrayOf(-2, 0, 2)
        assertEquals(listOf(-1, 1), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Multiple missing gaps [1,3,7] -> [2,4,5,6]")
    fun findMissingElements_multipleGaps() {
        val nums = intArrayOf(1, 3, 7)
        assertEquals(listOf(2, 4, 5, 6), solver.findMissingElements(nums))
    }

    @Test
    @DisplayName("Full range present [4,5,6,7,8] -> []")
    fun findMissingElements_fullRangePresent() {
        val nums = intArrayOf(4, 5, 6, 7, 8)
        assertEquals(emptyList<Int>(), solver.findMissingElements(nums))
    }
}
