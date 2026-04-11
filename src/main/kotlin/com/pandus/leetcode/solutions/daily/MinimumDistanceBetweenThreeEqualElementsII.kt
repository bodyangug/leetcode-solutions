package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii
class MinimumDistanceBetweenThreeEqualElementsII {
    fun minimumDistance(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            map.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }
        var ans = Int.MAX_VALUE
        for (list in map.values) {
            if (list.size >= 3) {
                for (i in 0..list.size - 3) {
                    val j = i + 1
                    val k = i + 2
                    ans = minOf(ans, list[k] - list[i] + list[k] - list[j] + list[j] - list[i])
                }
            }
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}
