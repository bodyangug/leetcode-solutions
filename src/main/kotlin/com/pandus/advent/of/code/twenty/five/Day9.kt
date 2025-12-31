package com.pandus.advent.of.code.twenty.five

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// Reference: https://adventofcode.com/2025/day/9
class Day9 {

    data class Point(val x: Int, val y: Int)

    fun star1(input: List<String>): Long {
        // Using incoming input make a list of the coordinates
        val points = input.map {
            val (x, y) = it.split(",").map { coord -> coord.toInt() }
            Point(x, y)
        }

        // Build all possible rectangles from the points
        val rectangles = mutableListOf<Pair<Point, Point>>()
        for (i in points.indices) {
            for (j in points.indices) {
                if (i != j) {
                    val p1 = points[i]
                    val p2 = points[j]
                    // Ensure p1 is the bottom-left and p2 is the top-right
                    if (p1.x < p2.x && p1.y < p2.y) {
                        rectangles.add(Pair(p1, p2))
                    }
                }
            }
        }

        // Calculate largest area rectangle
        var maxArea = 0L
        for ((p1, p2) in rectangles) {
            val area = (abs(p2.x - p1.x) + 1L) * (abs(p2.y - p1.y) + 1L)
            if (area > maxArea) {
                maxArea = area
            }
        }
        return maxArea
    }

    fun star2(input: List<String>): Long {
        val red = input.map {
            val (x, y) = it.split(",").map(String::toInt)
            Point(x, y)
        }
        val n = red.size
        if (n == 0) return 0L

        // Coordinate compression to avoid huge arrays
        val allX = red.map { it.x }.distinct().sorted()
        val allY = red.map { it.y }.distinct().sorted()

        // Map from original coordinate to compressed index
        val xMap = allX.withIndex().associate { it.value to it.index + 1 } // +1 for margin
        val yMap = allY.withIndex().associate { it.value to it.index + 1 }

        val w = allX.size + 2 // +2 for margins on both sides
        val h = allY.size + 2

        fun gx(x: Int) = xMap[x]!!
        fun gy(y: Int) = yMap[y]!!

        val wall = Array(h) { BooleanArray(w) }

        // Rasterize the loop: mark all vertices and draw lines between them in compressed space
        for (i in 0 until n) {
            val a = red[i]
            val b = red[(i + 1) % n]

            // Get compressed coordinates
            val ax = gx(a.x)
            val ay = gy(a.y)
            val bx = gx(b.x)
            val by = gy(b.y)

            // Draw line in compressed space
            if (ax == bx) {
                // Vertical line
                val yStart = min(ay, by)
                val yEnd = max(ay, by)
                for (cy in yStart..yEnd) {
                    wall[cy][ax] = true
                }
            } else if (ay == by) {
                // Horizontal line
                val xStart = min(ax, bx)
                val xEnd = max(ax, bx)
                for (cx in xStart..xEnd) {
                    wall[ay][cx] = true
                }
            } else {
                // Non-axis-aligned line - mark both endpoints and intermediate compressed cells
                val xStart = min(ax, bx)
                val xEnd = max(ax, bx)
                val yStart = min(ay, by)
                val yEnd = max(ay, by)
                for (cy in yStart..yEnd) {
                    for (cx in xStart..xEnd) {
                        wall[cy][cx] = true
                    }
                }
            }
        }

        // Flood-fill outside area on the tile grid (4-neighborhood), walls are blocked.
        val visited = BooleanArray(w * h)
        val q = IntArray(w * h)
        var head = 0
        var tail = 0

        fun push(idx: Int) {
            visited[idx] = true
            q[tail++] = idx
        }

        // Start from the top-left corner of the padded grid, guaranteed outside.
        push(0)

        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        while (head < tail) {
            val idx = q[head++]
            val x = idx % w
            val y = idx / w
            for (d in 0 until 4) {
                val nx = x + dirs[d]
                val ny = y + dirs[d + 1]
                if (nx !in 0 until w || ny !in 0 until h) continue
                if (wall[ny][nx]) continue
                val nidx = ny * w + nx
                if (!visited[nidx]) push(nidx)
            }
        }

        // Prefix sum over "outside" tiles (visited == outside reachable).
        val ps = Array(h + 1) { IntArray(w + 1) }
        for (y in 0 until h) {
            var rowSum = 0
            for (x in 0 until w) {
                val bad = if (visited[y * w + x]) 1 else 0
                rowSum += bad
                ps[y + 1][x + 1] = ps[y][x + 1] + rowSum
            }
        }

        fun badInRect(x1: Int, y1: Int, x2: Int, y2: Int): Int {
            // x1..x2, y1..y2 inclusive, all in grid coords
            val ax = x1
            val ay = y1
            val bx = x2 + 1
            val by = y2 + 1
            return ps[by][bx] - ps[ay][bx] - ps[by][ax] + ps[ay][ax]
        }

        var best = 0L

        // Check all pairs of red points as opposite corners.
        for (i in 0 until n) {
            val p = red[i]
            for (j in i + 1 until n) {
                val qpt = red[j]

                val xLo = min(p.x, qpt.x)
                val xHi = max(p.x, qpt.x)
                val yLo = min(p.y, qpt.y)
                val yHi = max(p.y, qpt.y)

                val area = (abs(p.x - qpt.x) + 1L) * (abs(p.y - qpt.y) + 1L)
                if (area <= best) continue // cheap prune

                val rx1 = gx(xLo)
                val rx2 = gx(xHi)
                val ry1 = gy(yLo)
                val ry2 = gy(yHi)

                // Valid iff rectangle contains no outside tiles.
                if (badInRect(rx1, ry1, rx2, ry2) == 0) {
                    best = area
                }
            }
        }
        return best
    }
}
