package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sequential-digits
class SequentialDigits {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val sequence = "123456789"
        val ans = mutableListOf<Int>()

        fun findNumber(idx: Int, minSizeOfWindow: Int) {
            if (minSizeOfWindow > high.toString().length) return
            var tempIdx = idx
            while (tempIdx + minSizeOfWindow - 1 < sequence.length) {
                sequence.substring(tempIdx, tempIdx + minSizeOfWindow)
                    .toInt()
                    .takeIf { it in low..high }
                    ?.let { ans.add(it) }
                tempIdx++
            }
            findNumber(idx, minSizeOfWindow + 1)
        }
        findNumber(0, low.toString().length)
        return ans
    }
}
