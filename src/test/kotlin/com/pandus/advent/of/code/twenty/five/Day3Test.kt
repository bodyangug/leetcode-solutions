package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
    private val day3 = Day3()

    // ========== star1 Tests (2-digit maximum joltage) ==========

    @Test
    fun `star1 - should find maximum 2-digit joltage from simple ascending sequence`() {
        val input = listOf("12345")
        val result = day3.star1(input)
        assertEquals(45, result, "Maximum pair from '12345' should be 45 (4 and 5)")
    }

    @Test
    fun `star1 - should find maximum 2-digit joltage from descending sequence`() {
        val input = listOf("54321")
        val result = day3.star1(input)
        assertEquals(54, result, "Maximum pair from '54321' should be 54 (5 and 4)")
    }

    @Test
    fun `star1 - should handle single bank with repeated digits`() {
        val input = listOf("987654321111111")
        val result = day3.star1(input)
        assertEquals(98, result, "Maximum pair from '987654321111111' should be 98 (9 and 8)")
    }

    @Test
    fun `star1 - should handle bank starting with 8`() {
        val input = listOf("811111111111119")
        val result = day3.star1(input)
        assertEquals(89, result, "Maximum pair from '811111111111119' should be 89 (8 and 9)")
    }

    @Test
    fun `star1 - should handle two-digit bank`() {
        val input = listOf("90")
        val result = day3.star1(input)
        assertEquals(90, result, "Two-digit bank '90' should give 90")
    }

    @Test
    fun `star1 - should handle bank with all same digits`() {
        val input = listOf("5555")
        val result = day3.star1(input)
        assertEquals(55, result, "All same digits should give 55")
    }

    @Test
    fun `star1 - should handle empty list`() {
        val input = emptyList<String>()
        val result = day3.star1(input)
        assertEquals(0, result, "Empty input should return 0")
    }

    // ========== star2 Tests (12-digit maximum joltage) ==========

    @Test
    fun `star2 - should select 12 largest digits maintaining order from 15-digit bank`() {
        val input = listOf("987654321111111")
        val result = day3.star2(input)
        assertEquals(987654321111L, result, "Should select first 12 digits greedily: 987654321111")
    }

    @Test
    fun `star2 - should greedily select 12 digits for optimal result`() {
        val input = listOf("811111111111119")
        val result = day3.star2(input)
        assertEquals(811111111119L, result, "Should select digits to maximize: 811111111119")
    }

    @Test
    fun `star2 - should handle bank with exactly 12 digits`() {
        val input = listOf("123456789012")
        val result = day3.star2(input)
        assertEquals(123456789012L, result, "12-digit bank should select all digits")
    }

    @Test
    fun `star2 - should handle all nines`() {
        val input = listOf("9999999999999")
        val result = day3.star2(input)
        assertEquals(999999999999L, result, "12 nines from 13 nines")
    }

    @Test
    fun `star2 - should handle empty list`() {
        val input = emptyList<String>()
        val result = day3.star2(input)
        assertEquals(0L, result, "Empty input should return 0")
    }
}
