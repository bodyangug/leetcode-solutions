package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.pow

// Reference: https://leetcode.com/problems/find-the-count-of-good-integers
class FindTheCountOfGoodIntegers {
    fun countGoodIntegers(n: Int, k: Int): Long {
        val dict = HashSet<String>()
        val halfLen = (n + 1) / 2
        val base = 10.0.pow(halfLen - 1).toInt()
        val end = 10.0.pow(halfLen).toInt()

        for (i in base until end) {
            val s = i.toString()
            val palindrome = if (n % 2 == 0)
                s + s.reversed()
            else
                s + s.dropLast(1).reversed()

            val palNum = palindrome.toLong()
            if (palNum % k == 0L) {
                val key = palindrome.toCharArray().sorted().joinToString("")
                dict.add(key)
            }
        }

        val factorial = LongArray(n + 1) { 1 }
        for (i in 1..n) {
            factorial[i] = factorial[i - 1] * i
        }

        var result = 0L
        for (sortedDigits in dict) {
            val count = IntArray(10)
            for (c in sortedDigits) {
                count[c - '0']++
            }

            var total = if (count[0] == n) 0L else (n - count[0]).toLong() * factorial[n - 1]
            for (x in count) {
                if (x > 1) total /= factorial[x]
            }
            result += total
        }
        return result
    }
}
