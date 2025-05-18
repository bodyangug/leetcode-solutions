package com.pandus.leetcode.solutions.daily

import kotlin.math.pow


// Reference: https://leetcode.com/problems/painting-a-grid-with-three-different-colors
class PaintingGridWithThreeDifferentColors {
    val mod = 1_000_000_007

    fun colorTheGrid(m: Int, n: Int): Int {
        val valid = mutableMapOf<Int, List<Int>>()
        val maxMask = 3.0.pow(m).toInt()

        for (mask in 0 until maxMask) {
            val colors = MutableList(m) { 0 }
            var value = mask
            var validMask = true

            for (i in 0 until m) {
                colors[i] = value % 3
                if (i > 0 && colors[i] == colors[i - 1]) {
                    validMask = false
                    break
                }
                value /= 3
            }

            if (validMask) {
                valid[mask] = colors
            }
        }

        val adjacent = mutableMapOf<Int, MutableList<Int>>()
        for ((mask1, color1) in valid) {
            for ((mask2, color2) in valid) {
                if ((0 until m).all { color1[it] != color2[it] }) {
                    adjacent.computeIfAbsent(mask1) { mutableListOf() }.add(mask2)
                }
            }
        }

        var dp = mutableMapOf<Int, Int>().apply {
            for (mask in valid.keys) this[mask] = 1
        }

        repeat(n - 1) {
            val next = mutableMapOf<Int, Int>()
            for ((mask2, list) in adjacent) {
                for (mask1 in list) {
                    val count = (next.getOrDefault(mask2, 0) + dp.getOrDefault(mask1, 0)) % mod
                    next[mask2] = count
                }
            }
            dp = next
        }

        return dp.values.fold(0) { acc, v -> (acc + v) % mod }
    }
}
