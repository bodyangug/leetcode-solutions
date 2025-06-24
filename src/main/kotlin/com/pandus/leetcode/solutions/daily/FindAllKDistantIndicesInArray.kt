package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array
class FindAllKDistantIndicesInArray {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val keyPositions = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] == key) {
                keyPositions.add(i)
            }
        }

        val res = mutableListOf<Int>()
        var j = 0
        for (i in nums.indices) {
            while (j < keyPositions.size && keyPositions[j] < i - k) {
                j++
            }
            if (j < keyPositions.size && abs(keyPositions[j] - i) <= k) {
                res.add(i)
            }
        }
        return res
    }
}
