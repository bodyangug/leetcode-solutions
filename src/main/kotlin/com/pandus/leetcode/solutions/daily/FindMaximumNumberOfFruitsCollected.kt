package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected
class FindMaximumNumberOfFruitsCollected {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size
        var ans = 0

        // Sum the diagonal
        for (i in 0 until n) {
            ans += fruits[i][i]
        }

        fun computeDP(): Int {
            var prev = IntArray(n) { Int.MIN_VALUE }
            var curr = IntArray(n) { Int.MIN_VALUE }

            prev[n - 1] = fruits[0][n - 1]

            for (i in 1 until n - 1) {
                val minJ = max(n - 1 - i, i + 1)
                for (j in minJ until n) {
                    var best = prev[j]
                    if (j - 1 >= 0) best = max(best, prev[j - 1])
                    if (j + 1 < n) best = max(best, prev[j + 1])
                    curr[j] = best + fruits[i][j]
                }
                val temp = prev
                prev = curr
                curr = temp
            }

            return prev[n - 1]
        }

        ans += computeDP()

        // Transpose matrix
        for (i in 0 until n) {
            for (j in 0 until i) {
                val temp = fruits[i][j]
                fruits[i][j] = fruits[j][i]
                fruits[j][i] = temp
            }
        }

        ans += computeDP()

        return ans
    }
}
