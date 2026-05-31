package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DestroyingAsteroidsTest {
    private val solver = DestroyingAsteroids()

    @Test
    @DisplayName("Example 1: mass = 10, asteroids = [3,9,19,5,21] -> true")
    fun asteroidsDestroyed_example1() {
        val mass = 10
        val asteroids = intArrayOf(3, 9, 19, 5, 21)
        val expected = true
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Example 2: mass = 5, asteroids = [4,9,23,4] -> false")
    fun asteroidsDestroyed_example2() {
        val mass = 5
        val asteroids = intArrayOf(4, 9, 23, 4)
        val expected = false
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Edge case: single asteroid smaller than mass -> true")
    fun asteroidsDestroyed_singleSmallerAsteroid() {
        val mass = 10
        val asteroids = intArrayOf(5)
        val expected = true
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Edge case: single asteroid larger than mass -> false")
    fun asteroidsDestroyed_singleLargerAsteroid() {
        val mass = 5
        val asteroids = intArrayOf(10)
        val expected = false
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Edge case: single asteroid equal to mass -> true")
    fun asteroidsDestroyed_singleEqualAsteroid() {
        val mass = 10
        val asteroids = intArrayOf(10)
        val expected = true
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("All asteroids smaller than initial mass -> true")
    fun asteroidsDestroyed_allSmaller() {
        val mass = 100
        val asteroids = intArrayOf(1, 2, 3, 4, 5)
        val expected = true
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Mass grows incrementally to destroy all -> true")
    fun asteroidsDestroyed_incrementalGrowth() {
        val mass = 1
        val asteroids = intArrayOf(1, 2, 4, 8)
        val expected = true
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }

    @Test
    @DisplayName("Cannot destroy second asteroid even after first -> false")
    fun asteroidsDestroyed_failsAtSecond() {
        val mass = 1
        val asteroids = intArrayOf(1, 100)
        val expected = false
        assertEquals(expected, solver.asteroidsDestroyed(mass, asteroids))
    }
}
