package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.pow

// Reference: https://leetcode.com/problems/longest-square-streak-in-an-array
class LongestSquareStreakInArray {
    fun longestSquareStreak(nums: IntArray): Int {
        var maxLength = -1
        val originalSet = nums.toSet()
        for (element in nums) {
            var tmp = 1
            for (j in 1 until 5) {
                if (originalSet.contains(element.toFloat().pow(2f.pow(j)).toInt())) {
                    tmp++
                } else break
            }
            if (tmp > 1) maxLength = max(maxLength, tmp)
        }
        return maxLength
    }
}
