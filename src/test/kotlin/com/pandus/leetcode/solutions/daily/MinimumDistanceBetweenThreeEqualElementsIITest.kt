package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceBetweenThreeEqualElementsIITest {
    private val solver = MinimumDistanceBetweenThreeEqualElementsII()

    @Test
    fun example1() {
        assertEquals(6, solver.minimumDistance(intArrayOf(1, 2, 1, 1, 3)))
    }

    @Test
    fun example2() {
        assertEquals(8, solver.minimumDistance(intArrayOf(1, 1, 2, 3, 2, 1, 2)))
    }

    @Test
    fun example3_noGoodTuple() {
        assertEquals(-1, solver.minimumDistance(intArrayOf(1)))
    }

    @Test
    fun noGoodTuple_allDistinct() {
        assertEquals(-1, solver.minimumDistance(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun noGoodTuple_onlyTwoDuplicates() {
        assertEquals(-1, solver.minimumDistance(intArrayOf(1, 2, 1)))
    }

    @Test
    fun exactlyThreeEqual_consecutive() {
        // indices 0,1,2 => distance = |0-1| + |1-2| + |2-0| = 1+1+2 = 4
        assertEquals(4, solver.minimumDistance(intArrayOf(5, 5, 5)))
    }

    @Test
    fun exactlyThreeEqual_spread() {
        // indices 0,2,4 => distance = 2+2+4 = 8
        assertEquals(8, solver.minimumDistance(intArrayOf(3, 0, 3, 0, 3)))
    }

    @Test
    fun multipleGroups_picksBest() {
        // group of 1s at indices 0,1,2 => distance 4
        // group of 2s at indices 3,4,5 => distance 4
        assertEquals(4, solver.minimumDistance(intArrayOf(1, 1, 1, 2, 2, 2)))
    }

    @Test
    fun fourEqualElements_slidingWindow() {
        // indices: 0,1,2,3 — triplets (0,1,2)=4, (1,2,3)=4
        assertEquals(4, solver.minimumDistance(intArrayOf(7, 7, 7, 7)))
    }

    @Test
    fun largeGap() {
        // 1 at indices 0, 5, 10 => distance = 5+5+10 = 20
        val nums = intArrayOf(1, 2, 3, 4, 5, 1, 6, 7, 8, 9, 1)
        assertEquals(20, solver.minimumDistance(nums))
    }

    @Test
    fun allSameElements() {
        // All same: best is any three consecutive indices => distance 4
        assertEquals(4, solver.minimumDistance(intArrayOf(9, 9, 9, 9, 9, 9)))
    }

    @Test
    fun emptyArray() {
        assertEquals(-1, solver.minimumDistance(intArrayOf()))
    }

    @Test
    fun twoElements() {
        assertEquals(-1, solver.minimumDistance(intArrayOf(1, 1)))
    }
}
