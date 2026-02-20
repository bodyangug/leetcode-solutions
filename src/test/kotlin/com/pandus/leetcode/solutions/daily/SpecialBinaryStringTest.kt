package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecialBinaryStringTest {
    private val solution = SpecialBinaryString()

    @Test
    fun `test example 1 - swap 10 and 1100`() {
        val input = "11011000"
        val expected = "11100100"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Should swap '10' and '1100' to get lexicographically largest")
    }

    @Test
    fun `test example 2 - already optimal`() {
        val input = "10"
        val expected = "10"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "10 is already the lexicographically largest")
    }

    @Test
    fun `test empty string`() {
        val input = ""
        val expected = ""
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Empty string should return empty string")
    }

    @Test
    fun `test simple nested special string`() {
        val input = "1100"
        val expected = "1100"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "1100 is already optimal")
    }

    @Test
    fun `test multiple special substrings at same level`() {
        val input = "10101010"
        val expected = "10101010"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Multiple 10s are already sorted")
    }

    @Test
    fun `test needs sorting`() {
        val input = "10110010"
        val expected = "11001010"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Should sort to get 1100 before 10 and 10")
    }

    @Test
    fun `test deeply nested structure`() {
        val input = "111000"
        val expected = "111000"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Deeply nested structure is already optimal")
    }

    @Test
    fun `test complex structure with multiple levels`() {
        val input = "11100100"
        val expected = "11100100"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Already in lexicographically largest form")
    }

    @Test
    fun `test all same at root level`() {
        val input = "11001100"
        val expected = "11001100"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Two identical 1100 substrings remain in same order")
    }

    @Test
    fun `test mixed complexity`() {
        val input = "101100"
        val expected = "110010"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Should move 1100 before 10")
    }

    @Test
    fun `test single pair`() {
        val input = "10"
        val expected = "10"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Single 10 is the only valid result")
    }

    @Test
    fun `test three consecutive simple strings`() {
        val input = "101010"
        val expected = "101010"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Three identical 10s remain in same order")
    }

    @Test
    fun `test larger nested structure`() {
        val input = "11110000"
        val expected = "11110000"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Nested structure 1111 0000 is already optimal")
    }

    @Test
    fun `test requires multiple swaps conceptually`() {
        val input = "10111000"
        val expected = "11100010"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Should move larger special substring first")
    }

    @Test
    fun `test symmetric structure`() {
        val input = "11100100"
        val expected = "11100100"
        val result = solution.makeLargestSpecial(input)
        assertEquals(expected, result, "Already in optimal form")
    }
}
