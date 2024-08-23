package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/number-complement
class NumberComplement {
    fun findComplement(num: Int): Int {
        val bitLength = Integer.toBinaryString(num).length
        val mask = (1 shl bitLength) - 1
        return num xor mask
    }
}