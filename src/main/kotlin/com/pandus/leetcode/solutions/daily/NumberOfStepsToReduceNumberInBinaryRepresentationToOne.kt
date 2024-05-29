package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
class NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

    fun numSteps(s: String): Int {
        var steps = 0
        var carry = 0
        var index = s.length - 1

        while (index > 0) {
            if (s[index] - '0' + carry == 1) {
                carry = 1
                steps += 2
            } else {
                steps += 1
            }
            index--
        }
        return steps + carry
    }
}

fun main() {
    NumberOfStepsToReduceNumberInBinaryRepresentationToOne().numSteps("1101")
}