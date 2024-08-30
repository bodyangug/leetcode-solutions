package com.pandus.leetcode.solutions.daily

// Reference:https://leetcode.com/problems/divide-array-into-arrays-with-max-difference
class DivideArrayIntoArraysWithMaxDifference {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()
        val chunks = nums
            .toList()
            .chunked(3)
        if (chunks.any { chunk -> chunk.maxOrNull()!! - chunk.minOrNull()!! > k }) {
            return emptyArray()
        }
        return chunks.map { it.toIntArray() }.toTypedArray()
    }
}
