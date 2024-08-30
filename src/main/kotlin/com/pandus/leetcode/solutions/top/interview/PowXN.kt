package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/powx-n
class PowXN {

    private fun binaryExp(x: Double, n: Long): Double {
        var x = x
        var n1 = n
        if (n1 == 0L) {
            return 1.0
        }

        // Handle case where, n < 0.
        if (n1 < 0) {
            n1 *= -1
            x = 1.0 / x
        }

        // Perform Binary Exponentiation.
        var result = 1.0
        while (n1 != 0L) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if (n1 % 2 == 1L) {
                result *= x
                n1 -= 1
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x *= x
            n1 /= 2
        }
        return result
    }

    fun myPow(x: Double, n: Int): Double {
        return binaryExp(x, n.toLong())
    }
}
