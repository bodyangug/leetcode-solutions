package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/4
class Day4 {
    private val directions = arrayOf(
        intArrayOf(-1, 0), // up
        intArrayOf(-1, 1), // up-right
        intArrayOf(0, 1), // right
        intArrayOf(1, 1), // down-right
        intArrayOf(1, 0), // down
        intArrayOf(1, -1), // down-left
        intArrayOf(0, -1), // left
        intArrayOf(-1, -1) // up-left
    )

    fun star1(input: List<String>): Int {
        val grid = input.map { it.toCharArray() }.toTypedArray()
        val rows = grid.size
        val cols = grid[0].size
        var ans = 0
        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[0].lastIndex) {
                val cell = grid[row][col]
                if (cell == '@') {
                    var adjacentCount = 0
                    for (dir in directions) {
                        val newRow = row + dir[0]
                        val newCol = col + dir[1]
                        if (newRow in 0 until rows && newCol in 0 until cols) {
                            val adjacent = grid[newRow][newCol]
                            if (adjacent == '@') {
                                adjacentCount++
                            }
                        }
                    }
                    if (adjacentCount < 4) {
                        ans++
                    }
                }
            }
        }
        return ans
    }

    fun star2(input: List<String>): Int {
        var ans = 0
        val grid = input.map { it.toCharArray() }.toTypedArray()
        val rows = grid.size
        val cols = grid[0].size
        val removed = mutableSetOf<Pair<Int, Int>>()

        var hasChanges = true
        while (hasChanges) {
            hasChanges = false
            val toRemove = mutableListOf<Pair<Int, Int>>()

            for (row in 0..grid.lastIndex) {
                for (col in 0..grid[0].lastIndex) {
                    val cell = grid[row][col]
                    if (cell == '@' && !removed.contains(row to col)) { // Добавлена проверка
                        var adjacentCount = 0
                        for (dir in directions) {
                            val newRow = row + dir[0]
                            val newCol = col + dir[1]
                            if (newRow in 0 until rows && newCol in 0 until cols) {
                                val adjacent = grid[newRow][newCol]
                                if (adjacent == '@' && !removed.contains(newRow to newCol)) {
                                    adjacentCount++
                                }
                            }
                        }
                        if (adjacentCount < 4) {
                            toRemove.add(row to col)
                        }
                    }
                }
            }
            if (toRemove.isNotEmpty()) {
                hasChanges = true
                removed.addAll(toRemove)
                ans += toRemove.size
            }
        }
        return ans
    }
}
