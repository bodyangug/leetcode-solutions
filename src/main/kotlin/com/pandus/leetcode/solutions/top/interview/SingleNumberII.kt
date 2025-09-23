package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/single-number-ii
class SingleNumberII {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        var count: Int
        var bitMask: Int
        for (i in 0 until 32){
            count = 0
            bitMask = 1 shl i

            nums.forEach {
                if(it and bitMask != 0) count++
            }

            if (count%3>0) result = result or bitMask
        }
        return result
    }
}
