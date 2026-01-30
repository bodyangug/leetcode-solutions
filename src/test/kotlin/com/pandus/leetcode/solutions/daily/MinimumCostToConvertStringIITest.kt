package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConvertStringIITest {
    private val solution = MinimumCostToConvertStringII()

    @Test
    fun `example 1 - single character transformations with chaining`() {
        val source = "abcd"
        val target = "acbe"
        val original = arrayOf("a", "b", "c", "c", "e", "d")
        val changed = arrayOf("b", "c", "b", "e", "b", "e")
        val cost = intArrayOf(2, 5, 5, 1, 2, 20)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(28L, result)
    }

    @Test
    fun `example 2 - multi-character substring transformations`() {
        val source = "abcdefgh"
        val target = "acdeeghh"
        val original = arrayOf("bcd", "fgh", "thh")
        val changed = arrayOf("cde", "thh", "ghh")
        val cost = intArrayOf(1, 3, 5)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(9L, result)
    }

    @Test
    fun `example 3 - impossible transformation returns -1`() {
        val source = "abcdefgh"
        val target = "addddddd"
        val original = arrayOf("bcd", "defgh")
        val changed = arrayOf("ddd", "ddddd")
        val cost = intArrayOf(100, 1578)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(-1L, result)
    }

    @Test
    fun `identical source and target returns zero cost`() {
        val source = "abc"
        val target = "abc"
        val original = arrayOf("a", "b")
        val changed = arrayOf("b", "c")
        val cost = intArrayOf(1, 2)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(0L, result)
    }

    @Test
    fun `single character conversion`() {
        val source = "a"
        val target = "b"
        val original = arrayOf("a")
        val changed = arrayOf("b")
        val cost = intArrayOf(5)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(5L, result)
    }

    @Test
    fun `choose cheaper path through intermediate transformation`() {
        val source = "ab"
        val target = "cd"
        val original = arrayOf("a", "b", "a", "x")
        val changed = arrayOf("c", "d", "x", "c")
        val cost = intArrayOf(10, 10, 1, 1)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(12L, result)
    }

    @Test
    fun `no transformation needed for matching characters`() {
        val source = "aaa"
        val target = "aba"
        val original = arrayOf("a")
        val changed = arrayOf("b")
        val cost = intArrayOf(3)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(3L, result)
    }

    @Test
    fun `multiple ways to transform - choose minimum`() {
        val source = "ab"
        val target = "cb"
        val original = arrayOf("a", "a")
        val changed = arrayOf("c", "c")
        val cost = intArrayOf(5, 3)

        val result = solution.minimumCost(source, target, original, changed, cost)

        assertEquals(3L, result)
    }
}
