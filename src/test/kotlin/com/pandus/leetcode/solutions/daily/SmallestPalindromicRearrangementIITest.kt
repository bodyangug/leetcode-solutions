package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementIITest {
    private val solver = SmallestPalindromicRearrangementII()

    @Test
    @DisplayName("Example 1: s=abba, k=2 -> baab")
    fun example1() {
        assertEquals("baab", solver.smallestPalindrome("abba", 2))
    }

    @Test
    @DisplayName("Example 2: s=aa, k=2 -> empty (k exceeds count)")
    fun example2() {
        assertEquals("", solver.smallestPalindrome("aa", 2))
    }

    @Test
    @DisplayName("Example 3: s=bacab, k=1 -> abcba")
    fun example3() {
        assertEquals("abcba", solver.smallestPalindrome("bacab", 1))
    }

    @Test
    @DisplayName("First rearrangement of abba is the smallest: abba")
    fun firstRearrangement() {
        assertEquals("abba", solver.smallestPalindrome("abba", 1))
    }

    @Test
    @DisplayName("Last rearrangement of bacab: bacab")
    fun lastRearrangement() {
        assertEquals("bacab", solver.smallestPalindrome("bacab", 2))
    }

    @Test
    @DisplayName("k beyond count for bacab returns empty")
    fun kBeyondCount() {
        assertEquals("", solver.smallestPalindrome("bacab", 3))
    }

    @Test
    @DisplayName("Single character string: k=1 -> a")
    fun singleCharacter() {
        assertEquals("a", solver.smallestPalindrome("a", 1))
    }

    @Test
    @DisplayName("Single character string: k=2 -> empty")
    fun singleCharacterKTooLarge() {
        assertEquals("", solver.smallestPalindrome("a", 2))
    }

    @Test
    @DisplayName("Only one rearrangement possible: aa, k=1 -> aa")
    fun onlyOneRearrangement() {
        assertEquals("aa", solver.smallestPalindrome("aa", 1))
    }

    @Test
    @DisplayName("Odd length with distinct pairs: aabaa first is aabaa")
    fun oddLengthDistinctFirst() {
        // half is "aa" only one permutation -> single palindrome
        assertEquals("aabaa", solver.smallestPalindrome("aabaa", 1))
        assertEquals("", solver.smallestPalindrome("aabaa", 2))
    }

    @Test
    @DisplayName("Odd length with two distinct halves: abcba variants")
    fun oddLengthTwoDistinct() {
        // s = "aabbc": counts a:2, b:2, c:1 -> half {a,b}, middle c
        // distinct halves lexicographically: "ab" -> abcba, "ba" -> bacab
        assertEquals("abcba", solver.smallestPalindrome("aabbc", 1))
        assertEquals("bacab", solver.smallestPalindrome("aabbc", 2))
        assertEquals("", solver.smallestPalindrome("aabbc", 3))
    }

    @Test
    @DisplayName("Three distinct characters, six half permutations")
    fun threeDistinctHalves() {
        // s = "aabbcc": half {a,b,c} -> 3! = 6 palindromes
        // half order: abc,acb,bac,bca,cab,cba
        assertEquals("abccba", solver.smallestPalindrome("aabbcc", 1))
        assertEquals("acbbca", solver.smallestPalindrome("aabbcc", 2))
        assertEquals("baccab", solver.smallestPalindrome("aabbcc", 3))
        assertEquals("bcaacb", solver.smallestPalindrome("aabbcc", 4))
        assertEquals("cabbac", solver.smallestPalindrome("aabbcc", 5))
        assertEquals("cbaabc", solver.smallestPalindrome("aabbcc", 6))
        assertEquals("", solver.smallestPalindrome("aabbcc", 7))
    }

    @Test
    @DisplayName("Repeated characters reduce distinct count: aaaabb")
    fun repeatedCharacters() {
        // half = a:2, b:1 -> permutations of "aab" = 3!/2! = 3: aab, aba, baa
        assertEquals("aabbaa", solver.smallestPalindrome("aaaabb", 1))
        assertEquals("abaaba", solver.smallestPalindrome("aaaabb", 2))
        assertEquals("baaaab", solver.smallestPalindrome("aaaabb", 3))
        assertEquals("", solver.smallestPalindrome("aaaabb", 4))
    }

    @Test
    @DisplayName("All identical characters: single palindrome regardless of length")
    fun allIdentical() {
        assertEquals("aaaa", solver.smallestPalindrome("aaaa", 1))
        assertEquals("", solver.smallestPalindrome("aaaa", 2))
    }

    @Test
    @DisplayName("Empty string: k=1 -> empty palindrome")
    fun emptyString() {
        assertEquals("", solver.smallestPalindrome("", 1))
    }
}
