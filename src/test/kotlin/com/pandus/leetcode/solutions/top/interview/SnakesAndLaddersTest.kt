package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SnakesAndLaddersTest {

    private val solution = SnakesAndLadders()

    @Test
    fun testExample1() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 35, -1, -1, 13, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 15, -1, -1, -1, -1)
        )
        assertEquals(4, solution.snakesAndLadders(board))
    }

    @Test
    fun testExample2() {
        val board = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-1, 3)
        )
        assertEquals(1, solution.snakesAndLadders(board))
    }

    @Test
    fun testSimpleBoard() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1),
            intArrayOf(-1, -1, -1),
            intArrayOf(-1, -1, -1)
        )
        assertEquals(2, solution.snakesAndLadders(board)) // Minimum moves to reach square 9
    }

    @Test
    fun testGetCoordinates() {
        // Test coordinate conversion for 6x6 board
        assertEquals(Pair(5, 0), solution.getCoordinates(1, 6))
        assertEquals(Pair(5, 5), solution.getCoordinates(6, 6))
        assertEquals(Pair(4, 5), solution.getCoordinates(7, 6))
        assertEquals(Pair(0, 0), solution.getCoordinates(36, 6))
    }

    @Test
    fun testBoardWithSnakes() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1),
            intArrayOf(-1, 1, -1, -1) // Snake from square 14 back to 1
        )
        // Should take longer due to snake
        val result = solution.snakesAndLadders(board)
        assertTrue(result > 0)
    }
}
