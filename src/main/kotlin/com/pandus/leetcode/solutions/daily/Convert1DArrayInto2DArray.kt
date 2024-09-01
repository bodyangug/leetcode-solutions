package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/convert-1d-array-into-2d-array
class Convert1DArrayInto2DArray {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (m * n != original.size) {
            return Array(0) { IntArray(0) }
        }
        val resultArray = Array(m) { IntArray(n) }
        for (i in original.indices) {
            resultArray[i / n][i % n] = original[i]
        }
        return resultArray
    }
}
