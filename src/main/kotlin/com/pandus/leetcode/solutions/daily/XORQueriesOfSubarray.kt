package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/xor-queries-of-a-subarray
class XORQueriesOfSubarray {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val result = ArrayList<Int>()
        for (query in queries) {
            val leftI = query[0]
            val rightI = query[1]
            var x = 0
            for (i in leftI..rightI) {
                x = x xor arr[i]
            }
            result.add(x)
        }
        return result.toIntArray()
    }
}
