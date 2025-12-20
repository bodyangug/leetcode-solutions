package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedTest {
    private val solver = DeleteColumnsToMakeSorted()

    @Test
    @DisplayName("Example 1: ['cba','daf','ghi'] -> 1 column to delete")
    fun minDeletionSize_example1() {
        val strs = arrayOf("cba", "daf", "ghi")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Example 2: ['a','b'] -> 0 columns to delete")
    fun minDeletionSize_example2() {
        val strs = arrayOf("a", "b")
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
    @DisplayName("All columns are sorted: ['abc','bcd','cde'] -> 0 columns to delete")
    fun minDeletionSize_allSorted() {
        val strs = arrayOf("abc", "bcd", "cde")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single row: ['abc'] -> 0 columns to delete")
    fun minDeletionSize_singleRow() {
        val strs = arrayOf("abc")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single column sorted: ['a','b','c'] -> 0 columns to delete")
    fun minDeletionSize_singleColumnSorted() {
        val strs = arrayOf("a", "b", "c")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single column unsorted: ['c','b','a'] -> 1 column to delete")
    fun minDeletionSize_singleColumnUnsorted() {
        val strs = arrayOf("c", "b", "a")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Columns with duplicate characters: ['aa','aa','aa'] -> 0 columns to delete")
    fun minDeletionSize_duplicateCharacters() {
        val strs = arrayOf("aa", "aa", "aa")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Last column unsorted, rest sorted: ['ab','bc','ca'] -> 1 column to delete")
    fun minDeletionSize_lastColumnUnsorted() {
        val strs = arrayOf("ab", "bc", "ca")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }
}
