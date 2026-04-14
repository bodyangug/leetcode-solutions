package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-distance-to-the-target-element
class MinimumDistanceToTargetElement {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var ans = Int.MAX_VALUE
        for (i in nums.indices) {
            if (nums[i] == target) {
                ans = minOf(ans, kotlin.math.abs(i - start))
            }
        }
        return ans
    }
}
