package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/pascals-triangle
class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = mutableListOf<MutableList<Int>>()
        for (i in 0 until numRows) {
            val row = MutableList(i + 1) { 1 } // all elements initialized as 1
            if (i >= 2) {
                val prev = triangle[i - 1]
                for (j in 1 until i) {
                    row[j] = prev[j - 1] + prev[j]
                }
            }
            triangle.add(row)
        }
        return triangle
    }
}
