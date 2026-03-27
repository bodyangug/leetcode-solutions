package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts
class MatrixSimilarityAfterCyclicShifts {
    fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        val m = mat.size
        val n = mat[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                val shift = if (i % 2 == 0) k % n else (n - k % n) % n
                if (mat[i][j] != mat[i][(j + shift) % n]) {
                    return false
                }
            }
        }
        return true
    }
}
