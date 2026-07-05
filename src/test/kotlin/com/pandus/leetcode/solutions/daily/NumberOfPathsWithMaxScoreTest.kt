package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfPathsWithMaxScoreTest {
    private val solution = NumberOfPathsWithMaxScore()

    @Test
    fun `pathsWithMaxScore example 1`() {
        val board = listOf("E23", "2X2", "12S")
        assertArrayEquals(intArrayOf(7, 1), solution.pathsWithMaxScore(board))
    }

    @Test
    fun `pathsWithMaxScore example 2`() {
        val board = listOf("E12", "1X1", "21S")
        assertArrayEquals(intArrayOf(4, 2), solution.pathsWithMaxScore(board))
    }

    @Test
    fun `pathsWithMaxScore example 3`() {
        val board = listOf("E11", "XXX", "11S")
        assertArrayEquals(intArrayOf(0, 0), solution.pathsWithMaxScore(board))
    }
}
