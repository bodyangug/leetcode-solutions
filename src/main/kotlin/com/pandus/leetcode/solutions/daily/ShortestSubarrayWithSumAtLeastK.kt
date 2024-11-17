package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import kotlin.math.min

// Reference: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
class ShortestSubarrayWithSumAtLeastK {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var sum = 0L
        var res = nums.size + 1
        val q = PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
        q.add(0L to -1)
        for ((i, n) in nums.withIndex()) {
            sum += n
            while (q.size > 0 && sum - q.peek().first >= k)
                res = min(res, i - q.poll().second)
            q += sum to i
        }
        return if (res > nums.size) -1 else res
    }
}
