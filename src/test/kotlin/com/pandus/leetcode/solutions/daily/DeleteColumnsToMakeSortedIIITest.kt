package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DeleteColumnsToMakeSortedIIITest {
    private val solver = DeleteColumnsToMakeSortedIII()

    @Test
    @DisplayName("Example 1: ['babca','bbazb'] -> 3 columns to delete")
    fun minDeletionSize_example1() {
        val strs = arrayOf("babca", "bbazb")
        val expected = 3
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Example 2: ['edcba'] -> 4 columns to delete")
    fun minDeletionSize_example2() {
        val strs = arrayOf("edcba")
        val expected = 4
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Example 3: ['ghi','def','abc'] -> 0 columns to delete")
    fun minDeletionSize_example3() {
        val strs = arrayOf("ghi", "def", "abc")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single character strings: ['a','b','c'] -> 0 columns to delete")
    fun minDeletionSize_singleCharacter() {
        val strs = arrayOf("a", "b", "c")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single string already sorted: ['abc'] -> 0 columns to delete")
    fun minDeletionSize_singleStringSorted() {
        val strs = arrayOf("abc")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Single string reverse sorted: ['cba'] -> 2 columns to delete")
    fun minDeletionSize_singleStringReverseSorted() {
        val strs = arrayOf("cba")
        val expected = 2
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("All rows already in lexicographic order: ['abc','bcd','cde'] -> 0 columns to delete")
    fun minDeletionSize_allRowsSorted() {
        val strs = arrayOf("abc", "bcd", "cde")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Two strings with mixed ordering: ['aaa','bbb'] -> 0 columns to delete")
    fun minDeletionSize_twoStringsSameChars() {
        val strs = arrayOf("aaa", "bbb")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Completely reverse order in all rows: ['dcba','dcba'] -> 3 columns to delete")
    fun minDeletionSize_completelyReversed() {
        val strs = arrayOf("dcba", "dcba")
        val expected = 3
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Partial ordering needed: ['adc','bdc'] -> 1 column to delete")
    fun minDeletionSize_partialOrdering() {
        val strs = arrayOf("adc", "bdc")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Complex case with multiple rows: ['abc','def','ghi'] -> 0 columns to delete")
    fun minDeletionSize_multipleRowsAllSorted() {
        val strs = arrayOf("abc", "def", "ghi")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Keep only middle columns: ['acb','adb'] -> 1 column to delete")
    fun minDeletionSize_keepMiddleColumns() {
        val strs = arrayOf("acb", "adb")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("All same characters: ['aaa','aaa','aaa'] -> 0 columns to delete")
    fun minDeletionSize_allSameCharacters() {
        val strs = arrayOf("aaa", "aaa", "aaa")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Alternating pattern: ['aba','aba'] -> 1 column to delete")
    fun minDeletionSize_alternatingPattern() {
        val strs = arrayOf("aba", "aba")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Long strings with complex pattern: ['abcdefg','bcdefgh'] -> 0 columns to delete")
    fun minDeletionSize_longStringsIncreasing() {
        val strs = arrayOf("abcdefg", "bcdefgh")
        val expected = 0
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Keep first and last columns only: ['azb','bzc'] -> 1 column to delete")
    fun minDeletionSize_keepFirstAndLast() {
        val strs = arrayOf("azb", "bzc")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Multiple strings with descending order: ['fed','dcb','cba'] -> 2 columns to delete")
    fun minDeletionSize_descendingOrder() {
        val strs = arrayOf("fed", "dcb", "cba")
        val expected = 2
        assertEquals(expected, solver.minDeletionSize(strs))
    }

    @Test
    @DisplayName("Two columns keep one: ['ba','ba'] -> 1 column to delete")
    fun minDeletionSize_twoColumnsKeepOne() {
        val strs = arrayOf("ba", "ba")
        val expected = 1
        assertEquals(expected, solver.minDeletionSize(strs))
    }
}
