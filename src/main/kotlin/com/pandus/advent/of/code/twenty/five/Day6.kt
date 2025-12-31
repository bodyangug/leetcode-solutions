package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/6
class Day6 {
    fun star1(input: List<String>): Long {
        val matrix = mutableListOf<MutableList<String>>()
        for (line in input) {
            val row = line.trim().split(Regex("\\s+")).toMutableList()
            matrix.add(row)
        }

        fun <T> transpose(matrix: List<List<T>>): List<List<T>> {
            if (matrix.isEmpty()) return emptyList()
            return List(matrix[0].size) { col ->
                List(matrix.size) { row ->
                    matrix[row][col]
                }
            }
        }

        val transposed = transpose(matrix)

        var ans = 0L
        for (row in transposed) {
            val numbers = row.dropLast(1).map { it.toLong() }
            val rowResult = when (val operator = row.last()) {
                "+" -> numbers.sum()
                "*" -> numbers.reduce { acc, n -> acc * n }
                else -> throw IllegalArgumentException("Unknown operator: $operator")
            }
            ans += rowResult
        }

        return ans
    }

    fun star2(input: List<String>): Long {
        if (input.isEmpty()) return 0L

        val height = input.size
        val width = input.maxOf { it.length }
        val grid = input.map { it.padEnd(width, ' ') }
        val opRow = grid.last()

        fun isSeparatorColumn(col: Int): Boolean {
            for (r in 0 until height) {
                if (grid[r][col] != ' ') return false
            }
            return true
        }

        // Build contiguous "problem blocks" separated by all-space columns.
        val blocks = mutableListOf<IntRange>() // inclusive ranges of columns
        var c = 0
        while (c < width) {
            while (c < width && isSeparatorColumn(c)) c++
            if (c >= width) break

            val start = c
            while (c < width && !isSeparatorColumn(c)) c++
            val endInclusive = c - 1

            blocks += (start..endInclusive)
        }

        var total = 0L

        // Problems are processed right-to-left: rightmost block is Problem #1.
        for (block in blocks.asReversed()) {
            // Operator: find '+' or '*' in the bottom row within this block.
            val op = run {
                var found: Char? = null
                for (col in block.first..block.last) {
                    val ch = opRow[col]
                    if (ch == '+' || ch == '*') {
                        found = ch
                        break
                    }
                }
                found ?: error("No operator found in block $block")
            }

            // Numbers: each column in the block is one number, read right-to-left.
            val numbers = ArrayList<Long>()
            for (col in block.last downTo block.first) {
                val sb = StringBuilder()
                for (row in 0 until height - 1) { // exclude operator row
                    val ch = grid[row][col]
                    if (ch in '0'..'9') sb.append(ch)
                }
                if (sb.isNotEmpty()) {
                    numbers += sb.toString().toLong()
                }
            }

            val result = when (op) {
                '+' -> numbers.fold(0L) { acc, n -> acc + n }
                '*' -> numbers.fold(1L) { acc, n -> acc * n }
                else -> error("Unsupported operator: $op")
            }

            total += result
        }

        return total
    }
}
