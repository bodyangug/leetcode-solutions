package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field
class MaximumSquareAreaByRemovingFencesFromField {
    fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val hEdges = getEdges(hFences, m)
        val vEdges = getEdges(vFences, n)
        var res: Long = 0
        for (e in hEdges) {
            if (vEdges.contains(e)) {
                res = max(res, e.toLong())
            }
        }
        return if (res == 0L) {
            -1
        } else {
            ((res * res) % 1000000007).toInt()
        }
    }

    private fun getEdges(fences: IntArray, border: Int): MutableSet<Int> {
        val set: MutableSet<Int> = HashSet()
        val list: MutableList<Int> = ArrayList()
        for (fence in fences) {
            list.add(fence)
        }
        list.add(1)
        list.add(border)
        list.sort()
        for (i in list.indices) {
            for (j in i + 1..<list.size) {
                set.add(list[j] - list[i])
            }
        }
        return set
    }
}
