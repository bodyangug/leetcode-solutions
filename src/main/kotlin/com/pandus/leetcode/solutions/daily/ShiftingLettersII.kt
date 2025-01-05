package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/shifting-letters-ii
class ShiftingLettersII {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val diffArray = IntArray(n)

        for ((start, end, direction) in shifts) {
            val shiftValue = if (direction == 1) 1 else -1
            diffArray[start] += shiftValue
            if (end + 1 < n) {
                diffArray[end + 1] -= shiftValue
            }
        }

        val result = StringBuilder()
        var cumulativeShift = 0

        for (i in s.indices) {
            cumulativeShift = (cumulativeShift + diffArray[i]) % 26
            val newChar = ((s[i] - 'a' + cumulativeShift + 26) % 26 + 'a'.code).toChar()
            result.append(newChar)
        }
        return result.toString()
    }
}
