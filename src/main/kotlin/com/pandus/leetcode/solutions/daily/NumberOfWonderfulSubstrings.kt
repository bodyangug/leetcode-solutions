package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-wonderful-substrings
class NumberOfWonderfulSubstrings {
    fun wonderfulSubstrings(word: String): Long {
        val freq = mutableMapOf<Int, Int>().withDefault { 0 }

        // The empty prefix can be the smaller prefix, which is handled like this
        freq[0] = 1
        var mask = 0
        var res = 0L
        for (c in word) {
            val bit = c.code - 'a'.code

            // Flip the parity of the c-th bit in the running prefix mask
            mask = mask xor (1 shl bit)

            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getValue(mask).toLong()

            // Increment value associated with mask by 1
            freq[mask] = freq.getValue(mask) + 1

            // Loop through every possible letter that can appear an odd number of times in a substring
            for (oddC in 0..9) {
                res += freq.getValue(mask xor (1 shl oddC)).toLong()
            }
        }
        return res
    }
}
