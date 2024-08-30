package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/fraction-addition-and-subtraction
class FractionAdditionAndSubtraction {
    fun fractionAddition(expression: String): String {
        var num = 0
        var denom = 1
        var i = 0
        val n = expression.length

        while (i < n) {
            // Parse the sign if present
            var isNegative = false
            if (expression[i] == '-' || expression[i] == '+') {
                if (expression[i] == '-') isNegative = true
                i++
            }

            // Parse numerator
            var currNum = 0
            while (i < n && Character.isDigit(expression[i])) {
                currNum = currNum * 10 + (expression[i].code - '0'.code)
                i++
            }
            if (isNegative) currNum = -currNum

            // Skip the '/'
            i++

            // Parse denominator
            var currDenom = 0
            while (i < n && Character.isDigit(expression[i])) {
                currDenom = currDenom * 10 + (expression[i].code - '0'.code)
                i++
            }

            // Combine fractions
            num = num * currDenom + currNum * denom
            denom *= currDenom
            val gcd = abs(findGCD(num, denom))
            num /= gcd
            denom /= gcd
        }

        return "$num/$denom"
    }

    private fun findGCD(a: Int, b: Int): Int {
        return if (b == 0) a else findGCD(b, a % b)
    }
}
