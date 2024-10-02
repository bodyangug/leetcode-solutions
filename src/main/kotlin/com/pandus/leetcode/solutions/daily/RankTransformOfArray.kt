package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rank-transform-of-an-array
class RankTransformOfArray {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val numToRank = arr.distinct()
            .sorted()
            .withIndex()
            .associate { it.value to it.index + 1 }
        return arr.map { numToRank[it]!! }.toIntArray()
    }
}
