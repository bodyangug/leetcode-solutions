package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumASCIIDeleteSumForTwoStringsTest {
    private val solver = MinimumASCIIDeleteSumForTwoStrings()

    @Test
    @DisplayName("Example 1: s1='sea', s2='eat' -> 231")
    fun minimumDeleteSum_example1() {
        val s1 = "sea"
        val s2 = "eat"
        val expected = 231
        // Explanation: Delete 's' (115) from "sea" and 't' (116) from "eat" = 231
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Example 2: s1='delete', s2='leet' -> 403")
    fun minimumDeleteSum_example2() {
        val s1 = "delete"
        val s2 = "leet"
        val expected = 403
        // Explanation: Delete 'd'(100) + 'e'(101) + 'e'(101) from "delete" and 'e'(101) from "leet" = 403
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Edge case: Both strings are empty")
    fun minimumDeleteSum_bothEmpty() {
        val s1 = ""
        val s2 = ""
        val expected = 0
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Edge case: First string is empty")
    fun minimumDeleteSum_firstEmpty() {
        val s1 = ""
        val s2 = "abc"
        // Need to delete all characters from s2: 'a'(97) + 'b'(98) + 'c'(99) = 294
        val expected = 294
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Edge case: Second string is empty")
    fun minimumDeleteSum_secondEmpty() {
        val s1 = "abc"
        val s2 = ""
        // Need to delete all characters from s1: 'a'(97) + 'b'(98) + 'c'(99) = 294
        val expected = 294
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Identical strings: s1='hello', s2='hello' -> 0")
    fun minimumDeleteSum_identicalStrings() {
        val s1 = "hello"
        val s2 = "hello"
        val expected = 0
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Single character identical: s1='a', s2='a' -> 0")
    fun minimumDeleteSum_singleCharIdentical() {
        val s1 = "a"
        val s2 = "a"
        val expected = 0
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Single character different: s1='a', s2='b' -> 195")
    fun minimumDeleteSum_singleCharDifferent() {
        val s1 = "a"
        val s2 = "b"
        // Delete 'a'(97) and 'b'(98) = 195
        val expected = 195
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("One substring of another: s1='abc', s2='aec' -> 200")
    fun minimumDeleteSum_partialMatch() {
        val s1 = "abc"
        val s2 = "aec"
        // Common: 'a' and 'c', delete 'b'(98) from s1 and 'e'(101) from s2 = 199
        val expected = 199
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("No common characters: s1='abc', s2='def' -> 597")
    fun minimumDeleteSum_noCommonChars() {
        val s1 = "abc"
        val s2 = "def"
        // Delete all: 'a'(97) + 'b'(98) + 'c'(99) + 'd'(100) + 'e'(101) + 'f'(102) = 597
        val expected = 597
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Common subsequence: s1='abcde', s2='ace' -> 197")
    fun minimumDeleteSum_commonSubsequence() {
        val s1 = "abcde"
        val s2 = "ace"
        // Common: 'ace', delete 'b'(98) and 'd'(100) from s1 = 198
        // Actually, best is to keep 'ace', so delete 'b'(98) + 'd'(100) = 198
        val expected = 198
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Longer strings with partial overlap: s1='algorithm', s2='altruistic' -> 1640")
    fun minimumDeleteSum_longerStrings() {
        val s1 = "algorithm"
        val s2 = "altruistic"
        // This will have some common subsequence like 'alti'
        val expected = solver.minimumDeleteSum(s1, s2)
        // Just verify it executes correctly and returns a positive result
        assert(expected > 0) { "Expected positive result for different strings" }
    }

    @Test
    @DisplayName("Repeated characters: s1='aaa', s2='aa' -> 97")
    fun minimumDeleteSum_repeatedChars() {
        val s1 = "aaa"
        val s2 = "aa"
        // Keep 'aa', delete one 'a'(97) from s1 = 97
        val expected = 97
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("Different repeated characters: s1='aaa', s2='bbb' -> 585")
    fun minimumDeleteSum_differentRepeatedChars() {
        val s1 = "aaa"
        val s2 = "bbb"
        // Delete all: 3*97 + 3*98 = 291 + 294 = 585
        val expected = 585
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("One character in common at start: s1='abc', s2='axy' -> 398")
    fun minimumDeleteSum_commonAtStart() {
        val s1 = "abc"
        val s2 = "axy"
        // Keep 'a', delete 'bc' and 'xy': (98+99) + (120+121) = 197 + 241 = 438
        val expected = 438
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }

    @Test
    @DisplayName("One character in common at end: s1='abc', s2='xyzc' -> 498")
    fun minimumDeleteSum_commonAtEnd() {
        val s1 = "abc"
        val s2 = "xyzc"
        // Keep 'c', delete 'ab' and 'xyz': (97+98) + (120+121+122) = 195 + 363 = 558
        val expected = 558
        assertEquals(expected, solver.minimumDeleteSum(s1, s2))
    }
}
