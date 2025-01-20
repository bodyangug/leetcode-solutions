package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/first-completely-painted-row-or-column
class FirstCompletelyPaintedRowOrColumn {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val ix = IntArray(arr.size + 1)
        for (i in arr.indices) ix[arr[i]] = i
        return min(
            mat[0].indices.minOf {
                mat.maxOf { r -> ix[r[it]] }
            },
            mat.minOf { r ->
                mat[0].indices.maxOf { ix[r[it]] }
            }
        )
    }
}
