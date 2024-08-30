package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii
class MinimumSwapsToGroupAll1sTogetherII {
    fun minSwaps(nums: IntArray): Int {
        var minimumSwaps = Int.MAX_VALUE

        var totalOnes = 0
        for (num in nums) {
            totalOnes += num
        }

        var onesCount = nums[0]
        var end = 0

        for (start in nums.indices) {
            if (start != 0) {
                onesCount -= nums[start - 1]
            }

            while (end - start + 1 < totalOnes) {
                end++
                onesCount += nums[end % nums.size]
            }
            minimumSwaps = min(minimumSwaps, (totalOnes - onesCount))
        }
        return minimumSwaps
    }
}
