package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero
class LargestCombinationWithBitwiseANDGreaterThanZero {
    fun largestCombination(candidates: IntArray) =
        (0..31).maxOf { bit ->
            candidates.sumOf { (it shr bit) and 1 }
        }
}
