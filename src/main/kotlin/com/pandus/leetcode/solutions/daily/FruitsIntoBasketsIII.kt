package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/fruits-into-baskets-iii
class FruitsIntoBasketsIII {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val n = baskets.size
        val blockSize = sqrt(n.toDouble()).toInt().coerceAtLeast(1)
        val blockCount = (n + blockSize - 1) / blockSize
        val maxInBlock = IntArray(blockCount)

        // Initialize maxInBlock
        for (i in baskets.indices) {
            val blockIdx = i / blockSize
            maxInBlock[blockIdx] = max(maxInBlock[blockIdx], baskets[i])
        }

        var unplaced = 0

        for (fruit in fruits) {
            var placed = false

            for (blockIdx in 0 until blockCount) {
                if (maxInBlock[blockIdx] < fruit) continue

                val start = blockIdx * blockSize
                val end = min(start + blockSize, n)

                for (i in start until end) {
                    if (baskets[i] >= fruit) {
                        baskets[i] = 0
                        // Recalculate max for this block only
                        maxInBlock[blockIdx] = 0
                        for (j in start until end) {
                            maxInBlock[blockIdx] = max(maxInBlock[blockIdx], baskets[j])
                        }
                        placed = true
                        break
                    }
                }
                if (placed) break
            }
            if (!placed) unplaced++
        }
        return unplaced
    }
}
