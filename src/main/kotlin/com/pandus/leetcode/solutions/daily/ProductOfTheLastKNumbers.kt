package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/product-of-the-last-k-numbers
class ProductOfTheLastKNumbers {
    private val product = mutableListOf<Int>()
    private var latestZero = -1

    fun add(num: Int) {
        if (product.isEmpty() || product.last() == 0) {
            product.add(num)
        } else {
            product.add(product.last() * num)
        }
        if (num == 0) {
            latestZero = product.size - 1
        }
    }

    fun getProduct(k: Int): Int {
        val j = product.size - 1
        val i = j - k + 1
        return if (latestZero < i) {
            if (i == 0 || latestZero == i - 1) product[j]
            else product[j] / product[i - 1]
        } else 0
    }
}
