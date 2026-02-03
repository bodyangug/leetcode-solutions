package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindSmallestLetterGreaterThanTargetTest {
    private val solver = FindSmallestLetterGreaterThanTarget()

    @Test
    @DisplayName("Example 1: letters = ['c','f','j'], target = 'a' -> 'c'")
    fun nextGreatestLetter_example1() {
        val letters = charArrayOf('c', 'f', 'j')
        val target = 'a'
        val expected = 'c'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Example 2: letters = ['c','f','j'], target = 'c' -> 'f'")
    fun nextGreatestLetter_example2() {
        val letters = charArrayOf('c', 'f', 'j')
        val target = 'c'
        val expected = 'f'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Example 3: letters = ['x','x','y','y'], target = 'z' -> 'x'")
    fun nextGreatestLetter_example3() {
        val letters = charArrayOf('x', 'x', 'y', 'y')
        val target = 'z'
        val expected = 'x'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Single letter array, target before letter")
    fun nextGreatestLetter_singleLetterBefore() {
        val letters = charArrayOf('c')
        val target = 'a'
        val expected = 'c'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Single letter array, target equal to letter")
    fun nextGreatestLetter_singleLetterEqual() {
        val letters = charArrayOf('c')
        val target = 'c'
        val expected = 'c'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Single letter array, target after letter")
    fun nextGreatestLetter_singleLetterAfter() {
        val letters = charArrayOf('c')
        val target = 'z'
        val expected = 'c'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: All same letters")
    fun nextGreatestLetter_allSame() {
        val letters = charArrayOf('a', 'a', 'a', 'a')
        val target = 'z'
        val expected = 'a'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Target in the middle of array")
    fun nextGreatestLetter_targetInMiddle() {
        val letters = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
        val target = 'c'
        val expected = 'd'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Target at the beginning")
    fun nextGreatestLetter_targetAtBeginning() {
        val letters = charArrayOf('a', 'b', 'c', 'd', 'e')
        val target = 'a'
        val expected = 'b'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Target at the end")
    fun nextGreatestLetter_targetAtEnd() {
        val letters = charArrayOf('a', 'b', 'c', 'd', 'e')
        val target = 'e'
        val expected = 'a'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Target before all letters")
    fun nextGreatestLetter_targetBeforeAll() {
        val letters = charArrayOf('d', 'f', 'j', 'k', 'z')
        val target = 'a'
        val expected = 'd'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Target after all letters")
    fun nextGreatestLetter_targetAfterAll() {
        val letters = charArrayOf('a', 'b', 'c', 'd', 'e')
        val target = 'z'
        val expected = 'a'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Two letters, target between them")
    fun nextGreatestLetter_twoLettersBetween() {
        val letters = charArrayOf('a', 'z')
        val target = 'm'
        val expected = 'z'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Two letters, target is first")
    fun nextGreatestLetter_twoLettersFirst() {
        val letters = charArrayOf('a', 'z')
        val target = 'a'
        val expected = 'z'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Two letters, target is last")
    fun nextGreatestLetter_twoLettersLast() {
        val letters = charArrayOf('a', 'z')
        val target = 'z'
        val expected = 'a'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Consecutive letters with duplicates")
    fun nextGreatestLetter_consecutiveWithDuplicates() {
        val letters = charArrayOf('a', 'b', 'b', 'c', 'c', 'd')
        val target = 'b'
        val expected = 'c'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Many duplicates at end")
    fun nextGreatestLetter_manyDuplicatesAtEnd() {
        val letters = charArrayOf('a', 'b', 'z', 'z', 'z', 'z')
        val target = 'y'
        val expected = 'z'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }

    @Test
    @DisplayName("Edge case: Many duplicates at start")
    fun nextGreatestLetter_manyDuplicatesAtStart() {
        val letters = charArrayOf('a', 'a', 'a', 'a', 'b', 'z')
        val target = 'a'
        val expected = 'b'
        assertEquals(expected, solver.nextGreatestLetter(letters, target))
    }
}
