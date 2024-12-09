package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/special-array-ii
class SpecialArrayII {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val inds = queries.indices.sortedBy { queries[it][1] }
        var j = 0
        var k = 0
        val res = BooleanArray(queries.size)
        for (i in nums.indices) {
            if (i > 0 && nums[i] % 2 == nums[i - 1] % 2) j = i
            while (k < queries.size && queries[inds[k]][1] <= i)
                res[inds[k]] = queries[inds[k++]][0] >= j
        }
        return res
    }
}
