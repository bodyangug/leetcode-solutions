package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OneBitAndTwoBitCharactersTest {
    private val solver = OneBitAndTwoBitCharacters()

    @Test
    fun testExample1() {
        val bits = intArrayOf(1, 0, 0)
        assertTrue(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testExample2() {
        val bits = intArrayOf(1, 1, 1, 0)
        assertFalse(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testSingleZero() {
        val bits = intArrayOf(0)
        assertTrue(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testAllZeros() {
        val bits = intArrayOf(0, 0, 0, 0)
        assertTrue(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testAllOnes() {
        val bits = intArrayOf(1, 1, 1, 1)
        assertFalse(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testEmptyArray() {
        val bits = intArrayOf()
        // No bits, so can't end with a one-bit character
        assertFalse(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testTwoBitAtEnd() {
        val bits = intArrayOf(1, 1, 0)
        assertTrue(solver.isOneBitCharacter(bits))
    }

    @Test
    fun testComplexCase() {
        val bits = intArrayOf(1, 0, 1, 1, 0, 0)
        assertTrue(solver.isOneBitCharacter(bits))
    }
}
