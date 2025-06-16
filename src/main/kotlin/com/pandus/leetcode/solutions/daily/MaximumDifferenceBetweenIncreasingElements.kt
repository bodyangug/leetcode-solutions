package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-difference-between-increasing-elements
class MaximumDifferenceBetweenIncreasingElements {
    fun maximumDifference(nums: IntArray): Int {
        var ans = -1
        var minSoFar = nums.first()
        for (num in nums.drop(1)) {
            if (num > minSoFar) {
                ans = maxOf(ans, num - minSoFar)
            } else {
                minSoFar = num
            }
        }
        return ans
    }
}
