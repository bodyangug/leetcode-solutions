package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/7
class Day7 {
    fun star1(grid: List<String>): Long {
        val matrix = grid.map { it.toCharArray() }
        val numRows = matrix.size
        val numCols = matrix[0].size
        var splitCount = 0L

        // Find starting position 'S'
        val startColumn = matrix[0].indexOf('S')

        // Queue: (row, col) - position of beam
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(0, startColumn))

        // Track visited positions to avoid processing the same beam position twice
        val visited = mutableSetOf<Pair<Int, Int>>()
        visited.add(Pair(0, startColumn))

        while (queue.isNotEmpty()) {
            val (row, col) = queue.removeFirst()

            // Move beam down one step
            val nextRow = row + 1

            // Check if beam exits the grid
            if (nextRow >= numRows) {
                continue // Beam terminates
            }
            // Check if beam is out of bounds horizontally
            if (col !in 0..<numCols) {
                continue // Beam terminates
            }

            val cell = matrix[nextRow][col]

            when (cell) {
                '^' -> {
                    // Splitter hit! Increment count and create two new beams
                    splitCount++

                    // Create left beam (same row as splitter, one column left)
                    val leftCol = col - 1
                    if (leftCol >= 0) {
                        val leftBeam = Pair(nextRow, leftCol)
                        if (leftBeam !in visited) {
                            visited.add(leftBeam)
                            queue.add(leftBeam)
                        }
                    }

                    // Create right beam (same row as splitter, one column right)
                    val rightCol = col + 1
                    if (rightCol < numCols) {
                        val rightBeam = Pair(nextRow, rightCol)
                        if (rightBeam !in visited) {
                            visited.add(rightBeam)
                            queue.add(rightBeam)
                        }
                    }
                }

                else -> {
                    // Empty space or S - beam continues downward
                    val nextBeam = Pair(nextRow, col)
                    if (nextBeam !in visited) {
                        visited.add(nextBeam)
                        queue.add(nextBeam)
                    }
                }
            }
        }
        return splitCount
    }

    fun star2(grid: List<String>): Long {
        val matrix = grid.map { it.toCharArray() }
        val numRows = matrix.size
        val numCols = matrix[0].size

        // Find 'S' (more robust than assuming row 0)
        val startRow = 0
        val startColumn = matrix[0].indexOf('S')

        // counts[col] = number of timelines currently at (row, col)
        var counts = LongArray(numCols)
        counts[startColumn] = 1L

        var timelines = 0L

        // Helper: fail fast on overflow (remove if you prefer silent overflow)
        fun addExact(a: Long, b: Long): Long = Math.addExact(a, b)

        for (row in startRow until numRows) {
            val nextCounts = LongArray(numCols)
            for (col in 0 until numCols) {
                val ways = counts[col]
                if (ways == 0L) continue

                val nextRow = row + 1
                if (nextRow >= numRows) {
                    // Exits the bottom => completed timelines
                    timelines = addExact(timelines, ways)
                    continue
                }

                val cell = matrix[nextRow][col]
                if (cell == '^') {
                    // Timeline splits into two (many-worlds): both branches keep full multiplicity
                    val leftCol = col - 1
                    if (leftCol < 0) {
                        timelines = addExact(timelines, ways) // exits to the left
                    } else {
                        nextCounts[leftCol] = addExact(nextCounts[leftCol], ways)
                    }

                    val rightCol = col + 1
                    if (rightCol >= numCols) {
                        timelines = addExact(timelines, ways) // exits to the right
                    } else {
                        nextCounts[rightCol] = addExact(nextCounts[rightCol], ways)
                    }
                } else {
                    // '.', 'S', or anything else: continue straight down
                    nextCounts[col] = addExact(nextCounts[col], ways)
                }
            }

            counts = nextCounts
        }
        return timelines
    }
}
