package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/house-robber-iv
class HouseRobberIV {
    fun minCapability(nums: IntArray, k: Int): Int {
        var minReward = 1
        var maxReward = nums.max()
        val totalHouses = nums.size

        while (minReward < maxReward) {
            val midReward = (minReward + maxReward) / 2
            var possibleThefts = 0

            var index = 0
            while (index < totalHouses) {
                if (nums[index] <= midReward) {
                    possibleThefts += 1
                    index++
                }
                ++index
            }

            if (possibleThefts >= k) maxReward = midReward
            else minReward = midReward + 1
        }
        return minReward
    }
}
