package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
class MaximumValueOfOrderedTripletI {
    fun maximumTripletValue(nums: IntArray): Long {
        val n = nums.size
        var res: Long = 0
        var imax: Long = 0
        var dmax: Long = 0
        for (k in 0..<n) {
            res = max(res, (dmax * nums[k])).toLong()
            dmax = max(dmax, (imax - nums[k])).toLong()
            imax = max(imax, nums[k].toLong())
        }
        return res
    }
}
