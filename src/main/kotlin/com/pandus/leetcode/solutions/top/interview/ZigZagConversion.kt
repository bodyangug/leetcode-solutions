package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/zigzag-conversion/
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || s.length == 1) return s
        val lastRow = numRows - 1
        val iterationSteps = numRows * 2 - 2

        fun getNextIdx(idx: Int): Int {
            val stepIdx = idx % iterationSteps
            return idx + when {
                idx % lastRow == 0 -> iterationSteps
                stepIdx < lastRow -> (lastRow - stepIdx) * 2
                else -> (iterationSteps - stepIdx) * 2
            }
        }

        val result = StringBuilder()
        for (i in 0..lastRow) {
            var idx = i
            while (idx < s.length) {
                result.append(s[idx])
                idx = getNextIdx(idx)
            }
        }
        return result.toString()
    }
}