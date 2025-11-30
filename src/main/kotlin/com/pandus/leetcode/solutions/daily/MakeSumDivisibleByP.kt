package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/make-sum-divisible-by-p
class MakeSumDivisibleByP {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size
        var totalSum = 0L
        for (num in nums) {
            totalSum += num
        }

        val target = (totalSum % p).toInt()
        if (target == 0) return 0

        val remainderMap = HashMap<Int, Int>()
        remainderMap[0] = -1

        var prefixSum = 0L
        var minLength = n

        for (i in nums.indices) {
            prefixSum += nums[i]
            val currentRemainder = (prefixSum % p).toInt()
            val neededRemainder = ((currentRemainder - target + p) % p)
            if (remainderMap.containsKey(neededRemainder)) {
                val prevIndex = remainderMap[neededRemainder]!!
                minLength = minOf(minLength, i - prevIndex)
            }
            remainderMap[currentRemainder] = i
        }

        return if (minLength == n) -1 else minLength
    }
}
