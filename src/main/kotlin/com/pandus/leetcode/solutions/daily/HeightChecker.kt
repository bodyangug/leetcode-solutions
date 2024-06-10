package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/height-checker
class HeightChecker {
    fun heightChecker(heights: IntArray) = heights.sorted().let { expectedHeight ->
        expectedHeight.indices.count { index ->
            expectedHeight[index] != heights[index]
        }
    }
}