package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/5
class Day5 {
    fun star1(input: List<String>): Long {
        // 1. Parse input
        //   - till to the empty line we pick up range pairs
        //   - after new line we pick up the numbers to check
        val ranges = mutableListOf<Pair<Long, Long>>()
        val numbers = mutableListOf<Long>()
        for (s in input) {
            if (s.isEmpty()) {
                // switch to numbers parsing
                continue
            }
            if (s.contains("-")) {
                val parts = s.split("-")
                val start = parts[0].toLong()
                val end = parts[1].toLong()
                ranges.add(Pair(start, end))
            } else {
                val number = s.toLong()
                numbers.add(number)
            }
        }
        // 2. For each range check how many ranges it falls into
        var ans = 0L
        for (number in numbers) {
            for (range in ranges) {
                if (number in range.first..range.second) {
                    ++ans
                    break
                }
            }
        }
        // 3. Return the count of numbers that fall into at least one range
        return ans
    }

    fun star2(input: List<String>): Long {
        // 1. Parse input
        //   - till to the empty line we pick up range pairs
        //   - after new line we pick up the numbers to check
        val ranges = mutableListOf<Pair<Long, Long>>()
        for (s in input) {
            if (s.contains("-")) {
                val parts = s.split("-")
                val start = parts[0].toLong()
                val end = parts[1].toLong()
                ranges.add(Pair(start, end))
            }
        }
        // 2. For each range check how many ranges it falls into
        ranges.sortBy { it.first }

        // 3. Merge overlapping ranges and count unique numbers
        var ans = 0L
        var currentStart = ranges[0].first
        var currentEnd = ranges[0].second

        for (i in 1 until ranges.size) {
            val (start, end) = ranges[i]

            if (start <= currentEnd + 1) {
                // Overlapping or adjacent ranges - merge them
                currentEnd = maxOf(currentEnd, end)
            } else {
                // Non-overlapping - count current range and start new one
                ans += currentEnd - currentStart + 1
                currentStart = start
                currentEnd = end
            }
        }

        // Add the last range
        ans += currentEnd - currentStart + 1

        // 3. Return the count of numbers that fall into at least one range
        return ans
    }
}
