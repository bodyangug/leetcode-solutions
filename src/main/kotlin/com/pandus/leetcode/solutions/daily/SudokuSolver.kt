package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sudoku-solver
class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>) {
        val rows = IntArray(9)
        val cols = IntArray(9)
        val boxes = IntArray(9)
        val blanks = IntArray(162)
        var blankCount = 0

        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] == '.') {
                    blanks[blankCount++] = i * 9 + j
                } else {
                    val bit = 1 shl (board[i][j] - '1')
                    rows[i] = rows[i] or bit
                    cols[j] = cols[j] or bit
                    boxes[i / 3 * 3 + j / 3] = boxes[i / 3 * 3 + j / 3] or bit
                }
            }
        }

        solve(board, 0, rows, cols, boxes, blanks, blankCount)
    }

    private fun solve(
        board: Array<CharArray>,
        pos: Int,
        rows: IntArray,
        cols: IntArray,
        boxes: IntArray,
        blanks: IntArray,
        total: Int
    ): Boolean {
        if (pos == total) return true

        var best = pos
        var bestMask = 0
        var minOptions = 10

        for (i in pos until total) {
            val cell = blanks[i]
            val r = cell / 9
            val c = cell % 9
            val mask = 511 and (rows[r] or cols[c] or boxes[r / 3 * 3 + c / 3]).inv()
            val options = Integer.bitCount(mask)

            if (options == 0) return false

            if (options < minOptions) {
                best = i
                bestMask = mask
                minOptions = options
                if (options == 1) break
            }
        }

        val temp = blanks[pos]
        blanks[pos] = blanks[best]
        blanks[best] = temp

        val cell = blanks[pos]
        val r = cell / 9
        val c = cell % 9
        val boxIdx = r / 3 * 3 + c / 3

        var mask = bestMask
        if (mask == 0) {
            mask = 511 and (rows[r] or cols[c] or boxes[boxIdx]).inv()
        }

        while (mask != 0) {
            val bit = mask and -mask
            mask = mask xor bit
            val digit = Integer.numberOfTrailingZeros(bit)

            board[r][c] = ('1' + digit)
            rows[r] = rows[r] or bit
            cols[c] = cols[c] or bit
            boxes[boxIdx] = boxes[boxIdx] or bit

            if (solve(board, pos + 1, rows, cols, boxes, blanks, total)) return true

            rows[r] = rows[r] and bit.inv()
            cols[c] = cols[c] and bit.inv()
            boxes[boxIdx] = boxes[boxIdx] and bit.inv()
            board[r][c] = '.'
        }

        blanks[best] = blanks[pos]
        blanks[pos] = temp
        return false
    }
}
