package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day5Test {
    private val day5 = Day5()

    // ==================== star1 tests ====================

    @Test
    fun `star1 - should return 3 fresh ingredients for example input`() {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32"
        )
        val result = day5.star1(input)
        assertEquals(3, result, "Should find 3 fresh ingredients (5, 11, 17)")
    }

    @Test
    fun `star1 - should handle single range with all fresh ingredients`() {
        val input = listOf(
            "1-10",
            "",
            "1",
            "5",
            "10"
        )
        val result = day5.star1(input)
        assertEquals(3, result, "All 3 ingredients should be fresh")
    }

    @Test
    fun `star1 - should handle single range with all spoiled ingredients`() {
        val input = listOf(
            "10-20",
            "",
            "1",
            "5",
            "25"
        )
        val result = day5.star1(input)
        assertEquals(0, result, "All ingredients should be spoiled")
    }

    @Test
    fun `star1 - should handle overlapping ranges correctly`() {
        val input = listOf(
            "5-10",
            "8-15",
            "",
            "3",
            "7",
            "9",
            "12",
            "20"
        )
        val result = day5.star1(input)
        assertEquals(3, result, "Should find 3 fresh ingredients (7, 9, 12)")
    }

    @Test
    fun `star1 - should handle edge case with ingredient at range boundaries`() {
        val input = listOf(
            "5-10",
            "",
            "5",
            "10",
            "4",
            "11"
        )
        val result = day5.star1(input)
        assertEquals(2, result, "Should find 2 fresh ingredients at boundaries (5, 10)")
    }

    @Test
    fun `star1 - should handle empty ingredient list`() {
        val input = listOf(
            "5-10",
            ""
        )
        val result = day5.star1(input)
        assertEquals(0, result, "Should return 0 for empty ingredient list")
    }

    @Test
    fun `star1 - should handle multiple non-overlapping ranges`() {
        val input = listOf(
            "1-3",
            "10-12",
            "20-22",
            "",
            "2",
            "5",
            "11",
            "15",
            "21",
            "25"
        )
        val result = day5.star1(input)
        assertEquals(3, result, "Should find 3 fresh ingredients (2, 11, 21)")
    }

    @Test
    fun `star1 - should handle large numbers`() {
        val input = listOf(
            "1000000-1000005",
            "",
            "999999",
            "1000003",
            "1000006"
        )
        val result = day5.star1(input)
        assertEquals(1, result, "Should find 1 fresh ingredient (1000003)")
    }

    // ==================== star2 tests ====================

    @Test
    fun `star2 - should return 14 total fresh ingredients for example input`() {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18"
        )
        val result = day5.star2(input)
        assertEquals(14, result, "Should count 14 total fresh ingredient IDs")
    }

    @Test
    fun `star2 - should handle single range correctly`() {
        val input = listOf(
            "1-10"
        )
        val result = day5.star2(input)
        assertEquals(10, result, "Should count 10 ingredients (1-10)")
    }

    @Test
    fun `star2 - should merge overlapping ranges`() {
        val input = listOf(
            "1-5",
            "3-8"
        )
        val result = day5.star2(input)
        assertEquals(8, result, "Should merge to 1-8, counting 8 ingredients")
    }

    @Test
    fun `star2 - should merge adjacent ranges`() {
        val input = listOf(
            "1-5",
            "6-10"
        )
        val result = day5.star2(input)
        assertEquals(10, result, "Should merge adjacent ranges 1-5 and 6-10")
    }

    @Test
    fun `star2 - should handle non-overlapping ranges`() {
        val input = listOf(
            "1-3",
            "10-12",
            "20-22"
        )
        val result = day5.star2(input)
        assertEquals(9, result, "Should count 3 + 3 + 3 = 9 ingredients")
    }

    @Test
    fun `star2 - should handle completely overlapping ranges`() {
        val input = listOf(
            "1-10",
            "3-7"
        )
        val result = day5.star2(input)
        assertEquals(10, result, "Smaller range is inside larger, should count 10")
    }

    @Test
    fun `star2 - should handle multiple overlapping ranges`() {
        val input = listOf(
            "1-5",
            "3-8",
            "7-12"
        )
        val result = day5.star2(input)
        assertEquals(12, result, "Should merge to 1-12, counting 12 ingredients")
    }

    @Test
    fun `star2 - should handle ranges in random order`() {
        val input = listOf(
            "20-25",
            "1-5",
            "10-15"
        )
        val result = day5.star2(input)
        assertEquals(17, result, "Should sort and count all ranges: 5 + 6 + 6 = 17")
    }

    @Test
    fun `star2 - should handle large ranges efficiently`() {
        val input = listOf(
            "1-1000000",
            "500000-1500000"
        )
        val result = day5.star2(input)
        assertEquals(1500000, result, "Should merge to 1-1500000 efficiently")
    }

    @Test
    fun `star2 - should handle ranges with gaps`() {
        val input = listOf(
            "1-3",
            "5-7",
            "9-11"
        )
        val result = day5.star2(input)
        assertEquals(9, result, "Should count separate ranges: 3 + 3 + 3 = 9")
    }

    @Test
    fun `star2 - should handle single ingredient range`() {
        val input = listOf(
            "5-5"
        )
        val result = day5.star2(input)
        assertEquals(1, result, "Single ingredient range should count as 1")
    }

    @Test
    fun `star2 - should handle complex merging scenario`() {
        val input = listOf(
            "1-3",
            "2-5",
            "4-8",
            "10-12",
            "11-15"
        )
        val result = day5.star2(input)
        assertEquals(14, result, "Should merge to 1-8 (8) and 10-15 (6), total 14")
    }

    // ==================== Integration tests ====================

    @Test
    fun `star1 - should handle actual input from day5 txt file if exists`() {
        val file = File("/Users/bo/Documents/my-projects/leetcode-solutions/day5.txt")
        if (file.exists()) {
            val input = file.readLines()
            val result = day5.star1(input)
            println("Star 1 result for actual input: $result")
            // This will verify the solution works with the actual input
        }
    }

    @Test
    fun `star2 - should handle actual input from day5 txt file if exists`() {
        val file = File("/Users/bo/Documents/my-projects/leetcode-solutions/day5.txt")
        if (file.exists()) {
            val input = file.readLines()
            val result = day5.star2(input)
            println("Star 2 result for actual input: $result")
            // This will verify the solution works with the actual input
        }
    }

    // ==================== Edge cases ====================

    @Test
    fun `star1 - should handle ingredient with value 0`() {
        val input = listOf(
            "0-10",
            "",
            "0",
            "5"
        )
        val result = day5.star1(input)
        assertEquals(2, result, "Should handle 0 as valid ingredient ID")
    }

    @Test
    fun `star2 - should handle range starting at 0`() {
        val input = listOf(
            "0-5"
        )
        val result = day5.star2(input)
        assertEquals(6, result, "Should count 6 ingredients (0-5)")
    }

    @Test
    fun `star1 - should handle duplicate ingredient IDs`() {
        val input = listOf(
            "5-10",
            "",
            "7",
            "7",
            "7"
        )
        val result = day5.star1(input)
        assertEquals(3, result, "Should count each occurrence separately")
    }

    @Test
    fun `star2 - should handle duplicate ranges`() {
        val input = listOf(
            "5-10",
            "5-10"
        )
        val result = day5.star2(input)
        assertEquals(6, result, "Duplicate ranges should merge to single count")
    }
}
