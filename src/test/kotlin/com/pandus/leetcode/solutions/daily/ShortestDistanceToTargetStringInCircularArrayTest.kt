package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestDistanceToTargetStringInCircularArrayTest {
    private val solution = ShortestDistanceToTargetStringInCircularArray()

    @Test
    fun `test example 1 - multiple occurrences, shortest via circular left`() {
        val words = arrayOf("hello", "i", "am", "leetcode", "hello")
        assertEquals(1, solution.closestTarget(words, "hello", 1))
    }

    @Test
    fun `test example 2 - shorter path going left wraps around`() {
        val words = arrayOf("a", "b", "leetcode")
        assertEquals(1, solution.closestTarget(words, "leetcode", 0))
    }

    @Test
    fun `test example 3 - target not present returns -1`() {
        val words = arrayOf("i", "eat", "leetcode")
        assertEquals(-1, solution.closestTarget(words, "ate", 0))
    }

    @Test
    fun `test target at start index returns 0`() {
        val words = arrayOf("a", "b", "c")
        assertEquals(0, solution.closestTarget(words, "b", 1))
    }

    @Test
    fun `test single element array matching target`() {
        val words = arrayOf("hello")
        assertEquals(0, solution.closestTarget(words, "hello", 0))
    }

    @Test
    fun `test direct distance shorter than circular`() {
        val words = arrayOf("a", "b", "c", "d", "e")
        assertEquals(2, solution.closestTarget(words, "c", 0))
    }

    @Test
    fun `test circular distance shorter than direct`() {
        val words = arrayOf("a", "b", "c", "d", "e")
        assertEquals(2, solution.closestTarget(words, "d", 1))
    }

    @Test
    fun `test multiple occurrences picks minimum distance`() {
        val words = arrayOf("x", "y", "x", "z", "x")
        assertEquals(1, solution.closestTarget(words, "x", 1))
    }
}
