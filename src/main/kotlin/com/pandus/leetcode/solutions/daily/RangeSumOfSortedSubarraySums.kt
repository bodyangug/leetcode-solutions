package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums
class RangeSumOfSortedSubarraySums {

    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val storeSubarray = ArrayList<Int>()
        for (i in nums.indices) {
            var sum = 0
            for (j in i until nums.size) {
                sum += nums[j]
                storeSubarray.add(sum)
            }
        }
        storeSubarray.sort()

        var rangeSum = 0
        val mod = 1e9.toInt() + 7
        for (i in left - 1..<right) {
            rangeSum = (rangeSum + storeSubarray[i]) % mod
        }
        return rangeSum
    }
}