package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/subarrays-with-k-different-integers
class SubarraysWithKDifferentIntegers {
    fun subarraysWithKDistinct(nums: IntArray, targetDistinct: Int): Int {
        var distinctCounter = IntArray(nums.size + 1)
        var totalSubarrays = 0
        var start = 0
        var currDistinct = 0
        var currCount = 0

        nums.forEachIndexed { _, num ->
            if (distinctCounter[num]++ == 0) currDistinct++
            if (currDistinct > targetDistinct) {
                distinctCounter[nums[start]]--
                start++
                currDistinct--
                currCount = 0
            }
            if (currDistinct == targetDistinct) {
                while (distinctCounter[nums[start]] > 1) {
                    distinctCounter[nums[start++]]--
                    currCount++
                }
                totalSubarrays += currCount + 1
            }
        }
        return totalSubarrays
    }
}
