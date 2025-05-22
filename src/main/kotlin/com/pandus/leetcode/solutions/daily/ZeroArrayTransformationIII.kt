package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/zero-array-transformation-iii
class ZeroArrayTransformationIII {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
        queries.sortBy { it[0] }
        val heap = PriorityQueue<Int>(compareByDescending { it })
        val deltaArray = IntArray(nums.size + 1)
        var operations = 0
        var j = 0

        for (i in nums.indices) {
            operations += deltaArray[i]

            // Add all queries that start at index i
            while (j < queries.size && queries[j][0] == i) {
                heap.add(queries[j][1])
                j++
            }

            // Use available operations to meet nums[i] requirement
            while (operations < nums[i] && heap.isNotEmpty() && heap.peek() >= i) {
                operations++
                deltaArray[heap.poll() + 1] -= 1
            }

            if (operations < nums[i]) return -1
        }
        return heap.size
    }
}
