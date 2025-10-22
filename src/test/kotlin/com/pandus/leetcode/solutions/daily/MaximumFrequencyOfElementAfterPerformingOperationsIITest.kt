package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyOfElementAfterPerformingOperationsIITest {
    private val solver = MaximumFrequencyOfElementAfterPerformingOperationsII()

    @Test
    fun emptyArray() {
        assertEquals(0, solver.maxFrequency(intArrayOf(), k = 5, numOperations = 10))
    }

    @Test
    fun singleElementVariousOpsAndK() {
        assertEquals(1, solver.maxFrequency(intArrayOf(10), k = 0, numOperations = 0))
        assertEquals(1, solver.maxFrequency(intArrayOf(10), k = 100, numOperations = 50))
    }

    @Test
    fun allSameValuesOperationsDoNotChangeResult() {
        val arr = intArrayOf(7, 7, 7, 7, 7)
        assertEquals(5, solver.maxFrequency(arr, k = 3, numOperations = 2))
        assertEquals(5, solver.maxFrequency(arr, k = 0, numOperations = 100))
    }

    @Test
    fun largeKAllowsFullWindowButLimitedByOpsAndArraySize() {
        val arr = intArrayOf(10, 100, 1000)
        assertEquals(3, solver.maxFrequency(arr.clone(), k = 2000, numOperations = 2))
        assertEquals(3, solver.maxFrequency(arr.clone(), k = 2000, numOperations = 100))
    }

    @Test
    fun operationsInsufficientToUseFullWindow() {
        val arr = intArrayOf(1, 2, 3, 4)
        assertEquals(2, solver.maxFrequency(arr.clone(), k = 10, numOperations = 1))
    }

    @Test
    fun kZeroIgnoresOperations() {
        val arr = intArrayOf(5, 6, 5, 6, 6)
        assertEquals(3, solver.maxFrequency(arr.clone(), k = 0, numOperations = 10)) // max existing freq is 3 (value 6)
    }

    @Test
    fun modeNotOriginallyPresentCandidate() {
        val arr = intArrayOf(1, 8)
        assertEquals(1, solver.maxFrequency(arr.clone(), k = 5, numOperations = 1))
    }

    @Test
    fun typicalMixedCase() {
        val arr = intArrayOf(1, 2, 3)
        assertEquals(3, solver.maxFrequency(arr, k = 1, numOperations = 2))
    }

    @Test
    fun multipleFrequenciesPickBest() {
        val arr = intArrayOf(2, 2, 9, 9, 9, 15)
        assertEquals(3, solver.maxFrequency(arr.clone(), k = 3, numOperations = 2))
    }
}
