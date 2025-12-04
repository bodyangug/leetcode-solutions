package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountCollisionsOnRoadTest {
    private val solver = CountCollisionsOnRoad()

    @Test
    @DisplayName("Example 1: RLRSLL - multiple collisions")
    fun countCollisions_example1() {
        assertEquals(5, solver.countCollisions("RLRSLL"))
        // L and R at start are trimmed, then count non-S between them
    }

    @Test
    @DisplayName("Example 2: LLRR - no collisions (leading L and trailing R)")
    fun countCollisions_example2() {
        assertEquals(0, solver.countCollisions("LLRR"))
        // All L on left and all R on right, no collisions
    }

    @Test
    @DisplayName("Example 3: RRRLLL - all cars in opposite directions meet")
    fun countCollisions_example3() {
        assertEquals(6, solver.countCollisions("RRRLLL"))
        // After trimming trailing L and leading R: RRLLL -> 5 non-S chars
    }

    @Test
    @DisplayName("Edge case: Single car moving right - no collision")
    fun countCollisions_singleR() {
        assertEquals(0, solver.countCollisions("R"))
        // Single car moving right, no collision
    }

    @Test
    @DisplayName("Edge case: Single car moving left - no collision")
    fun countCollisions_singleL() {
        assertEquals(0, solver.countCollisions("L"))
        // Single car moving left, no collision
    }

    @Test
    @DisplayName("Edge case: Single stationary car - no collision")
    fun countCollisions_singleS() {
        assertEquals(0, solver.countCollisions("S"))
        // Single stationary car, no collision
    }

    @Test
    @DisplayName("Two cars: RL - head-on collision")
    fun countCollisions_headOn_RL() {
        assertEquals(2, solver.countCollisions("RL"))
        // R and L collide head-on
    }

    @Test
    @DisplayName("Two cars: LR - no collision (moving apart)")
    fun countCollisions_apart_LR() {
        assertEquals(0, solver.countCollisions("LR"))
        // Cars moving apart, no collision
    }

    @Test
    @DisplayName("Car crashes into stationary: RS")
    fun countCollisions_RS() {
        assertEquals(1, solver.countCollisions("RS"))
        // R crashes into S
    }

    @Test
    @DisplayName("Car crashes into stationary: SL")
    fun countCollisions_SL() {
        assertEquals(1, solver.countCollisions("SL"))
        // L crashes into S
    }

    @Test
    @DisplayName("Stationary between opposite directions: RSL")
    fun countCollisions_RSL() {
        assertEquals(2, solver.countCollisions("RSL"))
        // R hits S, L hits S
    }

    @Test
    @DisplayName("Only left-moving cars - no collisions")
    fun countCollisions_allLeft() {
        assertEquals(0, solver.countCollisions("LLLLLL"))
        // All cars moving left, no collisions
    }

    @Test
    @DisplayName("Only right-moving cars - no collisions")
    fun countCollisions_allRight() {
        assertEquals(0, solver.countCollisions("RRRRRR"))
        // All cars moving right, no collisions
    }

    @Test
    @DisplayName("Only stationary cars - no collisions")
    fun countCollisions_allStationary() {
        assertEquals(0, solver.countCollisions("SSSSSS"))
        // All stationary, no collisions
    }

    @Test
    @DisplayName("Leading L are ignored: LLLRSL")
    fun countCollisions_leadingL() {
        assertEquals(2, solver.countCollisions("LLLRSL"))
        // Leading L are trimmed, then RSL -> 2 non-S
    }

    @Test
    @DisplayName("Trailing R are ignored: RSLRRR")
    fun countCollisions_trailingR() {
        assertEquals(2, solver.countCollisions("RSLRRR"))
        // Trailing R are trimmed, then RSL -> 2 non-S
    }

    @Test
    @DisplayName("Both leading L and trailing R ignored: LLRSLRR")
    fun countCollisions_leadingL_trailingR() {
        assertEquals(2, solver.countCollisions("LLRSLRR"))
        // Leading L and trailing R trimmed, then RSL -> 2 non-S
    }

    @Test
    @DisplayName("Complex case: RRLLLSSLRR")
    fun countCollisions_complex1() {
        assertEquals(6, solver.countCollisions("RRLLLSSLRR"))
        // Trim trailing RR, get RRLLLSSL -> count non-S = 6
    }

    @Test
    @DisplayName("Multiline input: two directions separated by newline")
    fun countCollisions_multiline() {
        assertEquals(4, solver.countCollisions("RL\nRL"))
        // First line: RL -> 2 collisions
        // Second line: RL -> 2 collisions
        // Total: 4
    }

    @Test
    @DisplayName("Multiline input: mixed scenarios")
    fun countCollisions_multiline_mixed() {
        assertEquals(2, solver.countCollisions("RR\nRL"))
        // First line: RR -> 0 collisions (trailing R)
        // Second line: RL -> 2 collisions
        // Total: 2
    }

    @Test
    @DisplayName("Empty string - no collisions")
    fun countCollisions_empty() {
        assertEquals(0, solver.countCollisions(""))
        // No cars, no collisions
    }

    @Test
    @DisplayName("All combinations: SRS")
    fun countCollisions_SRS() {
        assertEquals(1, solver.countCollisions("SRS"))
        // Only R is non-S between S and S
    }

    @Test
    @DisplayName("All combinations: SLS")
    fun countCollisions_SLS() {
        assertEquals(1, solver.countCollisions("SLS"))
        // Only L is non-S between S and S
    }

    @Test
    @DisplayName("Chain reaction: RRS")
    fun countCollisions_RRS() {
        assertEquals(2, solver.countCollisions("RRS"))
        // Both R crash into S
    }

    @Test
    @DisplayName("Chain reaction: SLL")
    fun countCollisions_SLL() {
        assertEquals(2, solver.countCollisions("SLL"))
        // Both L crash into S
    }
}
