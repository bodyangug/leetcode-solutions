package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/neighboring-bitwise-xor
class NeighboringBitwiseXOR {
    fun doesValidArrayExist(derived: IntArray) =
        derived.reduce(Int::xor) < 1
}
