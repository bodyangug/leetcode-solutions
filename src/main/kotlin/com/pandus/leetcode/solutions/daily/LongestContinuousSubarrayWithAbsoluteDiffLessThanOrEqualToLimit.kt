package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import kotlin.Comparator
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxHeap = PriorityQueue { a: IntArray, b: IntArray -> b[0] - a[0] }
        val minHeap = PriorityQueue(
            Comparator.comparingInt { a: IntArray -> a[0] }
        )
        var left = 0
        var maxLength = 0
        for (right in nums.indices) {
            maxHeap.offer(intArrayOf(nums[right], right))
            minHeap.offer(intArrayOf(nums[right], right))

            // Check if the absolute difference between the maximum and minimum values
            // in the current window exceeds the limit
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                // Move the left pointer to the right until the condition is satisfied.
                // This ensures we remove the element causing the violation
                left = (min(maxHeap.peek()[1], minHeap.peek()[1]) + 1)

                // Remove elements from the heaps that are outside the current window
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll()
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll()
                }
            }

            maxLength = max(maxLength, (right - left + 1))
        }
        return maxLength
    }
}
