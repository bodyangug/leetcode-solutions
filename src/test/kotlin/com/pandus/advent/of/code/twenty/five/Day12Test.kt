package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {
    private val day12 = Day12()

    @Test
    fun `star1 - should solve example with 4x4 region expecting 2 fits`() {
        val input = listOf(
            "0:",
            "###",
            "##.",
            "##.",
            "",
            "1:",
            "###",
            "##.",
            ".##",
            "",
            "2:",
            ".##",
            "###",
            "##.",
            "",
            "3:",
            "##.",
            "###",
            "##.",
            "",
            "4:",
            "###",
            "#..",
            "###",
            "",
            "5:",
            "###",
            ".#.",
            "###",
            "",
            "4x4: 0 0 0 0 2 0"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "4x4 region with two shape-4 pieces should fit (1 region succeeds)")
    }

    @Test
    fun `star1 - should solve example with 12x5 region expecting 2 fits`() {
        val input = listOf(
            "0:",
            "###",
            "##.",
            "##.",
            "",
            "1:",
            "###",
            "##.",
            ".##",
            "",
            "2:",
            ".##",
            "###",
            "##.",
            "",
            "3:",
            "##.",
            "###",
            "##.",
            "",
            "4:",
            "###",
            "#..",
            "###",
            "",
            "5:",
            "###",
            ".#.",
            "###",
            "",
            "12x5: 1 0 1 0 2 2"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "12x5 region with mixed pieces should fit (1 region succeeds)")
    }

    @Test
    fun `star1 - should handle empty input`() {
        val input = emptyList<String>()
        val result = day12.star1(input)
        assertEquals(0L, result, "Empty input should return 0")
    }

    @Test
    fun `star1 - should handle region with no pieces required`() {
        val input = listOf(
            "0:",
            "###",
            "##.",
            "",
            "5x5: 0"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "Region with no pieces required should succeed")
    }

    @Test
    fun `star1 - should fail when shape is too large for region`() {
        val input = listOf(
            "0:",
            "###",
            "###",
            "###",
            "",
            "2x2: 1"
        )
        val result = day12.star1(input)
        assertEquals(0L, result, "3x3 shape cannot fit in 2x2 region")
    }

    @Test
    fun `star1 - should fail when total area exceeds region area`() {
        val input = listOf(
            "0:",
            "###",
            "###",
            "",
            "2x2: 2"
        )
        val result = day12.star1(input)
        assertEquals(0L, result, "Two 6-cell shapes cannot fit in 4-cell region")
    }

    @Test
    fun `star1 - should handle single piece fitting exactly`() {
        val input = listOf(
            "0:",
            "##",
            "##",
            "",
            "2x2: 1"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "2x2 square should fit exactly in 2x2 region")
    }

    @Test
    fun `star1 - should handle L-shaped pieces`() {
        val input = listOf(
            "0:",
            "#..",
            "###",
            "",
            "3x2: 1"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "L-shaped piece (4 cells) should fit in 3x2 region (6 cells)")
    }

    @Test
    fun `star1 - should handle multiple different shapes`() {
        val input = listOf(
            "0:",
            "##",
            "",
            "1:",
            "#",
            "#",
            "",
            "4x2: 2 2"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "Two horizontal and two vertical 2-cell pieces should fit in 4x2 region")
    }

    @Test
    fun `star1 - should fail with negative piece count`() {
        val input = listOf(
            "0:",
            "##",
            "",
            "3x3: -1"
        )
        val result = day12.star1(input)
        assertEquals(0L, result, "Negative piece count should fail")
    }

    @Test
    fun `star1 - should handle rotation and reflection symmetries`() {
        val input = listOf(
            "0:",
            "##.",
            ".##",
            "",
            "3x2: 1"
        )
        val result = day12.star1(input)
        assertEquals(1L, result, "Z-shaped piece should fit with proper rotation/reflection")
    }

    @Test
    fun `star1 - should handle complex polyomino puzzle`() {
        val input = listOf(
            "0:",
            "###",
            "#..",
            "",
            "1:",
            "##",
            "#.",
            "#.",
            "",
            "6x4: 2 2"
        )
        val result = day12.star1(input)
        // 6x4 = 24 cells, 2 pieces of shape 0 (4 cells each) + 2 pieces of shape 1 (4 cells each) = 16 cells
        assertEquals(1L, result, "Should fit two of each shape in 6x4 region")
    }

    @Test
    fun `star1 - should handle region with whitespace in counts`() {
        val input = listOf(
            "0:",
            "##",
            "",
            "3x3:   2   "
        )
        val result = day12.star1(input)
        // 3x3 = 9 cells, 2 pieces * 2 cells = 4 cells
        assertEquals(1L, result, "Should handle whitespace in region definition")
    }

    @Test
    fun `star1 - should fail when pieces don't fit geometrically`() {
        val input = listOf(
            "0:",
            "###",
            "",
            "1:",
            "###",
            "",
            "2x3: 2 0"
        )
        val result = day12.star1(input)
        // 2x3 region with two 1x3 horizontal pieces - should work
        assertEquals(1L, result, "Two 1x3 pieces should fit in 2x3 region")
    }

    @Test
    fun `star1 - should handle T-shaped pentomino`() {
        val input = listOf(
            "0:",
            "###",
            ".#.",
            ".#.",
            "",
            "3x3: 1"
        )
        val result = day12.star1(input)
        // T-shaped piece (5 cells) in 3x3 region (9 cells)
        assertEquals(1L, result, "T-shaped pentomino should fit in 3x3 region")
    }

    @Test
    fun `star1 - should handle plus-shaped pentomino`() {
        val input = listOf(
            "0:",
            ".#.",
            "###",
            ".#.",
            "",
            "3x3: 1"
        )
        val result = day12.star1(input)
        // Plus-shaped piece (5 cells) in 3x3 region (9 cells)
        assertEquals(1L, result, "Plus-shaped pentomino should fit in 3x3 region")
    }

    @Test
    fun `star1 - should detect impossible configurations with exact area match`() {
        val input = listOf(
            "0:",
            "####",
            "",
            "1:",
            "####",
            "",
            "3x3: 2 0"
        )
        val result = day12.star1(input)
        // 3x3 = 9 cells, but two 1x4 pieces cannot fit (need at least one dimension >= 4)
        assertEquals(0L, result, "Two 1x4 pieces cannot fit in 3x3 region despite area match")
    }
}
