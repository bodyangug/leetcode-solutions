package com.pandus.leetcode.solutions.weekly

import com.pandus.leetcode.solutions.model.BinaryMatrix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeftmostColumnWithAtLeastOneTest {
    @Test
    fun leftMostColumnWithOne_findsLeftmostColumn_positiveCase() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(0, 0, 0, 0)
        )
        val binaryMatrix = BinaryMatrix(matrix)
        val solution = LeftmostColumnWithAtLeastOne()
        assertEquals(1, solution.leftMostColumnWithOne(binaryMatrix))
    }

    @Test
    fun leftMostColumnWithOne_returnsMinusOneWhenNoOne_negativeCase() {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        val binaryMatrix = BinaryMatrix(matrix)
        val solution = LeftmostColumnWithAtLeastOne()
        assertEquals(-1, solution.leftMostColumnWithOne(binaryMatrix))
    }
}
