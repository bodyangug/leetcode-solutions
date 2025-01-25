package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements
class MakeLexicographicallySmallestArrayBySwappingElements {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val ix = nums.indices.sortedBy { nums[it] }
        var j = 0
        val qi = PriorityQueue<Int>()
        val res = IntArray(nums.size)
        for (i in ix.indices) {
            qi += ix[i]
            if (i == ix.size - 1 || nums[ix[i + 1]] - nums[ix[i]] > limit)
                while (qi.size > 0) res[qi.poll()] = nums[ix[j++]]
        }
        return res
    }
}
