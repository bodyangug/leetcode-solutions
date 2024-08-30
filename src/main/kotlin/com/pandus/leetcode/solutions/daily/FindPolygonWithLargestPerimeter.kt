package com.pandus.leetcode.solutions.daily

import java.util.Arrays

// Reference:https://leetcode.com/problems/find-polygon-with-the-largest-perimeter
class FindPolygonWithLargestPerimeter {
    fun largestPerimeter(nums: IntArray): Long {
        Arrays.sort(nums)
        var previousElementsSum: Long = 0
        var ans: Long = -1
        for (num in nums) {
            if (num < previousElementsSum) {
                ans = num + previousElementsSum
            }
            previousElementsSum += num.toLong()
        }
        return ans
    }
}
