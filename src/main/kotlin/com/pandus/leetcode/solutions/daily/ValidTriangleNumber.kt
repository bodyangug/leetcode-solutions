package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/valid-triangle-number
class ValidTriangleNumber {
    fun triangleNumber(nums: IntArray): Int {
        nums.sortDescending()
        var count = 0
        for (maxSideIdx in 0 until nums.size - 2) {
            var leftIdx = maxSideIdx + 1
            var rightIdx = nums.size - 1

            while (leftIdx < rightIdx) {
                val maxSide = nums[maxSideIdx]
                val leftSide = nums[leftIdx]
                val rightSide = nums[rightIdx]

                if (leftSide + rightSide > maxSide) {
                    count += rightIdx - leftIdx
                    leftIdx++
                } else {
                    rightIdx--
                }
            }
        }
        return count
    }
}
