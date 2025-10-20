package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinalValueOfVariableAfterPerformingOperationsTest {
    private val solver = FinalValueOfVariableAfterPerformingOperations()

    @Test
    fun sampleCase() {
        val ops = arrayOf("--X", "X++", "X++")
        assertEquals(1, solver.finalValueAfterOperations(ops))
    }

    @Test
    fun allPlus() {
        val n = 10
        val ops = Array(n) { "++X" }
        assertEquals(n, solver.finalValueAfterOperations(ops))
    }

    @Test
    fun allMinus() {
        val n = 7
        val ops = Array(n) { "X--" }
        assertEquals(-n, solver.finalValueAfterOperations(ops))
    }

    @Test
    fun mixed() {
        val ops = arrayOf("X++", "++X", "X--", "--X", "X++") // +1 +1 -1 -1 +1 = +1
        assertEquals(1, solver.finalValueAfterOperations(ops))
    }

    @Test
    fun empty() {
        val ops = emptyArray<String>()
        assertEquals(0, solver.finalValueAfterOperations(ops))
    }
}
