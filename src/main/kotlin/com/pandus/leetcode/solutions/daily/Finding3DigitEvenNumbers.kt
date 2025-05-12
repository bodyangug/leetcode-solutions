package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/finding-3-digit-even-numbers
class Finding3DigitEvenNumbers {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val result = mutableSetOf<Int>()
        val n = digits.size

        for (i in 0 until n) {
            if (digits[i] == 0) continue // Skip leading zero
            for (j in 0 until n) {
                if (j == i) continue
                for (k in 0 until n) {
                    if (k == i || k == j) continue
                    val num = digits[i] * 100 + digits[j] * 10 + digits[k]
                    if (num % 2 == 0) result.add(num)
                }
            }
        }
        return result.toSortedSet().toIntArray()
    }
}
