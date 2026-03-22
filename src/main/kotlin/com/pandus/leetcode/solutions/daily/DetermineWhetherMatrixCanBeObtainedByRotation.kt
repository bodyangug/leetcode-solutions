package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation
class DetermineWhetherMatrixCanBeObtainedByRotation {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        var current = mat
        repeat(4) {
            if (equals(current, target)) return true
            current = rotate90(current, n)
        }
        return false
    }

    private fun rotate90(mat: Array<IntArray>, n: Int): Array<IntArray> {
        val rotated = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                rotated[j][n - 1 - i] = mat[i][j]
            }
        }
        return rotated
    }

    private fun equals(a: Array<IntArray>, b: Array<IntArray>): Boolean {
        return a.indices.all { i -> a[i].contentEquals(b[i]) }
    }
}
