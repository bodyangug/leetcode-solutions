package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumDistanceToTypeWordUsingTwoFingersTest {
    private val solver = MinimumDistanceToTypeWordUsingTwoFingers()

    @Test
    @DisplayName("Example 1: word='CAKE' -> 3")
    fun minimumDistance_example1() {
        // F1: C->A (cost 2), F2: K->E (cost 1)
        assertEquals(3, solver.minimumDistance("CAKE"))
    }

    @Test
    @DisplayName("Example 2: word='HAPPY' -> 6")
    fun minimumDistance_example2() {
        // F1: H->A (cost 2), F2: P->P (cost 0), F1: A->Y (cost 4)
        assertEquals(6, solver.minimumDistance("HAPPY"))
    }

    @Test
    @DisplayName("Single character: word='A' -> 0")
    fun minimumDistance_singleChar() {
        // Only one placement, no movement possible
        assertEquals(0, solver.minimumDistance("A"))
    }

    @Test
    @DisplayName("Two identical characters: word='AA' -> 0")
    fun minimumDistance_twoIdenticalChars() {
        // One finger stays on A, cost is always 0
        assertEquals(0, solver.minimumDistance("AA"))
    }

    @Test
    @DisplayName("Two distinct characters: word='AB' -> 0")
    fun minimumDistance_twoDistinctChars() {
        // F1 placed on A (cost 0), F2 placed on B (cost 0)
        assertEquals(0, solver.minimumDistance("AB"))
    }

    @Test
    @DisplayName("Max-distance characters: word='AZ' -> 0")
    fun minimumDistance_maxDistanceChars() {
        // A=(0,0), Z=(4,1) - far apart but free placement on two fingers
        assertEquals(0, solver.minimumDistance("AZ"))
    }

    @Test
    @DisplayName("All same characters: word='ZZZZ' -> 0")
    fun minimumDistance_allSameChars() {
        // One finger stays on Z throughout, no movement
        assertEquals(0, solver.minimumDistance("ZZZZ"))
    }

    @Test
    @DisplayName("Sequential alphabet: word='ABCDE' -> 3")
    fun minimumDistance_sequentialAlphabet() {
        // Optimal: F1 placed on A, F2 types B->C->D->E (cost 0+1+1+1=3)
        assertEquals(3, solver.minimumDistance("ABCDE"))
    }

    @Test
    @DisplayName("Alternating pattern: word='AZBZC' -> 2")
    fun minimumDistance_alternatingPattern() {
        // F1: A->B->C (cost 0+1+1=2), F2: Z->Z (cost 0+0=0) -> total 2
        assertEquals(2, solver.minimumDistance("AZBZC"))
    }
}
