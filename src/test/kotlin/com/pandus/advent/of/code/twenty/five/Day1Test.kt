package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    private val day1 = Day1()

    @Test
    fun `star1 - should count crossings at position 0 with simple right rotation`() {
        val input = listOf("R48")
        val result = day1.star1(input)
        assertEquals(0, result, "R48 from position 50 should end at 98, not crossing 0")
    }

    @Test
    fun `star1 - should count multiple crossings with sequence of commands`() {
        val input = listOf(
            "L68", // 50 -> 82 (crosses 0 once)
            "L30", // 82 -> 52 (no crossing)
            "R48" // 52 -> 0 (ends at 0, counted)
        )
        val result = day1.star1(input)
        assertEquals(1, result, "Should count 1 crossings: one during L68, one ending at 0")
    }

    @Test
    fun `star1 - should handle full example sequence`() {
        val input = listOf(
            "L68", // 50 -> 82 (crosses 0 once)
            "L30", // 82 -> 52 (no crossing)
            "R48", // 52 -> 0 (ends at 0)
            "L5", // 0 -> 95 (no crossing)
            "R60", // 95 -> 55 (crosses 0 once)
            "L55", // 55 -> 0 (ends at 0)
            "L1", // 0 -> 99 (no crossing)
            "L99", // 99 -> 0 (ends at 0)
            "R14", // 0 -> 14 (no crossing)
            "L82" // 14 -> 32 (crosses 0 once)
        )
        val result = day1.star1(input)
        assertEquals(3, result, "Should count 3 crossings based on example")
    }

    @Test
    fun `star2 - should count all crossings during rotations with L68`() {
        val input = listOf("L68")
        val result = day1.star2(input)
        assertEquals(1, result, "L68 from position 50 should cross 0 once during rotation")
    }

    @Test
    fun `star2 - should count all crossings during rotations with R48`() {
        val input = listOf("R48")
        val result = day1.star2(input)
        assertEquals(0, result, "R48 from position 50 should not cross 0 during rotation")
    }

    @Test
    fun `star2 - should count crossings during R60 rotation`() {
        val input = listOf(
            "L68", // 50 -> 82 (crosses 0 once)
            "L30", // 82 -> 52 (no crossing)
            "R48", // 52 -> 0 (ends at 0)
            "L5", // 0 -> 95 (no crossing)
            "R60" // 95 -> 55 (crosses 0 once: 95->99->0->1->...->55)
        )
        val result = day1.star2(input)
        assertEquals(3, result, "Should count 3 crossings: L68(1) + R48(1) + R60(1)")
    }

    @Test
    fun `star2 - should handle full example sequence`() {
        val input = listOf(
            "L68", // 50 -> 82 (crosses 0 once during rotation)
            "L30", // 82 -> 52 (no crossing)
            "R48", // 52 -> 0 (crosses 0 once at end)
            "L5", // 0 -> 95 (no crossing)
            "R60", // 95 -> 55 (crosses 0 once during rotation)
            "L55", // 55 -> 0 (crosses 0 once at end)
            "L1", // 0 -> 99 (no crossing)
            "L99", // 99 -> 0 (crosses 0 once at end)
            "R14", // 0 -> 14 (no crossing)
            "L82" // 14 -> 32 (crosses 0 once during rotation)
        )
        val result = day1.star2(input)
        assertEquals(6, result, "Should count 6 total crossings during all rotations")
    }

    @Test
    fun `star2 - should count crossing when ending exactly at 0`() {
        val input = listOf(
            "L50" // 50 -> 0 (should count as crossing)
        )
        val result = day1.star2(input)
        assertEquals(1, result, "Ending at position 0 should count as one crossing")
    }

    @Test
    fun `star2 - should count crossing when passing through 0`() {
        val input = listOf(
            "L51" // 50 -> 99 (passes through 0)
        )
        val result = day1.star2(input)
        assertEquals(1, result, "Passing through 0 should count as one crossing")
    }

    @Test
    fun `star2 - should count multiple crossings in single long rotation`() {
        val input = listOf(
            "L150" // 50 -> 0 (should pass through 0 twice: once at position 0, once at position 0 again after full rotation)
        )
        val result = day1.star2(input)
        assertEquals(2, result, "L150 should cross 0 twice during rotation")
    }

    @Test
    fun `star2 - should handle right rotation wrapping around`() {
        val input = listOf(
            "R50" // 50 -> 0 (should end exactly at 0)
        )
        val result = day1.star2(input)
        assertEquals(1, result, "R50 from position 50 should end at 0, counting as one crossing")
    }

    @Test
    fun `star2 - should handle right rotation passing through 0`() {
        val input = listOf(
            "R51" // 50 -> 1 (passes through 0: 50->99->0->1)
        )
        val result = day1.star2(input)
        assertEquals(1, result, "R51 should pass through 0 once")
    }

    @Test
    fun `star1 - edge case with no rotations`() {
        val input = emptyList<String>()
        val result = day1.star1(input)
        assertEquals(0, result, "No rotations should result in 0 crossings")
    }

    @Test
    fun `star2 - edge case with no rotations`() {
        val input = emptyList<String>()
        val result = day1.star2(input)
        assertEquals(0, result, "No rotations should result in 0 crossings")
    }
}
