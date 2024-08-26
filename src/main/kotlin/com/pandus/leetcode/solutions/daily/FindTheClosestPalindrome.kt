package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

//Reference:https://leetcode.com/problems/find-the-closest-palindrome
class FindTheClosestPalindrome {
    // Convert to palindrome keeping first half constant.
    private fun convert(num: Long): Long {
        val s = num.toString()
        val n = s.length
        var l = (n - 1) / 2
        var r = n / 2
        val sArray = s.toCharArray()
        while (l >= 0) {
            sArray[r++] = sArray[l--]
        }
        return String(sArray).toLong()
    }

    // Find the previous palindrome, just smaller than n.
    private fun previousPalindrome(num: Long): Long {
        var left: Long = 0
        var right = num
        var ans = Long.MIN_VALUE
        while (left <= right) {
            val mid = (right - left) / 2 + left
            val palin = convert(mid)
            if (palin < num) {
                ans = palin
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }

    // Find the next palindrome, just greater than n.
    private fun nextPalindrome(num: Long): Long {
        var left = num
        var right = 1e18.toLong()
        var ans = Long.MIN_VALUE
        while (left <= right) {
            val mid = (right - left) / 2 + left
            val palin = convert(mid)
            if (palin > num) {
                ans = palin
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }

    fun nearestPalindromic(n: String): String {
        val num = n.toLong()
        val a = previousPalindrome(num)
        val b = nextPalindrome(num)
        if (abs((a - num)) <= abs((b - num))) {
            return a.toString()
        }
        return b.toString()
    }
}