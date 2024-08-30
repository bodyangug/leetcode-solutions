package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference:https://leetcode.com/problems/robot-collisions
class RobotCollisions {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val n = positions.size
        val indices = Array(n) { it }
        val result = mutableListOf<Int>()
        val stack = Stack<Int>()

        indices.sortWith { lhs, rhs -> positions[lhs].compareTo(positions[rhs]) }

        for (currentIndex in indices) {
            if (directions[currentIndex] == 'R') {
                stack.push(currentIndex)
            } else {
                while (stack.isNotEmpty() && healths[currentIndex] > 0) {
                    val topIndex = stack.pop()
                    when {
                        healths[topIndex] > healths[currentIndex] -> {
                            healths[topIndex] -= 1
                            healths[currentIndex] = 0
                            stack.push(topIndex)
                        }

                        healths[topIndex] < healths[currentIndex] -> {
                            healths[currentIndex] -= 1
                            healths[topIndex] = 0
                        }

                        else -> {
                            healths[currentIndex] = 0
                            healths[topIndex] = 0
                        }
                    }
                }
            }
        }

        for (index in 0 until n) {
            if (healths[index] > 0) {
                result.add(healths[index])
            }
        }
        return result
    }
}
