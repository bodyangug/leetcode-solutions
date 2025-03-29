package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-points-from-grid-queries
class MaximumNumberOfPointsFromGridQueries {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val rows = grid.size
        val cols = grid[0].size

        // Flatten grid into (value, row, col) and sort ascending by value.
        val cells = mutableListOf<Triple<Int, Int, Int>>()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                cells.add(Triple(grid[r][c], r, c))
            }
        }
        cells.sortBy { it.first }

        // Sort the queries: (thresholdValue -> originalIndex), ascending by threshold.
        val sortedQueries = queries
            .withIndex() // (index, threshold)
            .map { it.value to it.index }
            .sortedBy { it.first } // sort by the threshold

        // --- Union-Find (Disjoint Set) ---
        // Each cell is identified by: id = r * cols + c
        val parent = IntArray(rows * cols) { it }
        val size = IntArray(rows * cols) { 1 }

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(a: Int, b: Int) {
            val ra = find(a)
            val rb = find(b)
            if (ra != rb) {
                // Attach one root to the other and combine sizes
                parent[rb] = ra
                size[ra] += size[rb]
            }
        }

        // Directions for 4-neighbors: right, down, left, up
        val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

        // We'll build answers in sorted order, then reorder them back.
        val answers = IntArray(queries.size)
        var cellIndex = 0 // to walk through 'cells' in ascending order of their values

        // Process queries from smallest threshold to largest
        for ((qValue, qIndex) in sortedQueries) {
            // "Activate" all cells with value < qValue
            while (cellIndex < cells.size && cells[cellIndex].first < qValue) {
                val (_, r, c) = cells[cellIndex++]
                val id = r * cols + c

                // Union with any already-activated neighbors
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in 0 until rows && nc in 0 until cols) {
                        // If neighbor is also < qValue, it must already have been activated,
                        // so we can union these two.
                        if (grid[nr][nc] < qValue) {
                            union(id, nr * cols + nc)
                        }
                    }
                }
            }

            // The answer for this query is the size of the component containing (0,0),
            // but only if (0,0) is "activated" (i.e., grid[0][0] < qValue).
            answers[qIndex] = if (grid[0][0] < qValue) size[find(0)] else 0
        }
        return answers
    }
}
