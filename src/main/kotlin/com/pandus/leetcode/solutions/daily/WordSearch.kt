package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/word-search
class WordSearch {
    private lateinit var board: Array<CharArray>
    private val rowOffsets = intArrayOf(-1, 0, 1, 0)
    private val colOffsets = intArrayOf(0, 1, 0, -1)

    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        val rows = board.size
        val cols = board[0].size
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (backtrack(row, col, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun backtrack(row: Int, col: Int, word: String, index: Int): Boolean {
        if (index == word.length) return true
        if (row < 0 || row == board.size || col < 0 || col == board[0].size || board[row][col] != word[index]) {
            return false
        }

        board[row][col] = '#'
        for (dir in 0..3) {
            val newRow = row + rowOffsets[dir]
            val newCol = col + colOffsets[dir]
            if (backtrack(newRow, newCol, word, index + 1)) {
                return true
            }
        }
        board[row][col] = word[index]
        return false
    }
}
