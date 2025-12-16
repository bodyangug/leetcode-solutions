package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts
class MaximumProfitFromTradingStocksWithDiscounts {
    data class Result(
        var dp0: IntArray,
        var dp1: IntArray,
        var size: Int
    )

    fun maxProfit(
        n: Int,
        present: IntArray,
        future: IntArray,
        hierarchy: Array<IntArray>,
        budget: Int
    ): Int {
        val g: Array<MutableList<Int>> = Array(n) { mutableListOf() }
        for (i in 0..<n) {
            g[i] = ArrayList()
        }
        for (e in hierarchy) {
            g[e[0] - 1].add(e[1] - 1)
        }

        return dfs(0, present, future, g, budget).dp0[budget]
    }

    private fun dfs(
        u: Int,
        present: IntArray,
        future: IntArray,
        g: Array<MutableList<Int>>,
        budget: Int
    ): Result {
        val cost = present[u]
        val dCost = present[u] / 2
        // dp[u][state][budget]
        // state = 0: Do not purchase parent node, state = 1: Must purchase parent node
        val dp0 = IntArray(budget + 1)
        val dp1 = IntArray(budget + 1)

        // subProfit[state][budget]
        // state = 0: discount not available, state = 1: discount available
        val subProfit0 = IntArray(budget + 1)
        val subProfit1 = IntArray(budget + 1)
        var uSize = cost

        for (v in g[u]) {
            val childResult: Result = dfs(v, present, future, g, budget)
            uSize += childResult.size

            for (i in budget downTo 0) {
                for (sub in 0..childResult.size.coerceAtMost(i)) {
                    if (i - sub >= 0) {
                        subProfit0[i] = subProfit0[i].coerceAtLeast(subProfit0[i - sub] + childResult.dp0[sub])
                        subProfit1[i] = subProfit1[i].coerceAtLeast(subProfit1[i - sub] + childResult.dp1[sub])
                    }
                }
            }
        }

        for (i in 0..budget) {
            dp0[i] = subProfit0[i]
            dp1[i] = subProfit0[i]
            if (i >= dCost) {
                dp1[i] = max(
                    subProfit0[i],
                    subProfit1[i - dCost] + future[u] - dCost
                )
            }
            if (i >= cost) {
                dp0[i] = max(
                    subProfit0[i],
                    subProfit1[i - cost] + future[u] - cost
                )
            }
        }
        return Result(dp0, dp1, uSize)
    }
}
