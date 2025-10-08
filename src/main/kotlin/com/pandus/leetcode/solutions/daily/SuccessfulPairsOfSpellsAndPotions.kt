package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/successful-pairs-of-spells-and-potions
class SuccessfulPairsOfSpellsAndPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val sortedPotions = potions.sorted()
        val n = sortedPotions.size
        return spells.map { spell ->
            var left = 0
            var right = n
            while (left < right) {
                val mid = left + (right - left) / 2
                if (spell.toLong() * sortedPotions[mid] >= success) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            n - left
        }.toIntArray()
    }
}
