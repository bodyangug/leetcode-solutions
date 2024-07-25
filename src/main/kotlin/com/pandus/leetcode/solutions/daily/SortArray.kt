package com.pandus.leetcode.solutions.daily

import kotlin.math.floor

//Reference: https://leetcode.com/problems/sort-an-array
class SortArray {
    fun sortArray(nums: IntArray): IntArray {
        sortArrayPiece(nums, 0, nums.size - 1)
        return nums
    }

    private fun sortArrayPiece(arr: IntArray, startIndex: Int, endIndex: Int) {
        val pieceSize = endIndex - startIndex + 1
        if (pieceSize == 1) {
            return //Single element piece case
        }
        val middleElementIndex = floor((startIndex + endIndex) / 2.0).toInt()
        sortArrayPiece(arr, startIndex, middleElementIndex)
        sortArrayPiece(arr, middleElementIndex + 1, endIndex)
        merge(arr, startIndex, middleElementIndex, endIndex)
    }

    private fun merge(arr: IntArray, startIndex: Int, middleIndex: Int, endIndex: Int) {
        val leftArray = arr.copyOfRange(startIndex, middleIndex + 1) //Left bound is exclusive
        val rightArray = arr.copyOfRange(middleIndex + 1, endIndex + 1) // Right - inclusive
        var i = 0
        var j = 0
        for (k in startIndex..endIndex) {
            if ((i <= leftArray.size - 1) &&
                ((j >= rightArray.size) || (leftArray[i] <= rightArray[j]))
            ) {
                arr[k] = leftArray[i]
                i++
            } else {
                arr[k] = rightArray[j]
                j++
            }
        }
    }
}