package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    @DisplayName("Star1: Example from problem statement returns 13 accessible rolls")
    fun star1_exampleInput_returns13() {
        val day4 = Day4()
        val input = listOf(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
        )
        val result = day4.star1(input)
        assertEquals(13, result)
    }

    @Test
    @DisplayName("Star1: Empty grid returns 0")
    fun star1_emptyGrid_returns0() {
        val day4 = Day4()
        val input = listOf(
            "....",
            "....",
            "...."
        )
        val result = day4.star1(input)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Star1: Single isolated roll is accessible")
    fun star1_singleRoll_returns1() {
        val day4 = Day4()
        val input = listOf(
            "...",
            ".@.",
            "..."
        )
        val result = day4.star1(input)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Star1: Roll with exactly 3 adjacent rolls is accessible")
    fun star1_rollWithThreeAdjacent_returns1() {
        val day4 = Day4()
        val input = listOf(
            ".@.",
            "@@@",
            "..."
        )
        val result = day4.star1(input)
        assertEquals(4, result) // All 4 rolls have < 4 adjacent
    }

    @Test
    @DisplayName("Star1: Corner rolls with limited neighbors")
    fun star1_cornerRolls_countedCorrectly() {
        val day4 = Day4()
        val input = listOf(
            "@..",
            "...",
            "..@"
        )
        val result = day4.star1(input)
        assertEquals(2, result) // Both corners accessible
    }

    @Test
    @DisplayName("Star1: Horizontal line of rolls")
    fun star1_horizontalLine_allAccessible() {
        val day4 = Day4()
        val input = listOf(
            ".....",
            "@@@@@",
            "....."
        )
        val result = day4.star1(input)
        assertEquals(5, result) // All have ≤2 adjacent
    }

    @Test
    @DisplayName("Star2: Example from problem statement returns 43 total removed")
    fun star2_exampleInput_returns43() {
        val day4 = Day4()
        val input = listOf(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
        )
        val result = day4.star2(input)
        assertEquals(43, result)
    }

    @Test
    @DisplayName("Star2: Empty grid returns 0")
    fun star2_emptyGrid_returns0() {
        val day4 = Day4()
        val input = listOf(
            "....",
            "....",
            "...."
        )
        val result = day4.star2(input)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Star2: Single isolated roll removed in one iteration")
    fun star2_singleRoll_returns1() {
        val day4 = Day4()
        val input = listOf(
            "...",
            ".@.",
            "..."
        )
        val result = day4.star2(input)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Star2: Sparse grid removes all rolls immediately")
    fun star2_sparseGrid_removesAllImmediately() {
        val day4 = Day4()
        val input = listOf(
            "@.@.@",
            ".....",
            "@.@.@"
        )
        val result = day4.star2(input)
        assertEquals(6, result)
    }

    @Test
    @DisplayName("Star2: L-shaped pattern progressive removal")
    fun star2_lShapedPattern_progressiveRemoval() {
        val day4 = Day4()
        val input = listOf(
            "@....",
            "@....",
            "@....",
            "@@@@@"
        )
        val result = day4.star2(input)
        assertEquals(8, result) // All rolls accessible over iterations
    }

    @Test
    @DisplayName("Star2: Protected core remains after perimeter removal")
    fun star2_protectedCore_remainsAfterPerimeter() {
        val day4 = Day4()
        val input = listOf(
            ".@@@.",
            "@@.@@",
            "@...@",
            "@@.@@",
            ".@@@."
        )
        val result = day4.star2(input)
        // Perimeter accessible, inner protected initially but may cascade
        assertEquals(16, result)
    }

    @Test
    @DisplayName("Star2: Single row removes all rolls")
    fun star2_singleRow_removesAll() {
        val day4 = Day4()
        val input = listOf("@@@@@")
        val result = day4.star2(input)
        assertEquals(5, result)
    }

    @Test
    @DisplayName("Star2: Single column removes all rolls")
    fun star2_singleColumn_removesAll() {
        val day4 = Day4()
        val input = listOf("@", "@", "@", "@", "@")
        val result = day4.star2(input)
        assertEquals(5, result)
    }

    @Test
    @DisplayName("Star2: Checkerboard pattern removes all rolls")
    fun star2_checkerboardPattern_removesAll() {
        val day4 = Day4()
        val input = listOf(
            "@.@.@",
            ".@.@.",
            "@.@.@",
            ".@.@.",
            "@.@.@"
        )
        val result = day4.star2(input)
        assertEquals(13, result) // All have < 4 adjacent
    }
}
