package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/trapping-rain-water
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var ans = 0
        val size = height.size
        for (i in 1 until size - 1) {
            var leftMax = 0
            var rightMax = 0
            for (j in i downTo 0) { // Search the left part for max bar size
                leftMax = maxOf(leftMax, height[j])
            }
            for (j in i until size) { // Search the right part for max bar size
                rightMax = maxOf(rightMax, height[j])
            }
            ans += minOf(leftMax, rightMax) - height[i]
        }
        return ans
    }
}
