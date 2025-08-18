package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.round

// Reference: https://leetcode.com/problems/24-game
class TwentyFourGame {
    private val EPS = 1e-6
    private val TARGET = 24.0
    private val seen = HashSet<String>() // memo

    fun judgePoint24(cards: IntArray): Boolean {
        // Optional micro-prunes (keep or remove as you like)
        val sum = cards.sum()
        if (sum == 4 || sum > 36) return false

        val nums = cards.map { it.toDouble() }
        seen.clear()
        return dfs(nums)
    }

    private fun dfs(nums: List<Double>): Boolean {
        // Terminal: single number close to target
        if (nums.size == 1) return isClose(nums[0], TARGET)

        // Memo key: normalize numbers (sort + quantize to stabilize floats)
        val key = normalize(nums)
        if (!seen.add(key)) return false

        // Try all unordered pairs (i < j)
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val a = nums[i]
                val b = nums[j]

                // Remaining numbers after removing i and j
                val rest = ArrayList<Double>(nums.size - 1)
                for (k in nums.indices) if (k != i && k != j) rest.add(nums[k])

                // Generate candidate results from (a, b)
                for (v in combine(a, b)) {
                    // Small pruning: if intermediate grows absurdly, skip (optional)
                    // if (abs(v) > 1e6) continue

                    val next = ArrayList<Double>(rest.size + 1)
                    next.addAll(rest)
                    next.add(v)
                    if (dfs(next)) return true
                }
            }
        }
        return false
    }

    private fun combine(a: Double, b: Double): Sequence<Double> = sequence {
        // Commutative: do once
        yield(a + b)
        yield(a * b)

        // Non-commutative: do both
        yield(a - b)
        yield(b - a)

        if (!isClose(b, 0.0)) yield(a / b)
        if (!isClose(a, 0.0)) yield(b / a)
    }

    private fun isClose(x: Double, y: Double) = abs(x - y) < EPS

    private fun normalize(nums: List<Double>): String {
        // Round to 4 decimals and sort
        val q = nums.map { round(it * 1e4) / 1e4 }.sorted()
        return q.joinToString(",")
    }
}
