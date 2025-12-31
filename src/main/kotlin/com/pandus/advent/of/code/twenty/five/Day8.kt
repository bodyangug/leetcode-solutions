package com.pandus.advent.of.code.twenty.five

import java.util.*

// Reference: https://adventofcode.com/2025/day/8
class Day8 {
    private data class Point3D(val x: Int, val y: Int, val z: Int)
    private data class Edges(val d2: LongArray, val u: IntArray, val v: IntArray, val count: Int)

    fun star1(input: List<String>, k: Int, m: Int): Long {
        val points = parseInput(input)

        val n = points.size
        if (n == 0) return 0L
        if (k <= 0) {
            // all components are size 1
            val take = minOf(m, n)
            var ans = 1L
            repeat(take) { ans *= 1L }
            return ans
        }

        val edgesCount = n * (n - 1) / 2
        val d2 = LongArray(edgesCount)
        val u = IntArray(edgesCount)
        val v = IntArray(edgesCount)

        var idx = 0
        for (i in 0 until n) {
            val pi = points[i]
            for (j in i + 1 until n) {
                val pj = points[j]
                val dx = (pi.x.toLong() - pj.x.toLong())
                val dy = (pi.y.toLong() - pj.y.toLong())
                val dz = (pi.z.toLong() - pj.z.toLong())
                // Assumption (typical for these tasks): this fits in signed 64-bit.
                val dist2 = dx * dx + dy * dy + dz * dz

                d2[idx] = dist2
                u[idx] = i
                v[idx] = j
                idx++
            }
        }

        sortEdgesByDistance(d2, u, v)

        val dsu = DSU(n)
        val steps = minOf(k, edgesCount)
        for (e in 0 until steps) {
            dsu.union(u[e], v[e]) // if already connected, union() is a no-op (attempt is still consumed)
        }

        val sizes = IntArray(n)
        var c = 0
        for (i in 0 until n) {
            if (dsu.parent[i] == i) {
                sizes[c++] = dsu.size[i]
            }
        }

        // Take M largest component sizes and multiply
        sizes.sort(0, c) // ascending in [0, c)
        val take = minOf(m, c)
        var ans = 1L
        for (t in 0 until take) {
            ans *= sizes[c - 1 - t].toLong()
        }
        return ans
    }

    fun star2(input: List<String>): Long {
        val points = parseInput(input)
        val n = points.size
        if (n < 2) return 0L

        val edges = buildAndSortEdges(points)

        val dsu = DSU(n)
        var components = n

        for (e in 0 until edges.count) {
            val a = edges.u[e]
            val b = edges.v[e]
            if (dsu.union(a, b)) {
                components--
                if (components == 1) {
                    return points[a].x.toLong() * points[b].x.toLong()
                }
            }
        }
        return 0L
    }

    private fun buildAndSortEdges(points: List<Point3D>): Edges {
        val n = points.size
        val edgesCount = n * (n - 1) / 2
        val d2 = LongArray(edgesCount)
        val u = IntArray(edgesCount)
        val v = IntArray(edgesCount)

        var idx = 0
        for (i in 0 until n) {
            val pi = points[i]
            val x1 = pi.x.toLong()
            val y1 = pi.y.toLong()
            val z1 = pi.z.toLong()
            for (j in i + 1 until n) {
                val pj = points[j]
                val dx = x1 - pj.x.toLong()
                val dy = y1 - pj.y.toLong()
                val dz = z1 - pj.z.toLong()
                val dist2 = dx * dx + dy * dy + dz * dz

                d2[idx] = dist2
                u[idx] = i
                v[idx] = j
                idx++
            }
        }

        sortEdgesByDistance(d2, u, v)
        return Edges(d2, u, v, edgesCount)
    }

    private fun parseInput(inputs: List<String>): List<Point3D> {
        return inputs.map { line ->
            val parts = line.split(",").map { it.toInt() }
            Point3D(parts[0], parts[1], parts[2])
        }
    }

    private fun IntArray.sort(fromIndex: Int, toIndex: Int) {
        Arrays.sort(this, fromIndex, toIndex)
    }

    private class DSU(n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }

        fun find(x0: Int): Int {
            var x = x0
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]
                x = parent[x]
            }
            return x
        }

        fun union(a: Int, b: Int): Boolean {
            var ra = find(a)
            var rb = find(b)
            if (ra == rb) return false
            if (size[ra] < size[rb]) {
                val tmp = ra
                ra = rb
                rb = tmp
            }
            parent[rb] = ra
            size[ra] += size[rb]
            return true
        }
    }

    private fun sortEdgesByDistance(d2: LongArray, u: IntArray, v: IntArray) {
        val n = d2.size
        if (n <= 1) return

        var stack = IntArray(64)
        var top = 0

        fun push(l: Int, r: Int) {
            if (top + 2 > stack.size) stack = stack.copyOf(stack.size * 2)
            stack[top++] = l
            stack[top++] = r
        }

        fun swap(i: Int, j: Int) {
            val td = d2[i]
            d2[i] = d2[j]
            d2[j] = td
            val tu = u[i]
            u[i] = u[j]
            u[j] = tu
            val tv = v[i]
            v[i] = v[j]
            v[j] = tv
        }

        push(0, n - 1)
        while (top > 0) {
            val r0 = stack[--top]
            val l0 = stack[--top]
            var l = l0
            var r = r0

            while (l < r) {
                val pivot = d2[(l + r) ushr 1]
                var i = l
                var j = r
                while (i <= j) {
                    while (d2[i] < pivot) i++
                    while (d2[j] > pivot) j--
                    if (i <= j) {
                        swap(i, j)
                        i++
                        j--
                    }
                }

                // Now [l..j] and [i..r] are the two partitions (j < i).
                // Recurse on smaller partition, push larger (tail-call style).
                if (j - l < r - i) {
                    if (i < r) push(i, r)
                    r = j
                } else {
                    if (l < j) push(l, j)
                    l = i
                }
            }
        }
    }
}
