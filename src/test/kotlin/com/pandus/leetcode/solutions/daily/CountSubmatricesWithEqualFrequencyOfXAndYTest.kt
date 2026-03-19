package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSubmatricesWithEqualFrequencyOfXAndYTest {
    private val solution = CountSubmatricesWithEqualFrequencyOfXAndY()

    @Test
    @DisplayName("Example 1: grid=[[X,Y,.],[Y,.,.]] -> 3")
    fun testExample1() {
        val grid = arrayOf(
            charArrayOf('X', 'Y', '.'),
            charArrayOf('Y', '.', '.')
        )
        assertEquals(3, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Example 2: grid=[[X,X],[X,Y]] -> 0")
    fun testExample2() {
        val grid = arrayOf(
            charArrayOf('X', 'X'),
            charArrayOf('X', 'Y')
        )
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Example 3: grid=[[.,.],[.,.]] -> 0, no X present")
    fun testExample3() {
        val grid = arrayOf(
            charArrayOf('.', '.'),
            charArrayOf('.', '.')
        )
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Single cell with X -> 0, no Y to balance")
    fun testSingleCellX() {
        val grid = arrayOf(charArrayOf('X'))
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Single cell with Y -> 0, no X present")
    fun testSingleCellY() {
        val grid = arrayOf(charArrayOf('Y'))
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Single cell with dot -> 0")
    fun testSingleCellDot() {
        val grid = arrayOf(charArrayOf('.'))
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Top-left is X, adjacent is Y -> submatrix (0,0)-(0,1) counts")
    fun testSingleRowXY() {
        val grid = arrayOf(charArrayOf('X', 'Y'))
        assertEquals(1, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Single column with X and Y")
    fun testSingleColumnXY() {
        val grid = arrayOf(
            charArrayOf('X'),
            charArrayOf('Y')
        )
        assertEquals(1, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("All X grid -> 0, no Y to balance")
    fun testAllX() {
        val grid = arrayOf(
            charArrayOf('X', 'X'),
            charArrayOf('X', 'X')
        )
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("All Y grid -> 0, no X present")
    fun testAllY() {
        val grid = arrayOf(
            charArrayOf('Y', 'Y'),
            charArrayOf('Y', 'Y')
        )
        assertEquals(0, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Balanced XY in first row with dots below")
    fun testBalancedFirstRowDotsBelow() {
        val grid = arrayOf(
            charArrayOf('X', 'Y'),
            charArrayOf('.', '.')
        )
        assertEquals(2, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Larger grid with multiple valid submatrices")
    fun testLargerGrid() {
        val grid = arrayOf(
            charArrayOf('X', 'Y', '.'),
            charArrayOf('.', '.', '.'),
            charArrayOf('.', '.', '.')
        )
        assertEquals(6, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Grid where only full matrix is balanced")
    fun testOnlyFullMatrixBalanced() {
        val grid = arrayOf(
            charArrayOf('X', '.'),
            charArrayOf('.', 'Y')
        )
        assertEquals(1, solution.numberOfSubmatrices(grid))
    }

    @Test
    @DisplayName("Single row with alternating X and Y")
    fun testSingleRowAlternating() {
        val grid = arrayOf(charArrayOf('X', 'Y', 'X', 'Y'))
        assertEquals(2, solution.numberOfSubmatrices(grid))
    }
}
