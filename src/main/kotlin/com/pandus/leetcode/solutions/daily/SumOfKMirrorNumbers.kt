package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-k-mirror-numbers
class SumOfKMirrorNumbers {
    fun kMirror(k: Int, n: Int): Long {
        var currentBase = 1
        var count = 0
        var total: Long = 0

        while (count < n) {
            val nextBase = currentBase * 10

            for (isEven in listOf(false, true)) {
                for (half in currentBase until nextBase) {
                    val palindrome = buildPalindrome(half, isEven)
                    if (isKBasePalindrome(palindrome, k)) {
                        total += palindrome
                        count++
                        if (count == n) return total
                    }
                }
            }
            currentBase = nextBase
        }

        return total
    }

    private fun buildPalindrome(half: Int, isEven: Boolean): Long {
        var result = half.toLong()
        var mirror = if (isEven) half else half / 10

        while (mirror > 0) {
            result = result * 10 + mirror % 10
            mirror /= 10
        }

        return result
    }

    private fun isKBasePalindrome(num: Long, base: Int): Boolean {
        val digits = IntArray(64)
        var x = num
        var len = 0
        while (x > 0) {
            digits[len++] = (x % base).toInt()
            x /= base
        }

        for (i in 0 until len / 2) {
            if (digits[i] != digits[len - 1 - i]) return false
        }

        return true
    }
}
