package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-product-of-two-digits
class MaximumProductOfTwoDigits {
    fun maxProduct(n: Int): Int {
        var maxProduct = 0
        var num = n
        while (num > 0) {
            val digit1 = num % 10
            var tempNum = num / 10
            while (tempNum > 0) {
                val digit2 = tempNum % 10
                val product = digit1 * digit2
                if (product > maxProduct) {
                    maxProduct = product
                }
                tempNum /= 10
            }
            num /= 10
        }
        return maxProduct
    }
}
