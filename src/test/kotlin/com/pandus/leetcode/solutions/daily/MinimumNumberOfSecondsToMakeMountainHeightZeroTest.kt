package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumNumberOfSecondsToMakeMountainHeightZeroTest {
    private val solver = MinimumNumberOfSecondsToMakeMountainHeightZero()

    @Test
    @DisplayName("Example 1: mountainHeight=4, workerTimes=[2,1,1] -> 3")
    fun example1() {
        assertEquals(3L, solver.minNumberOfSeconds(4, intArrayOf(2, 1, 1)))
    }

    @Test
    @DisplayName("Example 2: mountainHeight=10, workerTimes=[3,2,2,4] -> 12")
    fun example2() {
        assertEquals(12L, solver.minNumberOfSeconds(10, intArrayOf(3, 2, 2, 4)))
    }

    @Test
    @DisplayName("Example 3: mountainHeight=5, workerTimes=[1] -> 15")
    fun example3_singleWorker() {
        assertEquals(15L, solver.minNumberOfSeconds(5, intArrayOf(1)))
    }

    @Test
    @DisplayName("Edge case: mountainHeight=1, single worker")
    fun edgeCase_heightOne() {
        assertEquals(5L, solver.minNumberOfSeconds(1, intArrayOf(5)))
    }

    @Test
    @DisplayName("Edge case: mountainHeight=1, multiple workers")
    fun edgeCase_heightOne_multipleWorkers() {
        assertEquals(1L, solver.minNumberOfSeconds(1, intArrayOf(3, 1, 2)))
    }

    @Test
    @DisplayName("All workers with same time: mountainHeight=3, workerTimes=[2,2,2]")
    fun allWorkersSameTime() {
        assertEquals(2L, solver.minNumberOfSeconds(3, intArrayOf(2, 2, 2)))
    }

    @Test
    @DisplayName("Large single worker time: mountainHeight=2, workerTimes=[10]")
    fun singleWorkerHeight2() {
        assertEquals(30L, solver.minNumberOfSeconds(2, intArrayOf(10)))
    }
}
