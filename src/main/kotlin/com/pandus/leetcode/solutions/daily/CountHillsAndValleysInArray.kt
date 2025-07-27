package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-hills-and-valleys-in-an-array
class CountHillsAndValleysInArray {
    fun countHillValley(nums: IntArray): Int {
        val dedup = mutableListOf<Int>()
        // Step 1: Collapse adjacent duplicates
        for (i in nums.indices) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                dedup.add(nums[i])
            }
        }

        var count = 0
        // Step 2: Traverse deduplicated array and compare neighbors
        for (i in 1 until dedup.lastIndex) {
            if ((dedup[i] > dedup[i - 1] && dedup[i] > dedup[i + 1]) ||
                (dedup[i] < dedup[i - 1] && dedup[i] < dedup[i + 1])
            ) {
                count++
            }
        }
        return count
    }
}
