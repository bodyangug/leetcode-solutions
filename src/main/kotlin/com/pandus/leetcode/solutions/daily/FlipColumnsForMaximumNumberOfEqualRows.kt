package com.pandus.leetcode.solutions.daily

// Reference:https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows
class FlipColumnsForMaximumNumberOfEqualRows {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val countPerPattern = HashMap<List<Int>, Int>()

        for (binaryArray in matrix) {
            val pattern = binaryArray.toList()
            countPerPattern[pattern] = countPerPattern.getOrDefault(pattern, 0) + 1

            val complementaryPattern = List(pattern.size) { index -> 1 - pattern[index] }
            countPerPattern[complementaryPattern] = countPerPattern.getOrDefault(complementaryPattern, 0) + 1
        }
        return countPerPattern.values.max()
    }
}
