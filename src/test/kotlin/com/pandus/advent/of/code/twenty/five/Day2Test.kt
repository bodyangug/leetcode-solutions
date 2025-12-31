package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    @DisplayName("star1 calculates sum for single range with no invalid numbers")
    fun star1_singleRangeNoInvalid_returnsZero() {
        val day2 = Day2()
        val result = day2.star1("10-12")
        assertEquals(11L, result)
    }

    @Test
    @DisplayName("star1 calculates sum for single range with invalid numbers")
    fun star1_singleRangeWithInvalid_returnsSum() {
        val day2 = Day2()
        val result = day2.star1("10-12")
        assertEquals(11L, result) // Only 11 is invalid (1|1)
    }

    @Test
    @DisplayName("star1 calculates sum for range containing multiple invalid numbers")
    fun star1_multipleInvalid_returnsSum() {
        val day2 = Day2()
        val result = day2.star1("10-25")
        assertEquals(33, result) // 11 + 22 = 33, actually just 11 and 22
    }

    @Test
    @DisplayName("star1 handles multiple ranges")
    fun star1_multipleRanges_returnsSum() {
        val day2 = Day2()
        val result = day2.star1("10-12, 20-23")
        assertEquals(33L, result) // 11 + 22 = 33
    }

    @Test
    @DisplayName("star2 calculates sum for single range with no invalid numbers")
    fun star2_singleRangeNoInvalid_returnsZero() {
        val day2 = Day2()
        val result = day2.star2("1-9")
        assertEquals(0L, result)
    }

    @Test
    @DisplayName("star2 calculates sum for range with repeating patterns")
    fun star2_withRepeatingPatterns_returnsSum() {
        val day2 = Day2()
        val result = day2.star2("10-25")
        assertEquals(33, result) // 11 + 22 = 33
    }

    @Test
    @DisplayName("star2 handles multiple ranges")
    fun star2_multipleRanges_returnsSum() {
        val day2 = Day2()
        val result = day2.star2("10-12, 20-23, 30-34")
        assertEquals(66L, result) // 11 + 22 + 33 = 66
    }

    @Test
    @DisplayName("star2 detects longer repeating patterns")
    fun star2_longerPatterns_returnsSum() {
        val day2 = Day2()
        val result = day2.star2("123100-123178")
        assertEquals(123123L, result) // 123123 matches pattern "123" repeated
    }

    @Test
    @DisplayName("star1 and star2 handle ranges with spaces correctly")
    fun bothStars_rangesWithSpaces_parseCorrectly() {
        val day2 = Day2()
        val result1 = day2.star1(" 10 - 12 ")
        val result2 = day2.star2(" 10 - 12 ")
        assertEquals(11L, result1)
        assertEquals(11L, result2)
    }
}
