package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/replace-non-coprime-numbers-in-array
class ReplaceNonCoprimeNumbersInArray {
    fun replaceNonCoprimes(nums: IntArray): List<Int> {
        val list = nums.toMutableList()
        var index = 0

        while (index < list.size - 1) {
            val a = list[index]
            val b = list[index + 1]
            val gcd = nod(a, b)
            if (gcd > 1) {
                val lcm = nok(a, b)
                list[index] = lcm
                list.removeAt(index + 1)
                if (index > 0) {
                    index--
                }
            } else {
                index++
            }
        }
        return list
    }

    private fun nod(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    private fun nok(a: Int, b: Int): Int {
        return a / nod(a, b) * b
    }
}
