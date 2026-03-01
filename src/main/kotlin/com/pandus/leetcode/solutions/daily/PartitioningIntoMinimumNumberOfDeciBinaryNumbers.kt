package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    // A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
    //Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
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
