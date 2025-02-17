package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/letter-tile-possibilities
class LetterTilePossibilities {
    fun numTilePossibilities(tiles: String): Int {
        val freq = IntArray(26) // Stores letter frequencies (assuming only uppercase letters)
        for (c in tiles) freq[c - 'A']++

        return dfs(freq)
    }

    private fun dfs(freq: IntArray): Int {
        var count = 0
        for (i in freq.indices) {
            if (freq[i] > 0) {
                freq[i]--
                count += 1 + dfs(freq)
                freq[i]++ // Backtrack
            }
        }
        return count
    }
}
