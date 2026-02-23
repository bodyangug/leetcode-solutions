package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfStringContainsAllBinaryCodesOfSizeKTest {
    private val solution = CheckIfStringContainsAllBinaryCodesOfSizeK()

    @Test
    fun `test example 1 - all binary codes of size 2 exist`() {
        val s = "00110110"
        val k = 2
        val expected = true
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test example 2 - all binary codes of size 1 exist`() {
        val s = "0110"
        val k = 1
        val expected = true
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test example 3 - missing binary code 00`() {
        val s = "0110"
        val k = 2
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test minimum case - k equals 1 with both codes`() {
        val s = "01"
        val k = 1
        val expected = true
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test minimum case - k equals 1 missing one code`() {
        val s = "0000"
        val k = 1
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test k equals 3 - missing some codes`() {
        val s = "0011"
        val k = 3
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test string too short for required codes`() {
        val s = "01"
        val k = 3
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test long string with all codes of size 4`() {
        val s = "0000111100001111000011110000111100001111"
        val k = 4
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test all zeros string`() {
        val s = "0000000"
        val k = 2
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test all ones string`() {
        val s = "1111111"
        val k = 2
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test alternating pattern`() {
        val s = "01010101"
        val k = 2
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test complex pattern with k equals 2`() {
        val s = "00110"
        val k = 2
        val expected = true
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test edge case - exact length for all codes of k equals 2`() {
        val s = "00011011"
        val k = 2
        val expected = true
        assertEquals(expected, solution.hasAllCodes(s, k))
    }

    @Test
    fun `test larger k value - k equals 5`() {
        val s = "00000000001111111111"
        val k = 5
        val expected = false
        assertEquals(expected, solution.hasAllCodes(s, k))
    }
}
