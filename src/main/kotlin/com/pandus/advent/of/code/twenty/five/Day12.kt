package com.pandus.advent.of.code.twenty.five

import kotlin.math.max

// Reference: https://adventofcode.com/2025/day/12
class Day12 {
    private data class Orientation(val cells: IntArray, val w: Int, val h: Int, val area: Int)
    private data class Shape(val orientations: List<Orientation>, val area: Int)
    private data class Region(val w: Int, val h: Int, val qty: IntArray)

    fun star1(input: List<String>): Long {
        val (shapes, regions) = parseInput(input)
        var ok = 0L
        for (r in regions) {
            if (canFitRegion(shapes, r)) ok++
        }
        return ok
    }

    /* ---------------- Parsing ---------------- */

    private fun parseInput(input: List<String>): Pair<List<Shape>, List<Region>> {
        val shapeHeader = Regex("""^\s*(\d+)\s*:\s*$""")
        val regionHeader = Regex("""^\s*(\d+)\s*x\s*(\d+)\s*:\s*(.*)$""")

        // Read shapes until first region line
        val rawShapes = mutableMapOf<Int, List<String>>()
        var i = 0
        while (i < input.size) {
            val line = input[i].trim()
            if (line.isEmpty()) {
                i++
                continue
            }
            if (regionHeader.matches(line)) break

            val m = shapeHeader.matchEntire(line)
            if (m != null) {
                val idx = m.groupValues[1].toInt()
                i++
                val rows = mutableListOf<String>()
                while (i < input.size) {
                    val t = input[i].trim()
                    if (t.isEmpty()) {
                        if (rows.isNotEmpty()) {
                            i++
                            break
                        }
                        i++
                        continue
                    }
                    if (shapeHeader.matches(t) || regionHeader.matches(t)) break
                    rows.add(t)
                    i++
                }
                if (rows.isNotEmpty()) rawShapes[idx] = rows
                continue
            }

            // unknown line; skip
            i++
        }

        if (rawShapes.isEmpty()) return emptyList<Shape>() to emptyList()

        val maxIdx = rawShapes.keys.maxOrNull()!!
        val shapes = ArrayList<Shape>(maxIdx + 1)
        for (idx in 0..maxIdx) {
            val rows = rawShapes[idx] ?: error("Missing shape index $idx in input")
            shapes.add(buildShape(rows))
        }

        // Read regions
        val regions = mutableListOf<Region>()
        while (i < input.size) {
            val line = input[i].trim()
            i++
            if (line.isEmpty()) continue
            val m = regionHeader.matchEntire(line) ?: continue
            val w = m.groupValues[1].toInt()
            val h = m.groupValues[2].toInt()
            val rest = m.groupValues[3].trim()
            val counts = if (rest.isEmpty()) emptyList() else rest.split(Regex("""\s+""")).map { it.toInt() }
            if (counts.size != shapes.size) {
                error("Region counts size ${counts.size} != number of shapes ${shapes.size} for line: $line")
            }
            regions.add(Region(w, h, counts.toIntArray()))
        }

        return shapes to regions
    }

    private fun buildShape(rows: List<String>): Shape {
        val coords = mutableListOf<Pair<Int, Int>>()
        for (y in rows.indices) {
            val row = rows[y]
            for (x in row.indices) {
                if (row[x] == '#') coords.add(x to y)
            }
        }
        val area = coords.size
        require(area > 0) { "Shape has no # cells" }

        // Normalize original to (0,0)
        val minX0 = coords.minOf { it.first }
        val minY0 = coords.minOf { it.second }
        val base = coords.map { (it.first - minX0) to (it.second - minY0) }

        // 8 transforms: (x,y), (x,-y), (-x,y), (-x,-y), and swaps
        fun transform(p: Pair<Int, Int>, t: Int): Pair<Int, Int> {
            val x = p.first
            val y = p.second
            return when (t) {
                0 -> x to y
                1 -> x to -y
                2 -> -x to y
                3 -> -x to -y
                4 -> y to x
                5 -> y to -x
                6 -> -y to x
                else -> -y to -x
            }
        }

        val seen = HashSet<String>()
        val orients = ArrayList<Orientation>()

        for (t in 0 until 8) {
            val pts = base.map { transform(it, t) }
            val minX = pts.minOf { it.first }
            val minY = pts.minOf { it.second }
            val norm = pts.map { (it.first - minX) to (it.second - minY) }
                .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

            val key = buildString {
                for ((x, y) in norm) {
                    append(x).append(',').append(y).append(';')
                }
            }
            if (!seen.add(key)) continue

            val maxX = norm.maxOf { it.first }
            val maxY = norm.maxOf { it.second }
            val w = maxX + 1
            val h = maxY + 1

            val packed = IntArray(norm.size)
            for (k in norm.indices) {
                val (x, y) = norm[k]
                packed[k] = (x shl 16) or (y and 0xFFFF)
            }
            orients.add(Orientation(packed, w, h, area))
        }

        return Shape(orients, area)
    }

    /* ---------------- Solving per region with DLX ---------------- */

    private fun canFitRegion(shapes: List<Shape>, region: Region): Boolean {
        val W = region.w
        val H = region.h
        val area = W * H

        var neededArea = 0
        var pieceCount = 0
        for (i in shapes.indices) {
            val q = region.qty[i]
            if (q < 0) return false
            if (q == 0) continue
            neededArea += q * shapes[i].area
            pieceCount += q
        }
        if (neededArea > area) return false
        if (pieceCount == 0) return true

        // Quick impossibility: a required shape must have at least one orientation fitting in region
        for (i in shapes.indices) {
            if (region.qty[i] == 0) continue
            val fits = shapes[i].orientations.any { it.w <= W && it.h <= H }
            if (!fits) return false
        }

        val primaryCols = pieceCount
        val secondaryCols = area
        val dlx = DLX(primaryCols, secondaryCols)

        // Build mapping from pieceCopyId -> shapeIndex
        val pieceShape = IntArray(pieceCount)
        var p = 0
        for (si in shapes.indices) {
            repeat(region.qty[si]) {
                pieceShape[p++] = si
            }
        }

        // Generate all placement rows
        for (pieceId in 0 until pieceCount) {
            val shape = shapes[pieceShape[pieceId]]
            val pieceColId = 1 + pieceId // primary columns are [1..primaryCols]
            for (o in shape.orientations) {
                if (o.w > W || o.h > H) continue
                val maxX = W - o.w
                val maxY = H - o.h
                for (y0 in 0..maxY) {
                    for (x0 in 0..maxX) {
                        // row columns: piece + occupied cells
                        val cols = IntArray(1 + o.area)
                        cols[0] = pieceColId
                        var k = 1
                        for (cell in o.cells) {
                            val x = (cell ushr 16) + x0
                            val y = (cell and 0xFFFF) + y0
                            val idx = y * W + x // 0..area-1
                            cols[k++] = 1 + primaryCols + idx
                        }
                        dlx.addRow(cols)
                    }
                }
            }
        }

        return dlx.existsSolution()
    }

    /* ---------------- DLX with primary + secondary columns ---------------- */

    private class DLX(private val primaryCols: Int, secondaryCols: Int) {
        private val m = primaryCols + secondaryCols
        private val isPrimary = BooleanArray(m + 1) { it in 1..primaryCols }

        // DLX arrays (node indices are Int)
        private var left = IntArray(m + 1024)
        private var right = IntArray(m + 1024)
        private var up = IntArray(m + 1024)
        private var down = IntArray(m + 1024)
        private var col = IntArray(m + 1024)
        private var size = IntArray(m + 1)

        private var nextNode = m + 1

        init {
            // Initialize root (0) and columns (1..m)
            up[0] = 0
            down[0] = 0
            left[0] = 0
            right[0] = 0
            col[0] = 0

            for (c in 1..m) {
                up[c] = c
                down[c] = c
                col[c] = c
                size[c] = 0
                if (isPrimary[c]) {
                    // will be linked into header list below
                    left[c] = c
                    right[c] = c
                } else {
                    // secondary columns are not in the root header list
                    left[c] = c
                    right[c] = c
                }
            }

            // Link ONLY primary columns into the root header list
            var last = 0
            for (c in 1..primaryCols) {
                right[last] = c
                left[c] = last
                last = c
            }
            right[last] = 0
            left[0] = last
            right[0] = if (primaryCols > 0) 1 else 0
            if (primaryCols > 0) left[1] = 0
        }

        fun addRow(columns: IntArray) {
            ensureCapacity(columns.size)
            var first = 0
            var prev = 0
            for (c in columns) {
                val node = nextNode++
                col[node] = c

                // vertical insert into column c (at bottom, before header c)
                down[node] = c
                up[node] = up[c]
                down[up[c]] = node
                up[c] = node
                size[c]++

                // horizontal linking
                if (first == 0) {
                    first = node
                    prev = node
                    left[node] = node
                    right[node] = node
                } else {
                    right[prev] = node
                    left[node] = prev
                    right[node] = first
                    left[first] = node
                    prev = node
                }
            }
        }

        fun existsSolution(): Boolean = search()

        private fun search(): Boolean {
            if (right[0] == 0) return true // all primary columns covered

            val c = chooseColumn()
            if (c == 0) return true
            if (size[c] == 0) return false

            cover(c)
            var r = down[c]
            while (r != c) {
                // cover columns in this row
                var j = right[r]
                while (j != r) {
                    cover(col[j])
                    j = right[j]
                }

                if (search()) return true

                // uncover in reverse
                j = left[r]
                while (j != r) {
                    uncover(col[j])
                    j = left[j]
                }

                r = down[r]
            }
            uncover(c)
            return false
        }

        private fun chooseColumn(): Int {
            var c = right[0]
            var best = c
            var bestSize = Int.MAX_VALUE
            while (c != 0) {
                val s = size[c]
                if (s < bestSize) {
                    bestSize = s
                    best = c
                    if (s == 0) break
                }
                c = right[c]
            }
            return best
        }

        private fun cover(c: Int) {
            if (isPrimary[c]) {
                // remove column header from root list
                right[left[c]] = right[c]
                left[right[c]] = left[c]
            }
            var i = down[c]
            while (i != c) {
                var j = right[i]
                while (j != i) {
                    val cj = col[j]
                    down[up[j]] = down[j]
                    up[down[j]] = up[j]
                    size[cj]--
                    j = right[j]
                }
                i = down[i]
            }
        }

        private fun uncover(c: Int) {
            var i = up[c]
            while (i != c) {
                var j = left[i]
                while (j != i) {
                    val cj = col[j]
                    size[cj]++
                    down[up[j]] = j
                    up[down[j]] = j
                    j = left[j]
                }
                i = up[i]
            }
            if (isPrimary[c]) {
                // restore column header into root list
                right[left[c]] = c
                left[right[c]] = c
            }
        }

        private fun ensureCapacity(extraNodes: Int) {
            val need = nextNode + extraNodes + 16
            if (need <= left.size) return
            val newSize = max(need, left.size * 2)
            left = left.copyOf(newSize)
            right = right.copyOf(newSize)
            up = up.copyOf(newSize)
            down = down.copyOf(newSize)
            col = col.copyOf(newSize)
        }
    }
}
