package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPushesToTypeWordITest {
    private val solution = MinimumNumberOfPushesToTypeWordI()

    @Test
    fun `test example 1`() {
        assertEquals(5, solution.minimumPushes("abcde"))
    }

    @Test
    fun `test example 2`() {
        assertEquals(12, solution.minimumPushes("xycdefghij"))
    }

    @Test
    fun `test single character`() {
        assertEquals(1, solution.minimumPushes("a"))
    }

    @Test
    fun `test repeated single character`() {
        assertEquals(4, solution.minimumPushes("aaaa"))
    }

    @Test
    fun `test eight distinct characters all single push`() {
        assertEquals(8, solution.minimumPushes("abcdefgh"))
    }

    @Test
    fun `test nine distinct characters spills to second push`() {
        assertEquals(10, solution.minimumPushes("abcdefghi"))
    }

    @Test
    fun `test all 26 letters`() {
        assertEquals(56, solution.minimumPushes("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun `test frequency ordering assigns cheapest keys to most frequent`() {
        assertEquals(6, solution.minimumPushes("aaabbc"))
    }
}
