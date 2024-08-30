package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/stone-game-ii
class StoneGameII {
    fun stoneGameII(piles: IntArray): Int {
        val length = piles.size
        val dp = Array(length + 1) { IntArray(length + 1) }

        // Store suffix sum for all possible suffix
        val suffixSum = IntArray(length + 1)
        for (i in length - 1 downTo 0) {
            suffixSum[i] = suffixSum[i + 1] + piles[i]
        }

        // Initialize the dp array.
        for (i in 0..length) {
            dp[i][length] = suffixSum[i]
        }

        // Start from the last index to store the future state first.
        for (index in length - 1 downTo 0) {
            for (maxTillNow in length - 1 downTo 1) {
                var x = 1
                while (x <= 2 * maxTillNow && index + x <= length) {
                    dp[index][maxTillNow] =
                        max(
                            dp[index][maxTillNow],
                            (suffixSum[index] - dp[index + x][max(maxTillNow, x)])
                        )
                    x++
                }
            }
        }
        return dp[0][1]
    }
}
