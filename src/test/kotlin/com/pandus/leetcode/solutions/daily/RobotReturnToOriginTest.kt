package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RobotReturnToOriginTest {
    private val solution = RobotReturnToOrigin()

    @Test
    fun `test example 1 - UD returns to origin`() {
        // Input: moves = "UD"
        // Output: true
        assertTrue(solution.judgeCircle("UD"))
    }

    @Test
    fun `test example 2 - LL does not return to origin`() {
        // Input: moves = "LL"
        // Output: false
        assertFalse(solution.judgeCircle("LL"))
    }

    @Test
    fun `test empty string returns to origin`() {
        assertTrue(solution.judgeCircle(""))
    }

    @Test
    fun `test single move up does not return`() {
        assertFalse(solution.judgeCircle("U"))
    }

    @Test
    fun `test single move down does not return`() {
        assertFalse(solution.judgeCircle("D"))
    }

    @Test
    fun `test single move left does not return`() {
        assertFalse(solution.judgeCircle("L"))
    }

    @Test
    fun `test single move right does not return`() {
        assertFalse(solution.judgeCircle("R"))
    }

    @Test
    fun `test all four directions returning to origin`() {
        // U+D cancel, L+R cancel
        assertTrue(solution.judgeCircle("UDLR"))
    }

    @Test
    fun `test complex path returning to origin`() {
        assertTrue(solution.judgeCircle("RRLLUUDD"))
    }

    @Test
    fun `test complex path not returning to origin`() {
        assertFalse(solution.judgeCircle("RRLLUUD"))
    }

    @Test
    fun `test circular square path`() {
        assertTrue(solution.judgeCircle("RRDDLLUU"))
    }

    @Test
    fun `test only horizontal moves not returning`() {
        assertFalse(solution.judgeCircle("RR"))
    }

    @Test
    fun `test only vertical moves not returning`() {
        assertFalse(solution.judgeCircle("UU"))
    }

    @Test
    fun `test long repeating pattern returning to origin`() {
        assertTrue(solution.judgeCircle("UDUDUDUDUDUD"))
    }

    @Test
    fun `test long repeating pattern not returning`() {
        assertFalse(solution.judgeCircle("UDUDUDUDUDUDU"))
    }
}
