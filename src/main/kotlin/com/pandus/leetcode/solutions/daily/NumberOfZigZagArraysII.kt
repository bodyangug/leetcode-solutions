package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-zigzag-arrays-ii
class NumberOfZigZagArraysII {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val m = r - l + 1
        if (n == 1) return m

        // State vector of length 2m: first m slots = "up-ending" counts per value,
        // next m slots = "down-ending" counts per value.
        // Transition matrix u (size 2m x 2m):
        //   u[i][j+m] = 1 for j < i  -> ending up at value i comes from "down" at smaller value j
        //   u[i+m][j] = 1 for j > i  -> ending down at value i comes from "up" at larger value j
        val size = 2 * m
        val transition = Matrix(size, size)
        for (i in 0 until m) {
            for (j in 0 until i) transition.set(i, j + m, 1L)
            for (j in i + 1 until m) transition.set(i + m, j, 1L)
        }

        // Initial dp (length 1): every value contributes 1 to both up and down buckets.
        var dp = Matrix(1, size)
        for (i in 0 until size) dp.set(0, i, 1L)

        dp = transition.pow(n - 1L, dp)

        var ans = 0L
        for (i in 0 until size) ans = (ans + dp.get(0, i)) % Matrix.MOD
        return ans.toInt()
    }

    private class Matrix(val rows: Int, val cols: Int) {
        val data: LongArray = LongArray(rows * cols)

        fun get(i: Int, j: Int): Long = data[i * cols + j]
        fun set(i: Int, j: Int, v: Long) {
            data[i * cols + j] = v
        }

        fun mul(other: Matrix): Matrix {
            val res = Matrix(rows, other.cols)
            for (i in 0 until rows) {
                val rowBase = i * cols
                val resBase = i * other.cols
                for (k in 0 until cols) {
                    val r = data[rowBase + k]
                    if (r == 0L) continue
                    val otherBase = k * other.cols
                    for (j in 0 until other.cols) {
                        res.data[resBase + j] =
                            (res.data[resBase + j] + r * other.data[otherBase + j]) % MOD
                    }
                }
            }
            return res
        }

        fun pow(expIn: Long, initial: Matrix): Matrix {
            var exp = expIn
            var base = Matrix(rows, cols)
            System.arraycopy(data, 0, base.data, 0, data.size)
            var res = initial
            while (exp > 0) {
                if ((exp and 1L) == 1L) res = res.mul(base)
                base = base.mul(base)
                exp = exp shr 1
            }
            return res
        }

        companion object {
            const val MOD = 1_000_000_007L
        }
    }
}
