package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PyramidTransitionMatrixTest {
    private val solution = PyramidTransitionMatrix()

    @Test
    fun `test example 1 - valid pyramid with BCD bottom`() {
        val bottom = "BCD"
        val allowed = mutableListOf("BCC", "CDE", "CEA", "FFF")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should be able to build pyramid: BCD -> CE -> A")
    }

    @Test
    fun `test example 2 - invalid pyramid with AAAA bottom`() {
        val bottom = "AAAA"
        val allowed = mutableListOf("AAB", "AAC", "BCD", "BBE", "DEF")
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "Should not be able to build complete pyramid")
    }

    @Test
    fun `test single block - always valid`() {
        val bottom = "A"
        val allowed = mutableListOf<String>()
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Single block pyramid is always valid")
    }

    @Test
    fun `test two blocks - valid transition`() {
        val bottom = "AB"
        val allowed = mutableListOf("ABC")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should be able to build: AB -> C")
    }

    @Test
    fun `test two blocks - no valid transition`() {
        val bottom = "AB"
        val allowed = mutableListOf("BCD", "DEF")
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "No pattern matches AB")
    }

    @Test
    fun `test multiple possible paths - finds valid one`() {
        val bottom = "XYZ"
        val allowed = mutableListOf("XYA", "XYB", "YZC", "ACD")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should find: XYZ -> AC -> (needs ACD) -> D")
    }

    @Test
    fun `test backtracking required - wrong path exists`() {
        val bottom = "ABC"
        val allowed = mutableListOf("ABX", "ABY", "BCZ", "XZD")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should backtrack from ABX,BCZ to ABY,BCZ if needed, or find XZD path")
    }

    @Test
    fun `test four blocks - complex valid pyramid`() {
        val bottom = "ABCD"
        val allowed = mutableListOf(
            "ABE",
            "BCF",
            "CDG",
            "EFH",
            "FGI",
            "HIJ"
        )
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should build complete 4-level pyramid")
    }

    @Test
    fun `test four blocks - incomplete patterns`() {
        val bottom = "ABCD"
        val allowed = mutableListOf(
            "ABE",
            "BCF",
            "CDG",
            "EFH"
        )
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "Missing FG pattern prevents completion")
    }

    @Test
    fun `test multiple valid transitions per pair`() {
        val bottom = "AB"
        val allowed = mutableListOf("ABC", "ABD", "ABE")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Any of C, D, or E works for single top block")
    }

    @Test
    fun `test all same letters - valid`() {
        val bottom = "AAA"
        val allowed = mutableListOf("AAA")
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should build: AAA -> AA -> A")
    }

    @Test
    fun `test all same letters - invalid`() {
        val bottom = "BBB"
        val allowed = mutableListOf("AAA", "CCC")
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "No pattern matches BB")
    }

    @Test
    fun `test long bottom row - valid`() {
        val bottom = "ABCDE"
        val allowed = mutableListOf(
            "ABF", "BCG", "CDH", "DEI",
            "FGJ", "GHK", "HIL",
            "JKM", "KLN",
            "MNO"
        )
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should build complete 5-level pyramid")
    }

    @Test
    fun `test pattern order matters - BA vs AB`() {
        val bottom = "BA"
        val allowed = mutableListOf("ABC") // Only ABC, not BAC
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "ABC pattern doesn't match BA base")
    }

    @Test
    fun `test pattern order matters - BA valid`() {
        val bottom = "BA"
        val allowed = mutableListOf("BAC") // BAC pattern
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "BAC pattern matches BA base")
    }

    @Test
    fun `test empty allowed list with multi-block bottom`() {
        val bottom = "AB"
        val allowed = mutableListOf<String>()
        val result = solution.pyramidTransition(bottom, allowed)
        assertFalse(result, "No patterns available")
    }

    @Test
    fun `test complex backtracking scenario`() {
        val bottom = "ABC"
        val allowed = mutableListOf(
            "ABD",
            "ABE",
            "BCD",
            "BCE",
            "DDX",
            "EEY"
        )
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should find valid path through backtracking")
    }

    @Test
    fun `test case sensitivity - different letters`() {
        val bottom = "XYZ"
        val allowed = mutableListOf(
            "XYA",
            "YZB",
            "ABA"
        )
        val result = solution.pyramidTransition(bottom, allowed)
        assertTrue(result, "Should successfully build: XYZ -> AB -> A")
    }
}
