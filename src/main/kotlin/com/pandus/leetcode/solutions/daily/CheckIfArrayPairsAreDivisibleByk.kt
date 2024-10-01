package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
class CheckIfArrayPairsAreDivisibleByk {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val count = IntArray(k)
        for (num in arr) {
            val mod = ((num % k) + k) % k
            count[mod]++
        }

        for (i in 1 until k) {
            if (count[i] != count[k - i]) return false
        }

        if (count[0] % 2 != 0) return false

        if (k % 2 == 0 && count[k / 2] % 2 != 0) return false

        return true
    }
}
