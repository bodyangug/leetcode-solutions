package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/2
class Day2 {

    fun star1(input: String): Long {
        val ranges = input.split(',').map { it.trim() }
        var sum = 0L
        val invalidIds = mutableListOf<Long>()

        for (range in ranges) {
            println("===========================")
            println("Processing range: $range")
            val parts = range.split('-')
            val a = parts[0].trim().toLong()
            val b = parts[1].trim().toLong()

            for (x in a..b) {
                if (isInvalid1(x)) {
                    println("Found invalid ID: $x")
                    sum += x
                    invalidIds.add(x)
                }
            }
        }
        return sum
    }

    private fun isInvalid1(num: Long): Boolean {
        val str = num.toString()
        val len = str.length

        if (len % 2 != 0) return false

        val half = len / 2
        val firstHalf = str.take(half)
        val secondHalf = str.substring(half)

        return firstHalf == secondHalf
    }

    fun star2(input: String): Long {
        val ranges = input.split(',').map { it.trim() }
        var sum = 0L
        val invalidIds = mutableListOf<Long>()

        for (range in ranges) {
            val parts = range.split('-')
            val a = parts[0].trim().toLong()
            val b = parts[1].trim().toLong()

            for (x in a..b) {
                if (isInvalid2(x)) {
                    sum += x
                    invalidIds.add(x)
                }
            }
        }

        return sum
    }

    private fun isInvalid2(num: Long): Boolean {
        val str = num.toString()
        val len = str.length

        for (patternLen in 1..len / 2) {
            if (len % patternLen == 0) {
                val pattern = str.take(patternLen)
                val repetitions = len / patternLen

                val repeated = pattern.repeat(repetitions)

                if (repeated == str && repetitions >= 2) {
                    return true
                }
            }
        }

        return false
    }
}
