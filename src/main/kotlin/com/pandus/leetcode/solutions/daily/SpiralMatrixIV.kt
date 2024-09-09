package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode

// Reference: https://leetcode.com/problems/spiral-matrix-iv
class SpiralMatrixIV {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val matrix = Array(m) { IntArray(n) { -1 } }
        val directions = arrayOf(
            0 to 1, // right
            1 to 0, // down
            0 to -1, // left
            -1 to 0 // up
        )
        var directionIndex = 0
        var currentRow = 0
        var currentCol = 0
        var currentNode = head

        while (currentNode != null) {
            matrix[currentRow][currentCol] = currentNode.`val`
            currentNode = currentNode.next

            val nextRow = currentRow + directions[directionIndex].first
            val nextCol = currentCol + directions[directionIndex].second
            if (nextRow !in 0 until m ||
                nextCol !in 0 until n ||
                matrix[nextRow][nextCol] != -1
            ) {
                directionIndex = (directionIndex + 1) % 4
            }
            currentRow += directions[directionIndex].first
            currentCol += directions[directionIndex].second
        }
        return matrix
    }
}
