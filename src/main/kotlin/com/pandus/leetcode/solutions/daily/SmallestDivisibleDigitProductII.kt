package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/smallest-divisible-digit-product-ii
class SmallestDivisibleDigitProductII {
    fun smallestNumber(num: String, t: Long): String {
        var r = t
        for (p in longArrayOf(2, 3, 5, 7)) {
            while ((r % p) == 0L) {
                r /= p
            }
        }
        if (r != 1L) {
            return "-1"
        }

        val n = num.length
        val need = LongArray(n + 1)
        need[0] = t
        var firstZero = n
        for (i in 0..<n) {
            if (num[i] == '0') {
                firstZero = i
                break
            }
            need[i + 1] = need[i] / gcd(need[i], num[i].digitToInt().toLong())
        }

        if (firstZero == n && need[n] == 1L) {
            return num
        }

        for (i in (min(firstZero, n - 1) downTo 0)) {
            for (d in num[i].digitToInt() + 1..9) {
                val rest = need[i] / gcd(need[i], d.toLong())
                val tail = minimalFill(n - 1 - i, rest)
                if (tail != null) {
                    return num.substring(0, i) + d + tail
                }
            }
        }

        val len = maxOf(n + 1, minDigits(t))
        return minimalFill(len, t)!!
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) {
            a
        } else {
            gcd(b, a % b)
        }
    }

    private fun minDigits(need: Long): Int {
        var x = need
        var count = 0
        for (d in 9 downTo 2) {
            while ((x % d) == 0L) {
                x /= d
                count++
            }
        }
        return count
    }

    private fun minimalFill(len: Int, need: Long): String? {
        val digits = ArrayList<Int>()
        var x = need
        for (d in 9 downTo 2) {
            while ((x % d) == 0L) {
                x /= d
                digits.add(d)
            }
        }
        if (digits.size > len) {
            return null
        }
        digits.sort()
        val sb = StringBuilder()
        repeat(len - digits.size) { sb.append('1') }
        for (d in digits) {
            sb.append(d)
        }
        return sb.toString()
    }
}
