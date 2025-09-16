package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/valid-sudoku
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = IntArray(9)
        val cols = IntArray(9)
        val boxes = IntArray(9)

        for (i in 0 until 9) {
            val row = board[i]
            for (j in 0 until 9) {
                val ch = row[j]
                if (ch == '.') continue

                val d = ch - '1'
                if (d !in 0..8) return false // defensive: invalid char

                val bit = 1 shl d
                val b = (i / 3) * 3 + (j / 3) // 0..8 box index

                // Duplicate check via bit test
                if ((rows[i] and bit) != 0) return false
                if ((cols[j] and bit) != 0) return false
                if ((boxes[b] and bit) != 0) return false

                // Set bits
                rows[i] = rows[i] or bit
                cols[j] = cols[j] or bit
                boxes[b] = boxes[b] or bit
            }
        }
        return true
    }
}