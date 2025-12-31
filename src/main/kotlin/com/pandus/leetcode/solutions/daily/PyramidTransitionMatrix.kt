package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/pyramid-transition-matrix
class PyramidTransitionMatrix {
    fun pyramidTransition(bottom: String, allowed: MutableList<String>): Boolean {
        val allowedPatterns = buildPatternMap(allowed)
        val memo = mutableMapOf<String, Boolean>()
        return canBuildPyramid(bottom, allowedPatterns, memo)
    }

    private fun buildPatternMap(allowed: List<String>): Map<String, List<Char>> {
        val patternMap = mutableMapOf<String, MutableList<Char>>()

        for (pattern in allowed) {
            val leftBlock = pattern[0]
            val rightBlock = pattern[1]
            val topBlock = pattern[2]
            val key = "$leftBlock$rightBlock"

            patternMap.getOrPut(key) { mutableListOf() }.add(topBlock)
        }

        return patternMap
    }

    private fun canBuildPyramid(
        currentRow: String,
        allowedPatterns: Map<String, List<Char>>,
        memo: MutableMap<String, Boolean>
    ): Boolean {
        if (currentRow.length == 1) {
            return true
        }

        if (currentRow in memo) {
            return memo[currentRow]!!
        }

        val result = buildNextRow(currentRow, 0, StringBuilder(), allowedPatterns, memo)
        memo[currentRow] = result

        return result
    }

    private fun buildNextRow(
        currentRow: String,
        position: Int,
        nextRow: StringBuilder,
        allowedPatterns: Map<String, List<Char>>,
        memo: MutableMap<String, Boolean>
    ): Boolean {
        if (position == currentRow.length - 1) {
            return canBuildPyramid(nextRow.toString(), allowedPatterns, memo)
        }

        val leftBlock = currentRow[position]
        val rightBlock = currentRow[position + 1]
        val key = "$leftBlock$rightBlock"

        val possibleTopBlocks = allowedPatterns[key] ?: return false

        for (topBlock in possibleTopBlocks) {
            nextRow.append(topBlock)

            if (buildNextRow(currentRow, position + 1, nextRow, allowedPatterns, memo)) {
                return true
            }
            nextRow.deleteCharAt(nextRow.length - 1)
        }
        return false
    }
}
