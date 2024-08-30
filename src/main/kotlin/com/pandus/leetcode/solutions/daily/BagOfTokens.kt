package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/bag-of-tokens
class BagOfTokens {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        var power = power
        tokens.sort()
        var (low, high) = 0 to tokens.lastIndex
        var score = 0

        loop@ while (low <= high) {
            when {
                power >= tokens[low] -> {
                    score++
                    power -= tokens[low]
                    low++
                }

                low < high && score > 0 -> {
                    score--
                    power += tokens[high]
                    high--
                }

                else -> break@loop
            }
        }
        return score
    }
}
