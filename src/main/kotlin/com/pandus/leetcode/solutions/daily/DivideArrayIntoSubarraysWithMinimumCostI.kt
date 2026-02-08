package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i
class DivideArrayIntoSubarraysWithMinimumCostI {
    fun minimumCost(nums: IntArray): Int {
        Arrays.sort(nums, 1, nums.size)
        return nums[0] + nums[1] + nums[2]
    }
}
