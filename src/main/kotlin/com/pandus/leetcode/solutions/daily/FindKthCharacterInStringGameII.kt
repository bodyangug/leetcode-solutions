package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii
class FindKthCharacterInStringGameII {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        var pos = k - 1 // 0-based index
        var shift = 0

        for (i in 63 - java.lang.Long.numberOfLeadingZeros(pos) downTo 0) {
            if ((pos shr i) and 1L == 1L) {
                shift += operations[i]
            }
        }

        return ('a'.code + (shift % 26)).toChar()
    }
}
