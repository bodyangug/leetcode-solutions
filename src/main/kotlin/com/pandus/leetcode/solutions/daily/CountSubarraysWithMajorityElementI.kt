package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-subarrays-with-majority-element-i
class CountSubarraysWithMajorityElementI {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        var count = 0
        var balance = 0
        val balanceCountMap = mutableMapOf<Int, Int>()
        balanceCountMap[0] = 1 // Base case: empty prefix

        for (num in nums) {
            if (num == target) {
                balance++
            } else {
                balance--
            }

            // We want to count subarrays where the balance is positive
            // This means we need to find how many previous balances are less than the current balance
            for ((prevBalance, prevCount) in balanceCountMap) {
                if (prevBalance < balance) {
                    count += prevCount
                }
            }

            // Update the count of the current balance in the map
            balanceCountMap[balance] = balanceCountMap.getOrDefault(balance, 0) + 1
        }

        return count
    }
}
