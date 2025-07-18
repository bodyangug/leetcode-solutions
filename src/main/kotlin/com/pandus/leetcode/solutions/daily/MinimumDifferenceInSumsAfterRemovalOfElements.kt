package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements
class MinimumDifferenceInSumsAfterRemovalOfElements {
    fun minimumDifference(nums: IntArray): Long {
        val totalSize = nums.size
        val third = totalSize / 3

        // Left part (prefix min-sum using max-heap)
        val leftMinSums = LongArray(third + 1)
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        var leftSum = 0L

        for (i in 0 until third) {
            leftSum += nums[i]
            maxHeap.add(nums[i])
        }
        leftMinSums[0] = leftSum

        for (i in third until 2 * third) {
            leftSum += nums[i]
            maxHeap.add(nums[i])
            leftSum -= maxHeap.poll()
            leftMinSums[i - third + 1] = leftSum
        }

        // Right part (suffix max-sum using min-heap)
        val minHeap = PriorityQueue<Int>()
        var rightSum = 0L
        for (i in totalSize - 1 downTo 2 * third) {
            rightSum += nums[i]
            minHeap.add(nums[i])
        }

        var minDiff = leftMinSums[third] - rightSum

        for (i in 2 * third - 1 downTo third) {
            rightSum += nums[i]
            minHeap.add(nums[i])
            rightSum -= minHeap.poll()
            minDiff = minOf(minDiff, leftMinSums[i - third] - rightSum)
        }
        return minDiff
    }
}
