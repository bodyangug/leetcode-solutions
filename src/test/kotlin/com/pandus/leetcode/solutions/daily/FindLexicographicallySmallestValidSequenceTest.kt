package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindLexicographicallySmallestValidSequenceTest {
    private val solution = FindLexicographicallySmallestValidSequence()

    @Test
    fun `test exact match without change`() {
        assertArrayEquals(intArrayOf(0, 1, 2), solution.validSequence("vbcca", "abc"))
    }

    @Test
    fun `test uses single change`() {
        assertArrayEquals(intArrayOf(1, 2, 4), solution.validSequence("bacdc", "abc"))
    }

    @Test
    fun `test no valid sequence`() {
        assertArrayEquals(IntArray(0), solution.validSequence("aaaaaa", "aaabc"))
    }

    @Test
    fun `test change at first position`() {
        assertArrayEquals(intArrayOf(0, 1), solution.validSequence("bc", "ab"))
    }

    @Test
    fun `test single character exact`() {
        assertArrayEquals(intArrayOf(0), solution.validSequence("a", "a"))
    }

    @Test
    fun `test single character with change`() {
        assertArrayEquals(intArrayOf(0), solution.validSequence("b", "a"))
    }

    @Test
    fun `test change chosen as early as possible`() {
        assertArrayEquals(intArrayOf(0, 1, 2), solution.validSequence("aabc", "abc"))
    }

    @Test
    fun `test full length equal to word2`() {
        assertArrayEquals(intArrayOf(0, 1, 2), solution.validSequence("abc", "abc"))
    }
}
