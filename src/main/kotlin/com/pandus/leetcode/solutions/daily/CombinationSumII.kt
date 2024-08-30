package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/combination-sum-ii
class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort() // Sort to make it easier to skip duplicates
        backtrack(candidates, target, 0, mutableListOf(), result)
        return result
    }

    private fun backtrack(
        candidates: IntArray,
        target: Int,
        start: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            result.add(ArrayList(current)) // Found a valid combination
            return
        }

        for (i in start until candidates.size) {
            if (i > start && candidates[i] == candidates[i - 1]) continue // Skip duplicates

            val newTarget = target - candidates[i]
            if (newTarget < 0) break // No need to continue if the target is negative

            current.add(candidates[i]) // Choose the candidate
            backtrack(candidates, newTarget, i + 1, current, result) // Explore further
            current.removeAt(current.size - 1) // Undo the choice (backtrack)
        }
    }
}
