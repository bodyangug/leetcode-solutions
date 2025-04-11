package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-symmetric-integers
class CountSymmetricIntegers {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var count = 0
        for (num in low..high) {
            when (num) {
                in 10..99 -> if (num % 11 == 0) count++
                in 1000..9999 -> {
                    val d1 = num / 1000
                    val d2 = (num / 100) % 10
                    val d3 = (num / 10) % 10
                    val d4 = num % 10
                    if (d1 + d2 == d3 + d4) count++
                }
            }
        }
        return count
    }
}
