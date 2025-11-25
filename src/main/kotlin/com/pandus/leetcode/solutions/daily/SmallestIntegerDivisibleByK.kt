package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-integer-divisible-by-k
class SmallestIntegerDivisibleByK {
    fun smallestRepunitDivByK(k: Int): Int {
        var remainder = 0
        for (lengthN in 1..k) {
            remainder = (remainder * 10 + 1) % k
            if (remainder == 0) {
                return lengthN
            }
        }
        return -1
    }
}
