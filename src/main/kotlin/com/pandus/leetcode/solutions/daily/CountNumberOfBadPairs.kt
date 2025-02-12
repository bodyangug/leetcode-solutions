package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-number-of-bad-pairs
class CountNumberOfBadPairs {
    fun countBadPairs(nums: IntArray): Long {
        var badPairs: Long = 0
        val diffCount: MutableMap<Int, Int> = HashMap()

        for (pos in nums.indices) {
            val diff = pos - nums[pos]
            val goodPairsCount = diffCount.getOrDefault(diff, 0)
            badPairs += pos - goodPairsCount
            diffCount[diff] = goodPairsCount + 1
        }
        return badPairs
    }
}
