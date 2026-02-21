package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation
class PrimeNumberOfSetBitsInBinaryRepresentation {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        val primeSetBits = setOf(2, 3, 5, 7, 11, 13, 17, 19) // Primes up to 20 (max bits for 10^6)
        var count = 0

        for (num in left..right) {
            val setBits = Integer.bitCount(num)
            if (setBits in primeSetBits) {
                count++
            }
        }

        return count
    }
}
