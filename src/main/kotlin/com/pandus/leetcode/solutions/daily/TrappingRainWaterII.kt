package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.max

// Reference: https://leetcode.com/problems/trapping-rain-water-ii
class TrappingRainWaterII {

    private data class Cell(val height: Int, val row: Int, val col: Int) : Comparable<Cell> {
        override fun compareTo(other: Cell): Int = height.compareTo(other.height)
    }

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val rows = heightMap.size
        val cols = heightMap[0].size

        if (rows < 3 || cols < 3) return 0

        val visited = Array(rows) { BooleanArray(cols) }
        val pq = PriorityQueue<Cell>()

        // Initialize boundary cells more efficiently
        // Top and bottom rows
        for (col in 0 until cols) {
            addBoundaryCell(heightMap, visited, pq, 0, col)
            addBoundaryCell(heightMap, visited, pq, rows - 1, col)
        }
        // Left and right columns (excluding corners already added)
        for (row in 1 until rows - 1) {
            addBoundaryCell(heightMap, visited, pq, row, 0)
            addBoundaryCell(heightMap, visited, pq, row, cols - 1)
        }

        var result = 0
        val directions = intArrayOf(-1, 0, 1, 0, -1) // More efficient directions representation

        while (pq.isNotEmpty()) {
            val current = pq.poll()

            // Check all 4 directions
            for (i in 0 until 4) {
                val newRow = current.row + directions[i]
                val newCol = current.col + directions[i + 1]

                if (isValidUnvisited(newRow, newCol, rows, cols, visited)) {
                    visited[newRow][newCol] = true
                    val cellHeight = heightMap[newRow][newCol]
                    val waterLevel = max(current.height, cellHeight)

                    result += waterLevel - cellHeight
                    pq.offer(Cell(waterLevel, newRow, newCol))
                }
            }
        }

        return result
    }

    private fun addBoundaryCell(
        heightMap: Array<IntArray>,
        visited: Array<BooleanArray>,
        pq: PriorityQueue<Cell>,
        row: Int,
        col: Int
    ) {
        pq.offer(Cell(heightMap[row][col], row, col))
        visited[row][col] = true
    }

    private fun isValidUnvisited(row: Int, col: Int, rows: Int, cols: Int, visited: Array<BooleanArray>): Boolean {
        return row in 0 until rows && col in 0 until cols && !visited[row][col]
    }
}
