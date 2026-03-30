package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringsCanBeMadeEqualWithOperationsIITest {
    private val solution = CheckIfStringsCanBeMadeEqualWithOperationsII()

    @Test
    fun checkStrings_example1_returnsTrue() {
        assertTrue(solution.checkStrings("abcdba", "cabdab"))
    }

    @Test
    fun checkStrings_example2_returnsFalse() {
        assertFalse(solution.checkStrings("abe", "bea"))
    }

    @Test
    fun checkStrings_identicalStrings_returnsTrue() {
        assertTrue(solution.checkStrings("abc", "abc"))
    }

    @Test
    fun checkStrings_singleCharEqual_returnsTrue() {
        assertTrue(solution.checkStrings("a", "a"))
    }

    @Test
    fun checkStrings_singleCharDifferent_returnsFalse() {
        assertFalse(solution.checkStrings("a", "b"))
    }

    @Test
    fun checkStrings_twoCharsSwapped_returnsFalse() {
        assertFalse(solution.checkStrings("ab", "ba"))
    }

    @Test
    fun checkStrings_evenIndicesMatch_oddDiffer_returnsFalse() {
        assertFalse(solution.checkStrings("abcd", "abdc"))
    }

    @Test
    fun checkStrings_oddIndicesSwappable_returnsTrue() {
        assertTrue(solution.checkStrings("aabb", "aabb"))
    }

    @Test
    fun checkStrings_allSameChars_returnsTrue() {
        assertTrue(solution.checkStrings("aaaa", "aaaa"))
    }

    @Test
    fun checkStrings_evenSwapNeeded_returnsTrue() {
        assertTrue(solution.checkStrings("abab", "abab"))
    }

    @Test
    fun checkStrings_complexSwap_returnsTrue() {
        assertTrue(solution.checkStrings("dcba", "bcda"))
    }
}
