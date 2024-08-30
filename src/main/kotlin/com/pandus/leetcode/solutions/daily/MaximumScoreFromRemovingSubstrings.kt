package com.pandus.leetcode.solutions.daily

import java.util.Stack
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-score-from-removing-substrings
class MaximumScoreFromRemovingSubstrings {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var totalScore = 0
        val highPriorityPair = if (x > y) "ab" else "ba"
        val lowPriorityPair = if (highPriorityPair == "ab") "ba" else "ab"

        // First pass: remove high priority pair
        val stringAfterFirstPass = removeSubstring(s, highPriorityPair)
        var removedPairsCount = (s.length - stringAfterFirstPass.length) / 2

        // Calculate score from first pass
        totalScore += removedPairsCount * max(x, y)

        // Second pass: remove low priority pair
        val stringAfterSecondPass = removeSubstring(stringAfterFirstPass, lowPriorityPair)
        removedPairsCount = (stringAfterFirstPass.length - stringAfterSecondPass.length) / 2

        // Calculate score from second pass
        totalScore += removedPairsCount * min(x, y)
        return totalScore
    }

    private fun removeSubstring(input: String, targetPair: String): String {
        val charStack = Stack<Char>()
        // Iterate through each character in the input string
        for (currentChar in input) {
            // Check if current character forms the target pair with the top of the stack
            if (currentChar == targetPair[1] &&
                !charStack.isEmpty() &&
                charStack.peek() == targetPair[0]
            ) {
                charStack.pop() // Remove the matching character from the stack
            } else {
                charStack.push(currentChar)
            }
        }
        // Reconstruct the remaining string after removing target pairs
        val remainingChars = StringBuilder()
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop())
        }
        return remainingChars.reverse().toString()
    }
}
