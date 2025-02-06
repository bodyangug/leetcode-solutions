package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/tuple-with-same-product
class TupleWithSameProduct {
    fun tupleSameProduct(nums: IntArray): Int {
        val f = HashMap<Int, Int>()
        var res = 0
        for (i in nums.indices)
            for (j in i + 1..<nums.size) {
                val ab = nums[i] * nums[j]
                res += 8 * (f[ab] ?: 0)
                f[ab] = 1 + (f[ab] ?: 0)
            }
        return res
    }
}
