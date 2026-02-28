package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits
class SortIntegersByTheNumberOf1Bits {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(compareBy({ Integer.bitCount(it) }, { it })).toIntArray()
    }
}
