package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon
class TakingMaximumEnergyFromMysticDungeon {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val dp = IntArray(energy.size)
        var ans = Int.MIN_VALUE
        for (i in energy.size - 1 downTo 0) {
            if (i + k < energy.size) {
                dp[i] = dp[i + k] + energy[i]
            } else {
                dp[i] = energy[i]
            }
            ans = max(ans, dp[i])
        }
        return ans
    }
}
