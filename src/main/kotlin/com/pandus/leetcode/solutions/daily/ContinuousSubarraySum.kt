package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/continuous-subarray-sum
class ContinuousSubarraySum {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var prefixMod = 0
        val modSeen = HashMap<Int, Int>()
        modSeen[0] = -1

        for (i in nums.indices) {
            prefixMod = (prefixMod + nums[i]) % k
            if (modSeen.containsKey(prefixMod)) {
                if (i - modSeen[prefixMod]!! > 1) {
                    return true
                }
            } else {
                modSeen[prefixMod] = i
            }
        }
        return false
    }
}
