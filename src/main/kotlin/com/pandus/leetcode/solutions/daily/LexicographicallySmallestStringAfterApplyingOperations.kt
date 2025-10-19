package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations
class LexicographicallySmallestStringAfterApplyingOperations {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val n = s.length
        val visited = BooleanArray(n)
        var best = s
        val doubled = s + s

        // Number of distinct additions we can produce on a given parity group.
        val cycleLen = 10 / gcd(a, 10)
        // Precompute the actual addition deltas (mod 10) for each step for reuse.
        val oddAddDeltas = IntArray(cycleLen) { (it * a) % 10 }
        // If b is odd, we can make originally even positions become odd via rotations, so both parity groups adjustable.
        val evenAddDeltas = if (b % 2 == 1) oddAddDeltas else intArrayOf(0)

        var idx = 0
        while (!visited[idx]) {
            visited[idx] = true
            // Base rotated substring (no additions yet)
            val base = doubled.substring(idx, idx + n).toCharArray()

            for (oddDelta in oddAddDeltas) {
                // Apply odd delta once and reuse result for all even deltas.
                val withOddApplied = base.clone()
                var p = 1
                while (p < n) {
                    withOddApplied[p] = addDigit(withOddApplied[p], oddDelta)
                    p += 2
                }

                if (evenAddDeltas.size == 1 && evenAddDeltas[0] == 0) {
                    val candStr = String(withOddApplied)
                    if (candStr < best) best = candStr
                } else {
                    for (evenDelta in evenAddDeltas) {
                        if (evenDelta == 0) {
                            val candStr = String(withOddApplied)
                            if (candStr < best) best = candStr
                        } else {
                            val candidate = withOddApplied.clone()
                            p = 0
                            while (p < n) {
                                candidate[p] = addDigit(candidate[p], evenDelta)
                                p += 2
                            }
                            val candStr = String(candidate)
                            if (candStr < best) best = candStr
                        }
                    }
                }
            }
            idx = (idx + b) % n
        }
        return best
    }

    private fun addDigit(ch: Char, delta: Int): Char {
        val original = ch.code - '0'.code
        return ('0'.code + (original + delta) % 10).toChar()
    }

    private fun gcd(x: Int, y: Int): Int {
        var a0 = x
        var b0 = y
        while (b0 != 0) {
            val t = a0 % b0
            a0 = b0
            b0 = t
        }
        return a0
    }
}
