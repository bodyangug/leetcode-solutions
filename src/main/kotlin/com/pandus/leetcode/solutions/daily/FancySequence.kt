package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/fancy-sequence
class FancySequence(
    private val v: MutableList<Int> = ArrayList(),
    private val a: MutableList<Int> = ArrayList<Int>().apply { add(1) },
    private val b: MutableList<Int> = ArrayList<Int>().apply { add(0) }
) {
    private val mod: Int = 1000000007

    fun append(`val`: Int) {
        v.add(`val`)
        a.add(a[a.size - 1])
        b.add(b[b.size - 1])
    }

    fun addAll(inc: Int) {
        val bLastIndex = b.size - 1
        var bLast: Int = b[bLastIndex]
        bLast = (bLast + inc) % mod
        b[bLastIndex] = bLast
    }

    fun multAll(m: Int) {
        val aLastIndex = a.size - 1
        val bLastIndex = b.size - 1
        val aLast = ((a[aLastIndex].toLong() * m) % mod).toInt()
        a[aLastIndex] = aLast
        val bLast = ((b[bLastIndex].toLong() * m) % mod).toInt()
        b[bLastIndex] = bLast
    }

    fun getIndex(idx: Int): Int {
        if (idx >= v.size) {
            return -1
        }
        val ao = ((inv(a[idx]).toLong() * a[a.size - 1]) % mod).toInt()
        val bo = ((b[b.size - 1].toLong() - (b[idx].toLong() * ao) % mod + mod) % mod).toInt()
        val ans = ((((ao.toLong() * v[idx]) % mod) + bo) % mod).toInt()
        return ans
    }

    private fun quickmul(x: Int, y: Int): Int {
        var y = y
        var ret: Long = 1
        var cur = x.toLong()
        while (y != 0) {
            if ((y and 1) != 0) {
                ret = (ret * cur) % mod
            }
            cur = (cur * cur) % mod
            y = y shr 1
        }
        return ret.toInt()
    }

    private fun inv(x: Int): Int {
        return quickmul(x, mod - 2)
    }
}
