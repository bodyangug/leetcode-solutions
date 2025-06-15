package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer
class MaxDifferenceYouCanGetFromChangingInteger {
    fun maxDiff(num: Int): Int {
        var minNum = num
        var maxNum = num
        val numStr = num.toString()
        for (x in '0'..'9') {
            for (y in '0'..'9') {
                if (x == y) continue
                val replaced = numStr.replace(x, y)
                if (replaced[0] != '0') {
                    val replacedInt = replaced.toInt()
                    minNum = minOf(minNum, replacedInt)
                    maxNum = maxOf(maxNum, replacedInt)
                }
            }
        }
        return maxNum - minNum
    }
}
