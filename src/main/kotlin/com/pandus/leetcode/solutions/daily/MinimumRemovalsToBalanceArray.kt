package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-removals-to-balance-array
class MinimumRemovalsToBalanceArray {
    fun minRemoval(nums: IntArray, k: Int): Int {
        val n = nums.size
        Arrays.sort(nums)

        var ans = n
        var right = 0

        for (left in 0..<n) {
            while (right < n && nums[right] <= nums[left].toLong() * k) {
                right++
            }
            ans = min(ans, n - (right - left))
        }

        return ans
    }
}
