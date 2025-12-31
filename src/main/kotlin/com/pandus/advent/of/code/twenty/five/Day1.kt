package com.pandus.advent.of.code.twenty.five

// Reference: https://adventofcode.com/2025/day/1
class Day1 {

    // Direct calculation approach, counting only when landing on position 0
    fun star1(input: List<String>): Int {
        var ans = 0
        var position = 50
        for (rotation in input) {
            val direction = rotation[0]
            val count = rotation.substring(1).toInt()

            when (direction) {
                'L' -> position = (position - count + 100) % 100
                'R' -> position = (position + count) % 100
            }
            if (position == 0) {
                ans++
            }
        }
        return ans
    }

    // Imitation approach, counting every crossing of position 0
    fun star2(input: List<String>): Int {
        var ans = 0
        var position = 50

        for (command in input) {
            println("=================")
            val direction = command[0]
            val count = command.substring(1).toInt()
            println("Direction: $command, Starting Position: $position")
            if (direction == 'L') {
                // Left rotation
                for (i in 1..count) {
                    position = if (position == 0) 99 else position - 1
                    if (position == 0) ans++
                }
            } else {
                // Right rotation
                for (i in 1..count) {
                    position = if (position == 99) 0 else position + 1
                    if (position == 0) ans++
                }
            }
            println("New position: $position")
            println("Answer: $ans")
        }
        return ans
    }
}
