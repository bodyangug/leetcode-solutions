package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/fruits-into-baskets-ii
class FruitsIntoBasketsII {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        var count = 0
        val n = baskets.size
        for (fruit in fruits) {
            var unset = 1
            for (i in 0..<n) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0
                    unset = 0
                    break
                }
            }
            count += unset
        }
        return count
    }
}
