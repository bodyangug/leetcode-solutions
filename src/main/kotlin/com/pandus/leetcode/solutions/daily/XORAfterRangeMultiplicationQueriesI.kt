package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/xor-after-range-multiplication-queries-i
class XORAfterRangeMultiplicationQueriesI {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007
        for (query in queries) {
            var idx = query[0]
            while (idx <= query[1]) {
                nums[idx] = (nums[idx].toLong() * query[3] % mod).toInt()
                idx += query[2]
            }
        }
        var result = 0
        for (num in nums) {
            result = result xor num
        }
        return result
    }
}
