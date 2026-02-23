package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k
class CheckIfStringContainsAllBinaryCodesOfSizeK {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val requiredCodes = 1 shl k
        val seenCodes = mutableSetOf<String>()

        for (i in 0..s.length - k) {
            val code = s.substring(i, i + k)
            seenCodes.add(code)
            if (seenCodes.size == requiredCodes) {
                return true // All codes are found
            }
        }
        return false // Not all codes are found
    }
}
