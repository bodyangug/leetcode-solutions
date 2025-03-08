package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var numWhites = blocks.take(k).count { it == 'W' }
        var minRecolors = numWhites
        for (i in k until blocks.length) {
            if (blocks[i - k] == 'W') numWhites--
            if (blocks[i] == 'W') numWhites++
            minRecolors = minOf(minRecolors, numWhites)
        }
        return minRecolors
    }
}
