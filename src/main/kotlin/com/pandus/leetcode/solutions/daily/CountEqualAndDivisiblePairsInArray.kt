package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array
class CountEqualAndDivisiblePairsInArray {
    fun countPairs(nums: IntArray, k: Int): Int {
        val indexMap = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            indexMap.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }

        var res = 0
        for ((_, indices) in indexMap) {
            val size = indices.size
            for (i in 0 until size - 1) {
                for (j in i + 1 until size) {
                    if ((indices[i] * indices[j]) % k == 0) {
                        res++
                    }
                }
            }
        }

        return res
    }
}
