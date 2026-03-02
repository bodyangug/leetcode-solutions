package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid
class MinimumSwapsToArrangeBinaryGrid {
    fun minSwaps(grid: Array<IntArray>): Int {
        val n = grid.size
        val trailingZeros = IntArray(n)

        // Count trailing zeros for each row
        for (i in 0 until n) {
            var count = 0
            for (j in n - 1 downTo 0) {
                if (grid[i][j] == 0) {
                    count++
                } else {
                    break
                }
            }
            trailingZeros[i] = count
        }

        var swaps = 0

        // For each row, ensure it has enough trailing zeros
        for (i in 0 until n) {
            val requiredZeros = n - 1 - i
            if (trailingZeros[i] >= requiredZeros) {
                continue
            }

            var j = i + 1
            while (j < n && trailingZeros[j] < requiredZeros) {
                j++
            }

            if (j == n) {
                return -1 // No suitable row found
            }

            // Swap rows j down to i
            while (j > i) {
                val temp = trailingZeros[j]
                trailingZeros[j] = trailingZeros[j - 1]
                trailingZeros[j - 1] = temp
                j--
                swaps++
            }
        }
        return swaps
    }
}
