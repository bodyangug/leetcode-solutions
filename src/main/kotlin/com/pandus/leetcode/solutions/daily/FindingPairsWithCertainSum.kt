package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/finding-pairs-with-a-certain-sum
class FindingPairsWithCertainSum(nums1: IntArray, nums2: IntArray) {
    private val nums1: IntArray = nums1
    private val nums2: IntArray = nums2
    private val cnt: MutableMap<Int, Int> = HashMap()

    init {
        for (num in nums2) {
            cnt[num] = cnt.getOrDefault(num, 0) + 1
        }
    }

    fun add(index: Int, value: Int) {
        val oldVal = nums2[index]
        cnt[oldVal] = cnt.getOrDefault(oldVal, 0) - 1
        nums2[index] += value
        cnt[nums2[index]] = cnt.getOrDefault(nums2[index], 0) + 1
    }

    fun count(tot: Int): Int {
        var result = 0
        for (num in nums1) {
            val complement = tot - num
            result += cnt.getOrDefault(complement, 0)
        }
        return result
    }
}
