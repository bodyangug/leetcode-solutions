package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/power-of-three
class PowerOfThree {
    private val MAX_P3_INT = 1162261467 // 3^19

    fun isPowerOfThree(n: Int): Boolean =
        n > 0 && MAX_P3_INT % n == 0
}
