package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/contiguous-array
class ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf(0 to -1)
        return nums.foldIndexed(0 to 0) { i, (count, maxLen), num ->
            val newCount = count + if (num == 1) 1 else -1
            val newMax = max(maxLen, i - (map[newCount] ?: i))
            map.getOrPut(newCount) { i }
            newCount to newMax
        }.second
    }
}
