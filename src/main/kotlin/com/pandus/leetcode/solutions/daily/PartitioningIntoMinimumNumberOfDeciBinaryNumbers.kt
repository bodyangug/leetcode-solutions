package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    fun minPartitions(n: String): Int {
        var maxDigit = 0
        for (char in n) {
            val digit = char - '0'
            if (digit > maxDigit) {
                maxDigit = digit
            }
        }
        return maxDigit
    }
}
