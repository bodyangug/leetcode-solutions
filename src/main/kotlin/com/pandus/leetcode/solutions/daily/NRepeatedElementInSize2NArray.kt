package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/n-repeated-element-in-size-2n-array
class NRepeatedElementInSize2NArray {
    fun repeatedNTimes(nums: IntArray): Int {
        val requiredRep = nums.size / 2
        val countMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
            if (countMap[num] == requiredRep) {
                return num
            }
        }
        throw IllegalArgumentException("No element found that is repeated N times")
    }
}
