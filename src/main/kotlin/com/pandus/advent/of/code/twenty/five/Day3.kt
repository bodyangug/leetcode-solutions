package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/3/
class Day3 {

    fun star1(batteries: List<String>): Int {
        var ans = 0

        for (rawBank in batteries) {
            val digits = rawBank.map { it.digitToInt() }
            var maxJoltage = 0
            for (i in digits.indices) {
                for (j in i + 1 until digits.size) {
                    val joltage = digits[i] * 10 + digits[j]
                    maxJoltage = maxOf(maxJoltage, joltage)
                }
            }
            ans += maxJoltage
            println("bank: $rawBank, max joltage: $maxJoltage")
        }
        return ans
    }

    fun star2(batteries: List<String>): Long {
        var ans = 0L

        for (rawBank in batteries) {
            val digits = rawBank.map { it.digitToInt() }
            val selected = mutableListOf<Int>()
            var startIdx = 0

            // Select 12 digits greedily
            for (pick in 1..12) {
                val remainingToSelect = 12 - pick + 1
                val mustLeave = remainingToSelect - 1
                val searchEnd = digits.size - mustLeave

                // Find the maximum digit in the valid range
                var maxDigit = -1
                var maxIdx = -1
                for (i in startIdx until searchEnd) {
                    if (digits[i] > maxDigit) {
                        maxDigit = digits[i]
                        maxIdx = i
                    }
                }

                selected.add(maxDigit)
                startIdx = maxIdx + 1
            }

            val joltage = selected.joinToString("").toLong()
            ans += joltage
            println("bank: $rawBank, max joltage: $joltage")
        }

        return ans
    }
}
