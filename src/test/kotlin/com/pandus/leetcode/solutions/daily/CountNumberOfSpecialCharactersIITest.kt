package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountNumberOfSpecialCharactersIITest {
    private val solution = CountNumberOfSpecialCharactersII()

    @Test
    @DisplayName("Example 1: aaAbcBC -> 3 special letters")
    fun example1() {
        assertEquals(3, solution.numberOfSpecialChars("aaAbcBC"))
    }

    @Test
    @DisplayName("Example 2: abc -> 0 special letters (no uppercase)")
    fun example2() {
        assertEquals(0, solution.numberOfSpecialChars("abc"))
    }

    @Test
    @DisplayName("Example 3: AbBCab -> 0 (lowercase 'a' and 'b' appear after uppercase)")
    fun example3() {
        assertEquals(0, solution.numberOfSpecialChars("AbBCab"))
    }

    @Test
    @DisplayName("Single lowercase letter -> 0")
    fun singleLowercase() {
        assertEquals(0, solution.numberOfSpecialChars("a"))
    }

    @Test
    @DisplayName("Single uppercase letter -> 0")
    fun singleUppercase() {
        assertEquals(0, solution.numberOfSpecialChars("A"))
    }

    @Test
    @DisplayName("Pair aA -> 1 special letter")
    fun simplePair() {
        assertEquals(1, solution.numberOfSpecialChars("aA"))
    }

    @Test
    @DisplayName("Pair Aa -> 0 (lowercase after uppercase)")
    fun reversedPair() {
        assertEquals(0, solution.numberOfSpecialChars("Aa"))
    }

    @Test
    @DisplayName("Multiple valid pairs aAbBcC -> 3")
    fun multipleValidPairs() {
        assertEquals(3, solution.numberOfSpecialChars("aAbBcC"))
    }

    @Test
    @DisplayName("Mixed valid and invalid: aABb -> only 'a' is special")
    fun mixedValidInvalid() {
        assertEquals(1, solution.numberOfSpecialChars("aABb"))
    }

    @Test
    @DisplayName("All uppercase -> 0")
    fun allUppercase() {
        assertEquals(0, solution.numberOfSpecialChars("ABCDE"))
    }

    @Test
    @DisplayName("Lowercase after first uppercase disqualifies: aAbBbC -> a is special, b is not (last 'b' after 'B')")
    fun lowercaseAfterUppercase() {
        assertEquals(1, solution.numberOfSpecialChars("aAbBbC"))
    }
}
