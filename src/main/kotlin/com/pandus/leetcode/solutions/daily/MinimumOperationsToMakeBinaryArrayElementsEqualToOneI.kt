package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    fun minOperations(nums: IntArray): Int {
        val flipQueue: Deque<Int> = ArrayDeque()
        var count = 0

        for (i in nums.indices) {
            while (!flipQueue.isEmpty() && i > flipQueue.peekFirst() + 2) {
                flipQueue.pollFirst()
            }
            if ((nums[i] + flipQueue.size) % 2 == 0) {
                if (i + 2 >= nums.size) {
                    return -1
                }
                count++
                flipQueue.offerLast(i)
            }
        }
        return count
    }
}
