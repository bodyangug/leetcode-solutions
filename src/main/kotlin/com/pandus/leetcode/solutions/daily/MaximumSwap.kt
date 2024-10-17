package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-swap
class MaximumSwap {
    fun maximumSwap(num: Int): Int {
        val numStr = num.toString()
        val n = numStr.length
        var maxNum = num

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val numeral = numStr.toCharArray()

                val temp = numeral[i]
                numeral[i] = numeral[j]
                numeral[j] = temp

                val tempNum = String(numeral).toInt()
                maxNum = max(maxNum, tempNum)
            }
        }
        return maxNum
    }
}
