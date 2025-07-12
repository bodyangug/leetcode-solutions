package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/
class EarliestAndLatestRoundsWherePlayersCompete {
    private val MAX = 30
    private val F = Array(MAX) { Array(MAX) { IntArray(MAX) { -1 } } }
    private val G = Array(MAX) { Array(MAX) { IntArray(MAX) { -1 } } }

    private fun dp(n: Int, f: Int, s: Int): IntArray {
        val a = min(f, s)
        val b = max(f, s)

        if (F[n][a][b] != -1) {
            return intArrayOf(F[n][a][b], G[n][a][b])
        }

        if (a + b == n + 1) {
            F[n][a][b] = 1
            G[n][a][b] = 1
            return intArrayOf(1, 1)
        }

        if (a + b > n + 1) {
            val res = dp(n, n + 1 - b, n + 1 - a)
            F[n][a][b] = res[0]
            G[n][a][b] = res[1]
            return res
        }

        var earliest = Int.MAX_VALUE
        var latest = Int.MIN_VALUE
        val half = (n + 1) / 2

        if (b <= half) {
            for (i in 0 until a) {
                for (j in 0 until b - a) {
                    val (e, l) = dp(half, i + 1, i + j + 2)
                    earliest = minOf(earliest, e)
                    latest = maxOf(latest, l)
                }
            }
        } else {
            val sPrime = n + 1 - b
            val mid = (n - 2 * sPrime + 1) / 2
            for (i in 0 until a) {
                for (j in 0 until sPrime - a) {
                    val (e, l) = dp(half, i + 1, i + j + mid + 2)
                    earliest = minOf(earliest, e)
                    latest = maxOf(latest, l)
                }
            }
        }

        F[n][a][b] = earliest + 1
        G[n][a][b] = latest + 1
        return intArrayOf(F[n][a][b], G[n][a][b])
    }

    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        return dp(n, firstPlayer, secondPlayer)
    }
}
