package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JumpGameVIITest {
    private val solution = JumpGameVII()

    @Test
    @DisplayName("Example 1: s='011010', minJump=2, maxJump=3 should return true")
    fun testExample1() {
        assertTrue(solution.canReach("011010", 2, 3))
    }

    @Test
    @DisplayName("Example 2: s='01101110', minJump=2, maxJump=3 should return false")
    fun testExample2() {
        assertFalse(solution.canReach("01101110", 2, 3))
    }

    @Test
    @DisplayName("Single zero: s='0' should return true (already at end)")
    fun testSingleZero() {
        assertTrue(solution.canReach("0", 1, 1))
    }

    @Test
    @DisplayName("Last character is '1' should return false")
    fun testLastCharIsOne() {
        assertFalse(solution.canReach("01", 1, 1))
    }

    @Test
    @DisplayName("All zeros with exact jump: s='000', minJump=1, maxJump=2 should return true")
    fun testAllZeros() {
        assertTrue(solution.canReach("000", 1, 2))
    }

    @Test
    @DisplayName("Cannot reach due to blocked path: s='0110', minJump=1, maxJump=1 should return false")
    fun testBlockedPath() {
        assertFalse(solution.canReach("0110", 1, 1))
    }

    @Test
    @DisplayName("Large jump range covers entire string: s='00', minJump=1, maxJump=5 should return true")
    fun testLargeJumpRange() {
        assertTrue(solution.canReach("00", 1, 5))
    }
}
