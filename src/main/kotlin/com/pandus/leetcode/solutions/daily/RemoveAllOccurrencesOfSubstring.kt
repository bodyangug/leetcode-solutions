package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/remove-all-occurrences-of-a-substring
class RemoveAllOccurrencesOfSubstring {
    fun removeOccurrences(s: String, part: String) =
        s.fold("") { r, c -> (r + c).removeSuffix(part) }
}
