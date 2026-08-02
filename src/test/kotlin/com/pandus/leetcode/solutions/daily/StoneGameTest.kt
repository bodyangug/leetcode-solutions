package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StoneGameTest {
    private val solution = StoneGame()

    @Test
    fun `test example 1 - piles 5,3,4,5`() {
        assertTrue(solution.stoneGame(intArrayOf(5, 3, 4, 5)))
    }

    @Test
    fun `test example 2 - piles 3,7,2,3`() {
        assertTrue(solution.stoneGame(intArrayOf(3, 7, 2, 3)))
    }

    @Test
    fun `test two piles - Alice picks larger`() {
        assertTrue(solution.stoneGame(intArrayOf(1, 3)))
    }

    @Test
    fun `test four piles with clear advantage`() {
        assertTrue(solution.stoneGame(intArrayOf(1, 2, 3, 100)))
    }

    @Test
    fun `test six piles`() {
        assertTrue(solution.stoneGame(intArrayOf(7, 8, 1, 2, 9, 4)))
    }
}
