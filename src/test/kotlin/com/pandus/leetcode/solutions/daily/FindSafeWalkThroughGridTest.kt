package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindSafeWalkThroughGridTest {
    private val solution = FindSafeWalkThroughGrid()

    @Test
    fun findSafeWalk_example1_returnsTrue() {
        val grid = listOf(
            listOf(0, 1, 0, 0, 0),
            listOf(0, 1, 0, 1, 0),
            listOf(0, 0, 0, 1, 0),
        )
        assertTrue(solution.findSafeWalk(grid, 1))
    }

    @Test
    fun findSafeWalk_example2_returnsFalse() {
        val grid = listOf(
            listOf(0, 1, 1, 0, 0, 0),
            listOf(1, 0, 1, 0, 0, 0),
            listOf(0, 1, 1, 1, 0, 1),
            listOf(0, 0, 1, 0, 1, 0),
        )
        assertFalse(solution.findSafeWalk(grid, 3))
    }

    @Test
    fun findSafeWalk_example3_returnsTrue() {
        val grid = listOf(
            listOf(1, 1, 1),
            listOf(1, 0, 1),
            listOf(1, 1, 1),
        )
        assertTrue(solution.findSafeWalk(grid, 5))
    }

    @Test
    fun findSafeWalk_example2_withEnoughHealth_returnsTrue() {
        val grid = listOf(
            listOf(0, 1, 1, 0, 0, 0),
            listOf(1, 0, 1, 0, 0, 0),
            listOf(0, 1, 1, 1, 0, 1),
            listOf(0, 0, 1, 0, 1, 0),
        )
        assertTrue(solution.findSafeWalk(grid, 4))
    }

    @Test
    fun findSafeWalk_singleSafeCell_returnsTrue() {
        val grid = listOf(listOf(0))
        assertTrue(solution.findSafeWalk(grid, 1))
    }

    @Test
    fun findSafeWalk_singleUnsafeCell_withOneHealth_returnsFalse() {
        val grid = listOf(listOf(1))
        assertFalse(solution.findSafeWalk(grid, 1))
    }

    @Test
    fun findSafeWalk_singleUnsafeCell_withTwoHealth_returnsTrue() {
        val grid = listOf(listOf(1))
        assertTrue(solution.findSafeWalk(grid, 2))
    }

    @Test
    fun findSafeWalk_allSafeGrid_returnsTrue() {
        val grid = listOf(
            listOf(0, 0, 0),
            listOf(0, 0, 0),
            listOf(0, 0, 0),
        )
        assertTrue(solution.findSafeWalk(grid, 1))
    }

    @Test
    fun findSafeWalk_startCellUnsafe_consumesHealth() {
        val grid = listOf(
            listOf(1, 0),
            listOf(0, 0),
        )
        assertFalse(solution.findSafeWalk(grid, 1))
        assertTrue(solution.findSafeWalk(grid, 2))
    }

    @Test
    fun findSafeWalk_detourAroundUnsafeCells_returnsTrue() {
        val grid = listOf(
            listOf(0, 1, 0),
            listOf(0, 1, 0),
            listOf(0, 0, 0),
        )
        assertTrue(solution.findSafeWalk(grid, 1))
    }

    @Test
    fun findSafeWalk_exactHealthBoundary_returnsTrue() {
        val grid = listOf(
            listOf(0, 1),
            listOf(1, 0),
        )
        assertTrue(solution.findSafeWalk(grid, 2))
    }

    @Test
    fun findSafeWalk_exactHealthBoundary_oneLess_returnsFalse() {
        val grid = listOf(
            listOf(0, 1),
            listOf(1, 0),
        )
        assertFalse(solution.findSafeWalk(grid, 1))
    }
}
