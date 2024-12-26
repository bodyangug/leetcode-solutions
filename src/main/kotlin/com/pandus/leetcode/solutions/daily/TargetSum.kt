package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/target-sum
class TargetSum {
    private val memo = mutableMapOf<Pair<Int, Int>, Int>()
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return dfs(0, target, nums)
    }
    private fun dfs(index: Int, currentTarget: Int, nums: IntArray): Int {
        val key = index to currentTarget
        memo[key]?.let { return it }
        if (index == nums.size) {
            return if (currentTarget == 0) 1 else 0
        }
        val ways = dfs(index + 1, currentTarget - nums[index], nums) +
                dfs(index + 1, currentTarget + nums[index], nums)
        memo[key] = ways
        return ways
    }
}
