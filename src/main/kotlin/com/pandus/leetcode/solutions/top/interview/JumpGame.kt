package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/jump-game/description/
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var index = 0

        while (index < nums.size) {
            if (index == nums.size - 1) return true
            if (nums[index] == 0) return false

            var maxReach = 0
            var nextIndex = index
            for (i in 1..nums[index]) {
                if (index + i >= nums.size - 1) return true
                val reach = i + nums[index + i]
                if (reach > maxReach) {
                    maxReach = reach
                    nextIndex = index + i
                }
            }
            index = nextIndex
        }
        return false
    }
}
