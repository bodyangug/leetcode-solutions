package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumNumberOfBalloonsTest {
    @Test
    @DisplayName("Example 1: text contains exactly one balloon")
    fun maxNumberOfBalloons_example1() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(1, solution.maxNumberOfBalloons("nlaebolko"))
    }

    @Test
    @DisplayName("Example 2: text contains letters for two balloons")
    fun maxNumberOfBalloons_example2() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(2, solution.maxNumberOfBalloons("loonbalxballpoon"))
    }

    @Test
    @DisplayName("Example 3: text missing required letters")
    fun maxNumberOfBalloons_example3() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(0, solution.maxNumberOfBalloons("leetcode"))
    }

    @Test
    @DisplayName("Empty string returns 0")
    fun maxNumberOfBalloons_emptyString() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(0, solution.maxNumberOfBalloons(""))
    }

    @Test
    @DisplayName("Exact letters for one balloon")
    fun maxNumberOfBalloons_exactOne() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(1, solution.maxNumberOfBalloons("balloon"))
    }

    @Test
    @DisplayName("Missing one 'l' limits the count")
    fun maxNumberOfBalloons_missingL() {
        val solution = MaximumNumberOfBalloons()
        // Only one 'l', need 2 per balloon => 0
        assertEquals(0, solution.maxNumberOfBalloons("baloon"))
    }

    @Test
    @DisplayName("Missing one 'o' limits the count")
    fun maxNumberOfBalloons_missingO() {
        val solution = MaximumNumberOfBalloons()
        // Only one 'o', need 2 per balloon => 0
        assertEquals(0, solution.maxNumberOfBalloons("ballon"))
    }

    @Test
    @DisplayName("Extra unrelated characters are ignored")
    fun maxNumberOfBalloons_extraCharacters() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(1, solution.maxNumberOfBalloons("xyzballoonxyz"))
    }

    @Test
    @DisplayName("Letters for three balloons")
    fun maxNumberOfBalloons_three() {
        val solution = MaximumNumberOfBalloons()
        assertEquals(3, solution.maxNumberOfBalloons("balloonballoonballoon"))
    }

    @Test
    @DisplayName("'b' is the limiting letter")
    fun maxNumberOfBalloons_limitedByB() {
        val solution = MaximumNumberOfBalloons()
        // b=1, a=2, l=4, o=4, n=2 => limited by b => 1
        assertEquals(1, solution.maxNumberOfBalloons("baalllloonnoo"))
    }
}
