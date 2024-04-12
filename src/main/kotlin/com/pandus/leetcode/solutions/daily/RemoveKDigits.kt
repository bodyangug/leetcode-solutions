package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/remove-k-digits
class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {
        var k = k
        val stack = LinkedList<Char>()

        for (digit in num.toCharArray()) {
            while (stack.size > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast()
                k -= 1
            }
            stack.addLast(digit)
        }

        repeat(k) {
            stack.removeLast()
        }

        val leadingZerosRemoved = stack.dropWhile { it == '0' }
        return if (leadingZerosRemoved.isEmpty()) "0" else leadingZerosRemoved.joinToString("")
    }
}
