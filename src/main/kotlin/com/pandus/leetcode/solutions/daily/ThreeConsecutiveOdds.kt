package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/three-consecutive-odds
class ThreeConsecutiveOdds {
    private var consecutiveOdds = 0

    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for (i in arr.indices) {
            if (arr[i] % 2 == 1) (consecutiveOdds++) else setToZero()
            if (consecutiveOdds == 3) return true
        }
        return false
    }

    private fun setToZero() {
        consecutiveOdds = 0
    }
}
