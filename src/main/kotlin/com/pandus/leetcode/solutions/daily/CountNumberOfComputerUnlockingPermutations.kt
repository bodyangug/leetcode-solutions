package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations
class CountNumberOfComputerUnlockingPermutations {
    fun countPermutations(complexity: IntArray): Int {
        val n = complexity.size
        for (i in 1..<n) {
            if (complexity[i] <= complexity[0]) {
                return 0
            }
        }

        var ans = 1
        val mod = 1000000007
        for (i in 2..<n) {
            ans = ((ans.toLong() * i) % mod).toInt()
        }
        return ans
    }
}
