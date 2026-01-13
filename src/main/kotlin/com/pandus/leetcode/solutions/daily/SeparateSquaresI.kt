package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/separate-squares-i
class SeparateSquaresI {
    fun separateSquares(squares: Array<IntArray>): Double {
        if (squares.isEmpty()) return 0.0

        // Calculate total area (only once)
        val totalArea = squares.sumOf { it[2].toLong() * it[2] }.toDouble()
        val targetArea = totalArea / 2.0

        // Collect all critical y-coordinates where area function changes slope
        val criticalPoints = mutableSetOf<Double>()
        for (square in squares) {
            val y = square[1].toDouble()
            val l = square[2].toDouble()
            criticalPoints.add(y)
            criticalPoints.add(y + l)
        }

        val sortedPoints = criticalPoints.sorted()

        // Binary search among critical points
        var left = 0
        var right = sortedPoints.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2
            if (calculateAreaBelow(squares, sortedPoints[mid]) < targetArea) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        // The answer is at or between sortedPoints[left-1] and sortedPoints[left]
        if (left == 0) return sortedPoints[0]

        val yLow = sortedPoints[left - 1]
        val areaLow = calculateAreaBelow(squares, yLow)

        // If we already have enough area at yLow, return it
        if (areaLow >= targetArea) return yLow

        // Linear interpolation between yLow and yHigh
        val yHigh = sortedPoints[left]
        val activeWidth = squares.sumOf { square ->
            val y = square[1].toDouble()
            val l = square[2].toDouble()
            if (y < yHigh && y + l > yLow) l else 0.0
        }

        return if (activeWidth > 0.0) {
            yLow + (targetArea - areaLow) / activeWidth
        } else {
            yHigh
        }
    }

    private fun calculateAreaBelow(squares: Array<IntArray>, limitY: Double): Double {
        var area = 0.0
        for (square in squares) {
            val y = square[1].toDouble()
            val l = square[2].toDouble()
            if (y < limitY) {
                area += l * min(limitY - y, l)
            }
        }
        return area
    }
}
