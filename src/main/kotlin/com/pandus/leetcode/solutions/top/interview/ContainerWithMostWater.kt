package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/container-with-most-water
class ContainerWithMostWater {

    // Brute-force solution
    fun maxArea1(height: IntArray): Int {
        var maxArea = 0
        for (first in height.indices) {
            val firstH = height[first]
            for (last in height.size - 1 downTo first + 1) {
                val lastH = height[last]
                val a = minOf(lastH, firstH)
                val b = (last + 1) - (first + 1)
                maxArea = maxOf(a * b, maxArea)
            }
        }
        return maxArea
    }

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var low = 0
        var high = height.size - 1

        while (low < high) {
            val minH = minOf(height[low], height[high])
            val area = minH * (high - low)
            maxArea = maxOf(maxArea, area)

            if (height[low] < height[high]) {
                low++
            } else {
                high--
            }
        }
        return maxArea
    }
}
