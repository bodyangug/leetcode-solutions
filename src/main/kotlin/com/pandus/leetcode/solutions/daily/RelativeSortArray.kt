package com.pandus.leetcode.solutions.daily

import java.util.Arrays


//Reference: https://leetcode.com/problems/relative-sort-array
class RelativeSortArray {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val countMap = IntArray(1001) // Given constraints: 0 <= arr1[i], arr2[i] <= 1000
        val result = mutableListOf<Int>()

        // Count occurrences of each element in arr1
        for (num in arr1) {
            countMap[num]++
        }

        // Add elements from arr2 in the specified order
        for (num in arr2) {
            while (countMap[num] > 0) {
                result.add(num)
                countMap[num]--
            }
        }

        // Add remaining elements not in arr2, in ascending order
        for (i in countMap.indices) {
            while (countMap[i] > 0) {
                result.add(i)
                countMap[i]--
            }
        }

        // Convert result list to array
        return result.toIntArray()
    }

}