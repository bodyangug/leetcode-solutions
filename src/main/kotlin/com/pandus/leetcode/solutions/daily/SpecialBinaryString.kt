package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/special-binary-string
class SpecialBinaryString {
    fun makeLargestSpecial(s: String): String {
        if (s.isEmpty() || s.length <= 2) return s

        val specials = mutableListOf<String>()
        var count = 0
        var start = 0

        for (i in s.indices) {
            // Treat '1' as +1 and '0' as -1
            count += if (s[i] == '1') 1 else -1

            // When count reaches 0, we found a complete special substring
            if (count == 0) {
                // Recursively process the inner part (excluding outer '1' and '0')
                val inner = s.substring(start + 1, i)
                specials.add("1${makeLargestSpecial(inner)}0")
                start = i + 1
            }
        }

        // Sort in descending order to get lexicographically largest result
        specials.sortDescending()

        return specials.joinToString("")
    }
}
