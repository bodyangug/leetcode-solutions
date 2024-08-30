package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/count-subarrays-with-fixed-bounds
class CountSubarraysWithFixedBounds {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var answer: Long = 0
        var minPosition = -1
        var maxPosition = -1
        var leftBound = -1

        for (i in nums.indices) {
            if (nums[i] < minK || nums[i] > maxK) leftBound = i

            if (nums[i] == minK) minPosition = i
            if (nums[i] == maxK) maxPosition = i

            answer += max(0, (min(maxPosition, minPosition) - leftBound))
        }
        return answer
    }
}
