package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/ones-and-zeroes
class OnesAndZeroes {
    fun findMaxForm(
        strs: Array<String>,
        m: Int,
        n: Int,
    ): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (str in strs) {
            val (zeroCount, oneCount) = countBits(str)

            for (zeroCapacity in m downTo zeroCount) {
                for (oneCapacity in n downTo oneCount) {
                    val includeCurrentString = dp[zeroCapacity - zeroCount][oneCapacity - oneCount] + 1
                    dp[zeroCapacity][oneCapacity] = maxOf(
                        dp[zeroCapacity][oneCapacity],
                        includeCurrentString,
                    )
                }
            }
        }

        return dp[m][n]
    }

    private fun countBits(binaryString: String): Pair<Int, Int> {
        val zeroCount = binaryString.count { it == '0' }
        val oneCount = binaryString.length - zeroCount
        return zeroCount to oneCount
    }
}
