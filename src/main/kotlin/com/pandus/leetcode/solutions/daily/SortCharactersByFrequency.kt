package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sort-characters-by-frequency
class SortCharactersByFrequency {
    fun frequencySort(s: String): String {
        return s.groupingBy { it }
            .eachCount()
            .entries
            .sortedByDescending { it.value }
            .joinToString(separator = "") { (char, freq) -> char.toString().repeat(freq) }
    }
}
