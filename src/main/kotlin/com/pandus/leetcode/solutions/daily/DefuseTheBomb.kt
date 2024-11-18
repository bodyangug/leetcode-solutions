package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/defuse-the-bomb
class DefuseTheBomb {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val n = code.size
        val result = IntArray(n)
        if (k == 0) return IntArray(n)

        val extendedCode = code + code
        var start = if (k > 0) 1 else n + k
        var end = if (k > 0) k else n - 1

        var sum = (start..end).sumOf { extendedCode[it] }
        for (i in 0 until n) {
            result[i] = sum
            sum -= extendedCode[start]
            start++
            end++
            sum += extendedCode[end]
        }
        return result
    }
}
