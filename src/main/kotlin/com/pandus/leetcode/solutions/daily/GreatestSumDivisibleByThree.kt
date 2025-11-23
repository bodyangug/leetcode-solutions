package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/greatest-sum-divisible-by-three
class GreatestSumDivisibleByThree {
    fun maxSumDivThree(nums: IntArray): Int {
        // Group numbers by remainder when divided by 3
        val remainderGroups = Array(3) { mutableListOf<Int>() }

        nums.forEach { num ->
            remainderGroups[num % 3].add(num)
        }

        // Sort groups with remainder 1 and 2 in descending order
        val remainder1 = remainderGroups[1].sortedDescending()
        val remainder2 = remainderGroups[2].sortedDescending()

        val totalSum = nums.sum()

        val toRemove = when (totalSum % 3) {
            0 -> 0
            1 -> minOf(
                remainder1.lastOrNull() ?: Int.MAX_VALUE,
                remainder2.takeLast(2).sum().takeIf { remainder2.size >= 2 } ?: Int.MAX_VALUE
            )

            else -> minOf(
                remainder2.lastOrNull() ?: Int.MAX_VALUE,
                remainder1.takeLast(2).sum().takeIf { remainder1.size >= 2 } ?: Int.MAX_VALUE
            )
        }
        return totalSum - toRemove
    }
}
