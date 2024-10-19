package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string
class FindKthBitInNthBinaryString {
    fun findKthBit(n: Int, k: Int): Char {
        val sequence = StringBuilder("0")
        var i = 1
        while (i < n && k > sequence.length) {
            sequence.append('1')
            for (j in sequence.length - 2 downTo 0) {
                val invertedBit = if ((sequence[j] == '1')) '0' else '1'
                sequence.append(invertedBit)
            }
            ++i
        }
        return sequence[k - 1]
    }
}
