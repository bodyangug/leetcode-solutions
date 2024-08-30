package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/find-k-th-smallest-pair-distance
class FindKthSmallestPairDistance {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        var k = k
        val arrayLength = nums.size
        val maxElement = nums.max()
        val distanceBucket = IntArray(maxElement + 1)

        // Populate the bucket array with counts of each distance
        for (i in 0 until arrayLength) {
            for (j in i + 1 until arrayLength) {
                // Compute the distance between nums[i] and nums[j]
                val distance = abs((nums[i] - nums[j]))
                // Increment the count for this distance in the bucket
                ++distanceBucket[distance]
            }
        }

        // Find the k-th smallest distance
        for (dist in 0..maxElement) {
            // Reduce k by the number of pairs with the current distance
            k -= distanceBucket[dist]
            // If k is less than or equal to 0, return the current distance
            if (k <= 0) {
                return dist
            }
        }
        return -1 // Return -1 if no distance found, should not reach here
    }
}
