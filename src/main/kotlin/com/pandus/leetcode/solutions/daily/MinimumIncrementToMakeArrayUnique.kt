package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-increment-to-make-array-unique/
class MinimumIncrementToMakeArrayUnique {
    fun minIncrementForUnique(nums: IntArray): Int {
        var minIncrements = 0
        nums.sort()

        for (i in 1 until nums.size) {
            // Ensure each element is greater than its previous
            if (nums[i] <= nums[i - 1]) {
                // Add the required increment to minIncrements
                val increment = nums[i - 1] + 1 - nums[i]
                minIncrements += increment

                // Set the element to be greater than its previous
                nums[i] = nums[i - 1] + 1
            }
        }
        return minIncrements
    }
}
