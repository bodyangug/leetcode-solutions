package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/single-number-iii
class SingleNumberIII {
    fun singleNumber(nums: IntArray): IntArray {
        val hashmap: MutableMap<Int, Int> = HashMap()
        for (n in nums) hashmap[n] = hashmap.getOrDefault(n, 0) + 1
        val output = IntArray(2)
        var idx = 0
        for ((key, value) in hashmap)
            if (value == 1)
                output[idx++] = key
        return output
    }
}