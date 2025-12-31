package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Day11Test {
    private val day11 = Day11()

    // Star 1 Tests - Finding all paths from "you" to "out"

    @Test
    @DisplayName("star1 - example data with 5 paths from you to out")
    fun `star1 - should find 5 paths in example graph`() {
        val input = listOf(
            "aaa: you hhh",
            "you: bbb ccc",
            "bbb: ddd eee",
            "ccc: ddd eee fff",
            "ddd: ggg",
            "eee: out",
            "fff: out",
            "ggg: out",
            "hhh: ccc fff iii",
            "iii: out"
        )
        val result = day11.star1(input)
        assertEquals(5, result, "Should find exactly 5 different paths from you to out")
    }

    @Test
    @DisplayName("star1 - simple direct path")
    fun `star1 - single direct path from you to out`() {
        val input = listOf(
            "you: out"
        )
        val result = day11.star1(input)
        assertEquals(1, result, "Should find 1 direct path")
    }

    @Test
    @DisplayName("star1 - two parallel paths")
    fun `star1 - multiple parallel paths`() {
        val input = listOf(
            "you: a b",
            "a: out",
            "b: out"
        )
        val result = day11.star1(input)
        assertEquals(2, result, "Should find 2 parallel paths")
    }

    @Test
    @DisplayName("star1 - linear chain path")
    fun `star1 - linear chain from you to out`() {
        val input = listOf(
            "you: a",
            "a: b",
            "b: c",
            "c: out"
        )
        val result = day11.star1(input)
        assertEquals(1, result, "Should find 1 path in linear chain")
    }

    @Test
    @DisplayName("star1 - branching and merging paths")
    fun `star1 - paths that branch and merge`() {
        val input = listOf(
            "you: a b",
            "a: c",
            "b: c",
            "c: out"
        )
        val result = day11.star1(input)
        assertEquals(2, result, "Should find 2 paths that merge at c")
    }

    @Test
    @DisplayName("star1 - no path to out")
    fun `star1 - graph with no path to out`() {
        val input = listOf(
            "you: a",
            "a: b",
            "b: c"
        )
        val result = day11.star1(input)
        assertEquals(0, result, "Should find 0 paths when out is unreachable")
    }

    @Test
    @DisplayName("star1 - multiple paths with different lengths")
    fun `star1 - various path lengths`() {
        val input = listOf(
            "you: a b c",
            "a: out",
            "b: d",
            "d: out",
            "c: e",
            "e: f",
            "f: out"
        )
        val result = day11.star1(input)
        assertEquals(3, result, "Should find 3 paths of different lengths")
    }

    // Star 2 Tests - Finding paths from "svr" to "out" that visit both "dac" and "fft"

    @Test
    @DisplayName("star2 - example data with 2 paths visiting both dac and fft")
    fun `star2 - should find 2 paths visiting both dac and fft`() {
        val input = listOf(
            "svr: aaa bbb",
            "aaa: fft",
            "fft: ccc",
            "bbb: tty",
            "tty: ccc",
            "ccc: ddd eee",
            "ddd: hub",
            "hub: fff",
            "eee: dac",
            "dac: fff",
            "fff: ggg hhh",
            "ggg: out",
            "hhh: out"
        )
        val result = day11.star2(input)
        assertEquals(2L, result, "Should find exactly 2 paths that visit both dac and fft")
    }

    @Test
    @DisplayName("star2 - path visiting only dac should not count")
    fun `star2 - path with only dac is not counted`() {
        val input = listOf(
            "svr: a",
            "a: dac",
            "dac: out"
        )
        val result = day11.star2(input)
        assertEquals(0L, result, "Should find 0 paths when fft is not visited")
    }

    @Test
    @DisplayName("star2 - path visiting only fft should not count")
    fun `star2 - path with only fft is not counted`() {
        val input = listOf(
            "svr: a",
            "a: fft",
            "fft: out"
        )
        val result = day11.star2(input)
        assertEquals(0L, result, "Should find 0 paths when dac is not visited")
    }

    @Test
    @DisplayName("star2 - single path visiting both dac and fft")
    fun `star2 - one path through both required nodes`() {
        val input = listOf(
            "svr: dac",
            "dac: fft",
            "fft: out"
        )
        val result = day11.star2(input)
        assertEquals(1L, result, "Should find 1 path visiting both dac and fft")
    }

    @Test
    @DisplayName("star2 - path with fft before dac")
    fun `star2 - path visiting fft then dac`() {
        val input = listOf(
            "svr: fft",
            "fft: dac",
            "dac: out"
        )
        val result = day11.star2(input)
        assertEquals(1L, result, "Should find 1 path visiting fft then dac")
    }

    @Test
    @DisplayName("star2 - multiple paths all visiting both nodes")
    fun `star2 - all paths visit both required nodes`() {
        val input = listOf(
            "svr: dac",
            "dac: fft",
            "fft: a b",
            "a: out",
            "b: out"
        )
        val result = day11.star2(input)
        assertEquals(2L, result, "Should find 2 paths both visiting dac and fft")
    }

    @Test
    @DisplayName("star2 - mixed paths where some visit both nodes")
    fun `star2 - only count paths visiting both nodes`() {
        val input = listOf(
            "svr: a b",
            "a: dac",
            "dac: fft",
            "fft: out",
            "b: out"
        )
        val result = day11.star2(input)
        assertEquals(1L, result, "Should find 1 path visiting both (path through b doesn't count)")
    }

    @Test
    @DisplayName("star2 - no paths when svr cannot reach out")
    fun `star2 - no path from svr to out`() {
        val input = listOf(
            "svr: a",
            "a: dac",
            "dac: fft",
            "other: out"
        )
        val result = day11.star2(input)
        assertEquals(0L, result, "Should find 0 paths when out is unreachable from svr")
    }

    @Test
    @DisplayName("star2 - svr is dac node")
    fun `star2 - start node is dac`() {
        val input = listOf(
            "svr: fft",
            "fft: out"
        )
        // Note: svr is the start node, not dac, so this should be 0
        val result = day11.star2(input)
        assertEquals(0L, result, "Should find 0 paths when dac is not visited")
    }

    @Test
    @DisplayName("star2 - verify example paths are correct")
    fun `star2 - detailed verification of example paths`() {
        val input = listOf(
            "svr: aaa bbb",
            "aaa: fft",
            "fft: ccc",
            "bbb: tty",
            "tty: ccc",
            "ccc: ddd eee",
            "ddd: hub",
            "hub: fff",
            "eee: dac",
            "dac: fff",
            "fff: ggg hhh",
            "ggg: out",
            "hhh: out"
        )

        // Expected valid paths (from problem description):
        // 1. svr,aaa,fft,ccc,eee,dac,fff,ggg,out
        // 2. svr,aaa,fft,ccc,eee,dac,fff,hhh,out
        // (svr->bbb->tty->ccc paths don't go through fft, so they don't count)

        val result = day11.star2(input)
        assertEquals(2L, result, "Should find exactly 2 paths as per example: both through aaa->fft->...->dac")
    }
}
