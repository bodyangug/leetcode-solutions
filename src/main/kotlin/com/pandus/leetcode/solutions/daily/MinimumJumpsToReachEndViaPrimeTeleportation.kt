package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation
class MinimumJumpsToReachEndViaPrimeTeleportation {
    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n < 4) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    fun minJumps(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return 0

        // Collect all primes that appear as values
        val primes = mutableSetOf<Int>()
        for (v in nums) {
            if (isPrime(v)) primes.add(v)
        }

        // For each index, find which collected primes divide nums[i] via factorization
        val primeToIndices = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            var x = nums[i]
            var d = 2
            while (d.toLong() * d <= x) {
                if (x % d == 0) {
                    if (d in primes) {
                        primeToIndices.getOrPut(d) { mutableListOf() }.add(i)
                    }
                    while (x % d == 0) x /= d
                }
                d++
            }
            if (x > 1 && x in primes) {
                primeToIndices.getOrPut(x) { mutableListOf() }.add(i)
            }
        }

        // BFS
        val dist = IntArray(n) { -1 }
        dist[0] = 0
        val queue: ArrayDeque<Int> = ArrayDeque()
        queue.add(0)
        val usedPrimes = mutableSetOf<Int>()

        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()
            val d = dist[i]

            // Adjacent steps
            for (next in intArrayOf(i - 1, i + 1)) {
                if (next in 0 until n && dist[next] == -1) {
                    dist[next] = d + 1
                    if (next == n - 1) return dist[next]
                    queue.add(next)
                }
            }

            // Prime teleportation: only if nums[i] is prime
            if (isPrime(nums[i])) {
                val p = nums[i]
                if (p !in usedPrimes) {
                    usedPrimes.add(p)
                    for (j in primeToIndices[p] ?: emptyList()) {
                        if (dist[j] == -1) {
                            dist[j] = d + 1
                            if (j == n - 1) return dist[j]
                            queue.add(j)
                        }
                    }
                }
            }
        }
        return -1
    }
}
