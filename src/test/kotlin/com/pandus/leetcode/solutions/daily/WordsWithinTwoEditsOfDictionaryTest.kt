package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WordsWithinTwoEditsOfDictionaryTest {
    private val solution = WordsWithinTwoEditsOfDictionary()

    @Test
    @DisplayName("Example 1: queries=[word,note,ants,wood], dictionary=[wood,joke,moat] -> [word,note,wood]")
    fun testExample1() {
        val queries = arrayOf("word", "note", "ants", "wood")
        val dictionary = arrayOf("wood", "joke", "moat")
        assertEquals(listOf("word", "note", "wood"), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("Example 2: queries=[yes], dictionary=[not] -> []")
    fun testExample2() {
        val queries = arrayOf("yes")
        val dictionary = arrayOf("not")
        assertEquals(emptyList<String>(), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("Exact match requires zero edits")
    fun testExactMatch() {
        val queries = arrayOf("abc")
        val dictionary = arrayOf("abc")
        assertEquals(listOf("abc"), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("Single edit difference")
    fun testOneEdit() {
        val queries = arrayOf("abc")
        val dictionary = arrayOf("abc", "axc")
        assertEquals(listOf("abc"), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("Three edits means no match")
    fun testThreeEditsNoMatch() {
        val queries = arrayOf("abc")
        val dictionary = arrayOf("xyz")
        assertEquals(emptyList<String>(), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("All queries match")
    fun testAllQueriesMatch() {
        val queries = arrayOf("aa", "bb")
        val dictionary = arrayOf("ab")
        assertEquals(listOf("aa", "bb"), solution.twoEditWords(queries, dictionary))
    }

    @Test
    @DisplayName("Query matches via different dictionary words")
    fun testMultipleDictionaryWords() {
        val queries = arrayOf("abcd")
        val dictionary = arrayOf("xxxx", "abce")
        assertEquals(listOf("abcd"), solution.twoEditWords(queries, dictionary))
    }
}
