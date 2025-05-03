package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/push-dominoes
class PushDominoes {
    fun pushDominoes(dominoes: String): String {
        val n = dominoes.length
        val indexes = mutableListOf(-1)
        val symbols = mutableListOf('L')

        for (i in dominoes.indices) {
            if (dominoes[i] != '.') {
                indexes.add(i)
                symbols.add(dominoes[i])
            }
        }

        indexes.add(n)
        symbols.add('R')

        val result = dominoes.toCharArray()

        for (k in 0 until indexes.size - 1) {
            val i = indexes[k]
            val j = indexes[k + 1]
            val left = symbols[k]
            val right = symbols[k + 1]

            when {
                left == right -> {
                    for (p in i + 1 until j) result[p] = left
                }

                left == 'R' && right == 'L' -> {
                    var l = i + 1
                    var r = j - 1
                    while (l < r) {
                        result[l++] = 'R'
                        result[r--] = 'L'
                    }
                }
            }
        }
        return String(result)
    }
}
