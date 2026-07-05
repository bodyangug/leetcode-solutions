package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-paths-with-max-score
class NumberOfPathsWithMaxScore {
    private val mod = 1_000_000_007
    fun pathsWithMaxScore(board: List<String>): IntArray {
        val n = board.size
        val bestScore = Array(n) { IntArray(n) { -1 } }
        val ways = Array(n) { IntArray(n) }

        bestScore[n - 1][n - 1] = 0
        ways[n - 1][n - 1] = 1

        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (i == n - 1 && j == n - 1) continue
                if (board[i][j] == 'X') continue

                var maxNextScore = -1
                var pathCount = 0L

                val candidates = arrayOf(
                    intArrayOf(i + 1, j),
                    intArrayOf(i, j + 1),
                    intArrayOf(i + 1, j + 1),
                )

                for ((ni, nj) in candidates) {
                    if (ni >= n || nj >= n || ways[ni][nj] == 0) continue

                    val nextScore = bestScore[ni][nj]
                    if (nextScore > maxNextScore) {
                        maxNextScore = nextScore
                        pathCount = ways[ni][nj].toLong()
                    } else if (nextScore == maxNextScore) {
                        pathCount = (pathCount + ways[ni][nj]) % mod
                    }
                }

                if (maxNextScore == -1) continue

                val cellValue = when (val ch = board[i][j]) {
                    'E', 'S' -> 0
                    else -> ch - '0'
                }
                bestScore[i][j] = maxNextScore + cellValue
                ways[i][j] = (pathCount % mod).toInt()
            }
        }

        if (ways[0][0] == 0) {
            return intArrayOf(0, 0)
        }
        return intArrayOf(bestScore[0][0], ways[0][0])
    }
}
