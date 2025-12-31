package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {
    private val day7 = Day7()

    @Test
    fun `star2 - no splitter, particle just exits bottom`() {
        // A single particle starts at S, moves down through empty cells, exits bottom
        // Expected: 1 timeline
        val input = listOf(
            "S..",
            "...",
            "..."
        )
        val result = day7.star2(input)
        assertEquals(1L, result, "Single particle with no splitters should produce exactly 1 timeline")
    }

    @Test
    fun `star2 - single splitter with both branches in-bounds`() {
        // Particle starts at S, moves down to splitter at (1,1)
        // Splits into two branches at (1,0) and (1,2)
        // Both branches exit bottom -> 2 timelines
        val input = listOf(
            ".S.",
            ".^.",
            "..."
        )
        val result = day7.star2(input)
        assertEquals(2L, result, "One splitter should create 2 timelines")
    }

    @Test
    fun `star2 - splitter at left edge, left branch goes out-of-bounds`() {
        // Particle starts at S (column 0), hits splitter at (1,0)
        // Left branch at (1,-1) goes out-of-bounds -> counts as 1 timeline immediately
        // Right branch at (1,1) continues down and exits -> counts as 1 timeline
        // Total: 2 timelines
        val input = listOf(
            "S..",
            "^..",
            "..."
        )
        val result = day7.star2(input)
        assertEquals(2L, result, "Splitter at left edge: left branch out-of-bounds still counts as 1 timeline")
    }

    @Test
    fun `star2 - splitter at right edge, right branch goes out-of-bounds`() {
        // Particle starts at S (column 2), hits splitter at (1,2)
        // Left branch at (1,1) continues down and exits -> 1 timeline
        // Right branch at (1,3) goes out-of-bounds -> counts as 1 timeline immediately
        // Total: 2 timelines
        val input = listOf(
            "..S",
            "..^",
            "..."
        )
        val result = day7.star2(input)
        assertEquals(2L, result, "Splitter at right edge: right branch out-of-bounds still counts as 1 timeline")
    }

    @Test
    fun `star2 - merging locations should sum multiplicities (core many-worlds property)`() {
        // This test verifies that when multiple paths reach the same cell,
        // they DON'T merge into one (as in star1), but maintain their separate counts.
        //
        // Grid layout:
        // Row 0:  .S.  (particle starts at col 1)
        // Row 1:  .^.  (splits: left to col 0, right to col 2)
        // Row 2:  ...  (two particles at col 0 and col 2)
        // Row 3:  ^.^  (both hit splitters again)
        //              - particle at col 0 splits to (-1)[exit], (1)
        //              - particle at col 2 splits to (1), (3)[exit]
        //              - Now col 1 has 2 particles (multiplicity=2)
        // Row 4:  ...  (2 particles at col 1)
        // Row 5:  .^.  (splitter at col 1: 2 particles hit it)
        //              - Each particle splits, so we get 2 left branches + 2 right branches = 4 total
        //
        // Final: 2 (exits at row 3) + 4 (exits after row 5) = 6? Let's trace carefully:
        // Actually:
        //   Row 3: col 0 -> exits left (1), continues to col 1 (1)
        //          col 2 -> continues to col 1 (1), exits right (1)
        //   After row 3: col 1 has 2 timelines
        //   Row 5: col 1 (with 2 timelines) hits splitter
        //          -> left: 2 timelines, right: 2 timelines
        //   Total exits: 1 (left at row 3) + 1 (right at row 3) + 2 (left from row 5) + 2 (right from row 5) = 8?
        // Let me recalculate more carefully...
        val input = listOf(
            ".S.",
            ".^.",
            "...",
            "^.^",
            "...",
            ".^."
        )
        val result = day7.star2(input)

        // Detailed trace:
        // Row 0, col 1: 1 timeline
        // Row 1, col 1 hits ^: splits to (1,0) and (1,2), each with 1 timeline
        // Row 2: col 0 has 1, col 2 has 1
        // Row 3, col 0 hits ^: splits to (3,-1)[exit=1] and (3,1)[1]
        //        col 2 hits ^: splits to (3,1)[1] and (3,3)[exit=1]
        // After row 3: col 1 has 1+1=2 timelines, exits so far: 2
        // Row 4: col 1 has 2
        // Row 5, col 1 hits ^: splits to (5,0)[2] and (5,2)[2]
        // Row 6: col 0 has 2, col 2 has 2, both exit bottom
        // Total exits: 2 (from row 3) + 2 (col 0 bottom) + 2 (col 2 bottom) = 6
        assertEquals(6L, result, "Multiple paths converging should sum multiplicities, not merge into one")
    }

    @Test
    fun `star2 - statement example grid with expected result 40`() {
        // This is the large example from the problem statement
        // Expected result: 40 timelines
        val input = listOf(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "..............."
        )
        val result = day7.star2(input)
        assertEquals(40L, result, "Statement example should produce exactly 40 timelines")
    }

    @Test
    fun `star2 - multiple splitters in sequence vertically`() {
        // Test cascading splitters
        val input = listOf(
            ".S.",
            ".^.",
            "^.^",
            "..."
        )
        val result = day7.star2(input)
        // Row 0, col 1: 1 timeline
        // Row 1, col 1 hits ^: splits to (1,0)[1] and (1,2)[1]
        // Row 2: col 0 hits ^: splits to (2,-1)[exit=1] and (2,1)[1]
        //        col 2 hits ^: splits to (2,1)[1] and (2,3)[exit=1]
        // After row 2: col 1 has 2, exits: 2
        // Row 3: col 1 with 2 exits bottom
        // Total: 2 + 2 = 4
        assertEquals(4L, result, "Cascading splitters should correctly multiply timelines")
    }

    @Test
    fun `star2 - single cell with S only`() {
        // Edge case: 1x1 grid with just S
        // Particle immediately exits bottom -> 1 timeline
        val input = listOf("S")
        val result = day7.star2(input)
        assertEquals(1L, result, "Single cell grid should produce 1 timeline")
    }

    @Test
    fun `star2 - all splitters, maximum branching`() {
        // Small grid with splitters that create maximum branching
        val input = listOf(
            "S",
            "^"
        )
        val result = day7.star2(input)
        // Row 0, col 0: 1
        // Row 1, col 0 hits ^: splits to (1,-1)[exit=1] and (1,1)[exit=1]
        // Total: 2
        assertEquals(2L, result, "Immediate splitter should create 2 exit timelines")
    }

    @Test
    fun `star2 - wide grid with multiple starting splits`() {
        // Test wider grid
        val input = listOf(
            ".....S.....",
            ".....^.....",
            "....^.^....",
            "...........",
        )
        val result = day7.star2(input)
        // Row 0, col 5: 1
        // Row 1, col 5 hits ^: (1,4)[1] and (1,6)[1]
        // Row 2: col 4 hits ^: (2,3)[1] and (2,5)[1]
        //        col 6 hits ^: (2,5)[1] and (2,7)[1]
        // After row 2: col 3 has 1, col 5 has 2, col 7 has 1
        // Row 3: all exit bottom: 1 + 2 + 1 = 4
        assertEquals(4L, result, "Wide grid with multiple paths should correctly count all timelines")
    }

    // ============================================================
    // PART 1 TESTS: Classical beam with visited-deduplication
    // ============================================================

    @Test
    fun `star1 - no splitter returns 0`() {
        // Beam travels straight down with no splitters encountered
        val input = listOf(
            "S..",
            "...",
            "..."
        )
        val result = day7.star1(input)
        assertEquals(0L, result, "No splitters means 0 split count")
    }

    @Test
    fun `star1 - single splitter returns 1`() {
        // One splitter directly under S
        val input = listOf(
            ".S.",
            ".^.",
            "..."
        )
        val result = day7.star1(input)
        assertEquals(1L, result, "One splitter encountered means 1 split count")
    }

    @Test
    fun `star1 - merge to three beams via deduplication`() {
        // This is the smallest clean case where two splits "dump into the same place" in the next row
        // First splitter creates 2 beams, then those 2 beams hit 2 more splitters = 3 total split events
        // Even though the new beams overlap at col 4, star1's visited set collapses them into one
        val input = listOf(
            "....S....", // row 0: S at col 4
            ".........", // row 1
            "....^....", // row 2: splitter at col 4 -> beams start at (2,3) and (2,5)
            ".........", // row 3
            "...^.^...", // row 4: splitters at col 3 and col 5
            "........." // row 5
        )
        val result = day7.star1(input)
        assertEquals(
            3L,
            result,
            "Three splitters encountered: first splitter (1), then two more splitters (2) = 3 total"
        )
    }

    @Test
    fun `star1 - statement example grid with expected result 21`() {
        // This is the large example from the problem statement for star1
        // Expected result: 21 splitters encountered
        val input = listOf(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "..............."
        )
        val result = day7.star1(input)
        assertEquals(21L, result, "Statement example should produce exactly 21 split events for star1")
    }

    @Test
    fun `star1 - edge splitter creates only one new beam`() {
        // When a splitter is at the edge, one branch goes out of bounds immediately
        // but we still count it as hitting a splitter
        val input = listOf(
            "S..",
            "^..",
            "..."
        )
        val result = day7.star1(input)
        assertEquals(1L, result, "Edge splitter still counts as 1 split event even if one branch exits")
    }

    @Test
    fun `star1 - both branches exit immediately after split`() {
        // Narrow grid where both branches exit bounds after splitting
        val input = listOf(
            "S",
            "^"
        )
        val result = day7.star1(input)
        assertEquals(1L, result, "Splitter counts even if both branches immediately exit bounds")
    }
}
