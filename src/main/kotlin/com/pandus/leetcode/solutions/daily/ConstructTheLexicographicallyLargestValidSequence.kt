package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence
class ConstructTheLexicographicallyLargestValidSequence {
    fun constructDistancedSequence(targetNumber: Int): IntArray {
        val resultSequence = IntArray(targetNumber * 2 - 1)
        var isNumberUsed = 0 // Bitmask instead of BooleanArray

        fun backtrack(currentIndex: Int): Boolean {
            if (currentIndex == resultSequence.size) return true
            if (resultSequence[currentIndex] != 0) return backtrack(currentIndex + 1)

            for (numberToPlace in targetNumber downTo 1) {
                val mask = 1 shl numberToPlace
                if ((isNumberUsed and mask) != 0) continue  // Check bitmask for used numbers

                isNumberUsed = isNumberUsed or mask
                resultSequence[currentIndex] = numberToPlace

                if (numberToPlace == 1 || (currentIndex + numberToPlace < resultSequence.size && resultSequence[currentIndex + numberToPlace] == 0)) {
                    if (numberToPlace > 1) resultSequence[currentIndex + numberToPlace] = numberToPlace

                    if (backtrack(currentIndex + 1)) return true

                    if (numberToPlace > 1) resultSequence[currentIndex + numberToPlace] = 0
                }

                resultSequence[currentIndex] = 0
                isNumberUsed = isNumberUsed xor mask  // Unset bitmask
            }
            return false
        }

        backtrack(0)
        return resultSequence
    }

}
