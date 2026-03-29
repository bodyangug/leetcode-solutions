package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CheckIfStringsCanBeMadeEqualWithOperationsITest {
    private val solver = CheckIfStringsCanBeMadeEqualWithOperationsI()

    @Test
    @DisplayName("Example 1: s1 = 'abcd', s2 = 'cdab' -> true")
    fun canBeEqual_example1() {
        assertTrue(solver.canBeEqual("abcd", "cdab"))
    }

    @Test
    @DisplayName("Example 2: s1 = 'abcd', s2 = 'dacb' -> false")
    fun canBeEqual_example2() {
        assertFalse(solver.canBeEqual("abcd", "dacb"))
    }

    @Test
    @DisplayName("Already equal strings -> true")
    fun canBeEqual_alreadyEqual() {
        assertTrue(solver.canBeEqual("abcd", "abcd"))
    }

    @Test
    @DisplayName("All same characters -> true")
    fun canBeEqual_allSameCharacters() {
        assertTrue(solver.canBeEqual("aaaa", "aaaa"))
    }

    @Test
    @DisplayName("Swap only even indices (0,2) -> true")
    fun canBeEqual_swapEvenIndicesOnly() {
        assertTrue(solver.canBeEqual("abcd", "cbad"))
    }

    @Test
    @DisplayName("Swap only odd indices (1,3) -> true")
    fun canBeEqual_swapOddIndicesOnly() {
        assertTrue(solver.canBeEqual("abcd", "adcb"))
    }

    @Test
    @DisplayName("Swap both even and odd indices -> true")
    fun canBeEqual_swapBothEvenAndOdd() {
        assertTrue(solver.canBeEqual("abcd", "cdab"))
    }

    @Test
    @DisplayName("Even positions mismatch -> false")
    fun canBeEqual_evenPositionsMismatch() {
        assertFalse(solver.canBeEqual("abcd", "bbcd"))
    }

    @Test
    @DisplayName("Odd positions mismatch -> false")
    fun canBeEqual_oddPositionsMismatch() {
        assertFalse(solver.canBeEqual("abcd", "abed"))
    }

    @Test
    @DisplayName("Cross-parity swap needed (impossible) -> false")
    fun canBeEqual_crossParitySwap() {
        assertFalse(solver.canBeEqual("abcd", "bacd"))
    }

    @Test
    @DisplayName("Single character difference at even position -> false")
    fun canBeEqual_singleCharDiffEven() {
        assertFalse(solver.canBeEqual("abcd", "xbcd"))
    }

    @Test
    @DisplayName("Single character difference at odd position -> false")
    fun canBeEqual_singleCharDiffOdd() {
        assertFalse(solver.canBeEqual("abcd", "axcd"))
    }
}
