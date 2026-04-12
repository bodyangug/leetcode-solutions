package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers
class MinimumDistanceToTypeWordUsingTwoFingers {
    private fun getDistance(p: Int, q: Int): Int {
        val x1 = p / 6
        val y1 = p % 6
        val x2 = q / 6
        val y2 = q % 6
        return abs(x1 - x2) + abs(y1 - y2)
    }

    fun minimumDistance(word: String): Int {
        val n = word.length
        val dp = Array(n) { Array(26) { IntArray(26) } }
        for (i in 0..<n) {
            for (j in 0..25) {
                for (k in 0..25) {
                    dp[i][j][k] = Int.MAX_VALUE / 2
                }
            }
        }

        for (i in 0..25) {
            dp[0][i][word[0].code - 'A'.code] = 0
            dp[0][word[0].code - 'A'.code][i] = 0
        }

        for (i in 1..<n) {
            val cur = word[i].code - 'A'.code
            val prev = word[i - 1].code - 'A'.code
            val d = getDistance(prev, cur)

            for (j in 0..25) {
                dp[i][cur][j] = min(dp[i][cur][j], dp[i - 1][prev][j] + d)
                dp[i][j][cur] = min(dp[i][j][cur], dp[i - 1][j][prev] + d)

                if (prev == j) {
                    for (k in 0..25) {
                        val d0 = getDistance(k, cur)
                        dp[i][cur][j] = min(
                            dp[i][cur][j],
                            dp[i - 1][k][j] + d0
                        )
                        dp[i][j][cur] = min(
                            dp[i][j][cur],
                            dp[i - 1][j][k] + d0
                        )
                    }
                }
            }
        }

        var ans = Int.MAX_VALUE / 2
        for (i in 0..25) {
            for (j in 0..25) {
                ans = min(ans, dp[n - 1][i][j])
            }
        }
        return ans
    }
}
