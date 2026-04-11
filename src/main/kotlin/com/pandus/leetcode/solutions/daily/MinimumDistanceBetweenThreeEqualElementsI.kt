package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i
class MinimumDistanceBetweenThreeEqualElementsI {
    fun minimumDistance(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            map.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }
        var minDistance = Int.MAX_VALUE
        for (indices in map.values) {
            if (indices.size >= 3) {
                for (i in 0 until indices.size - 2) {
                    val distance = 2 * (indices[i + 2] - indices[i])
                    minDistance = minOf(minDistance, distance)
                }
            }
        }
        return if (minDistance == Int.MAX_VALUE) -1 else minDistance
    }
}
