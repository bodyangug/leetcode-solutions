package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedIITest {
    private val solver = DeleteColumnsToMakeSortedII()

    @Test
    @DisplayName("Example 1: ['ca','bb','ac'] -> 1 column to delete")
    fun minDeletionSize_example1() {
        val strs = arrayOf("ca", "bb", "ac")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Example 2: ['xc','yb','za'] -> 0 columns to delete")
    fun minDeletionSize_example2() {
        val strs = arrayOf("xc", "yb", "za")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Example 3: ['zyx','wvu','tsr'] -> 3 columns to delete")
    fun minDeletionSize_example3() {
        val strs = arrayOf("zyx", "wvu", "tsr")
        val expected = 3
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Already in lexicographic order: ['abc','bcd','cde'] -> 0 columns to delete")
    fun minDeletionSize_alreadySorted() {
        val strs = arrayOf("abc", "bcd", "cde")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single string: ['abc'] -> 0 columns to delete")
    fun minDeletionSize_singleString() {
        val strs = arrayOf("abc")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Complex case with partial ordering: ['baa','bab','bac'] -> 0 columns to delete")
    fun minDeletionSize_partialOrdering() {
        val strs = arrayOf("baa", "bab", "bac")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single character strings: ['a','b','c'] -> 0 columns to delete")
    fun minDeletionSize_singleCharStrings() {
        val strs = arrayOf("a", "b", "c")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Reverse order single characters: ['c','b','a'] -> 1 column to delete")
    fun minDeletionSize_reverseOrderSingleChar() {
        val strs = arrayOf("c", "b", "a")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }
}
