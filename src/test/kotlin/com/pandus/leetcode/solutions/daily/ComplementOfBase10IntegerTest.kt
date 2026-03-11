package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComplementOfBase10IntegerTest {
    private val solution = ComplementOfBase10Integer()

    @Test
    fun `should return 2 as complement of 5`() {
        val result = solution.bitwiseComplement(5)
        assertEquals(2, result)
    }

    @Test
    fun `should return 0 as complement of 7`() {
        val result = solution.bitwiseComplement(7)
        assertEquals(0, result)
    }

    @Test
    fun `should return 5 as complement of 10`() {
        val result = solution.bitwiseComplement(10)
        assertEquals(5, result)
    }

    @Test
    fun `should return 1 as complement of 0`() {
        val result = solution.bitwiseComplement(0)
        assertEquals(1, result)
    }

    @Test
    fun `should return 0 as complement of 1`() {
        val result = solution.bitwiseComplement(1)
        assertEquals(0, result)
    }
}
