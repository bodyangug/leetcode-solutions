package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-divisible-digit-product-i
class SmallestDivisibleDigitProductI {
    fun smallestNumber(n: Int, t: Int): Int {
        var n = n
        while (!check(n, t)) {
            n++
        }
        return n
    }

    private fun check(n: Int, t: Int): Boolean {
        var product = 1
        var n = n
        while (n > 0) {
            product *= n % 10
            n /= 10
            if (product == 0) {
                break
            }
        }
        return product % t == 0
    }
}
