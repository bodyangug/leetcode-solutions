package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day9Test {
    private val day9 = Day9()

    @Nested
    @DisplayName("Star 1 - Largest rectangle with red tiles at opposite corners")
    inner class Star1Tests {

        @Test
        fun `should find largest rectangle in example input - area 50`() {
            // Example from problem statement
            val input = listOf(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
            )
            val result = day9.star1(input)
            assertEquals(50L, result, "Largest rectangle between (2,1) and (11,5) should have area 50")
        }

        @Test
        fun `should handle minimal two-point rectangle`() {
            val input = listOf(
                "0,0",
                "1,1"
            )
            val result = day9.star1(input)
            assertEquals(4L, result, "2x2 rectangle has area 4")
        }

        @Test
        fun `should handle single point input`() {
            val input = listOf("5,5")
            val result = day9.star1(input)
            assertEquals(0L, result, "Single point cannot form a rectangle")
        }

        @Test
        fun `should handle two points on same x-axis`() {
            val input = listOf(
                "5,10",
                "5,20"
            )
            val result = day9.star1(input)
            assertEquals(0L, result, "Points on same vertical line cannot form valid rectangle")
        }

        @Test
        fun `should handle two points on same y-axis`() {
            val input = listOf(
                "10,5",
                "20,5"
            )
            val result = day9.star1(input)
            assertEquals(0L, result, "Points on same horizontal line cannot form valid rectangle")
        }

        @Test
        fun `should find rectangle with negative coordinates`() {
            val input = listOf(
                "-5,-5",
                "5,5"
            )
            val result = day9.star1(input)
            assertEquals(121L, result, "11x11 rectangle has area 121")
        }

        @Test
        fun `should handle multiple possible rectangles and find largest`() {
            val input = listOf(
                "0,0",
                "10,0",
                "0,10",
                "10,10"
            )
            val result = day9.star1(input)
            assertEquals(121L, result, "11x11 rectangle has area 121")
        }

        @Test
        fun `should calculate area correctly for example rectangle 7,1 to 11,7`() {
            // From problem: rectangle between (7,1) and (11,7) has area 35
            // Width: 11-7+1 = 5, Height: 7-1+1 = 7, Area: 5*7 = 35
            val input = listOf(
                "7,1",
                "11,7"
            )
            val result = day9.star1(input)
            assertEquals(35L, result, "Rectangle from (7,1) to (11,7) should have area 35")
        }

        @Test
        fun `should calculate area correctly for example rectangle 2,5 to 9,7`() {
            // From problem: rectangle between (2,5) and (9,7) has area 24
            // Width: 9-2+1 = 8, Height: 7-5+1 = 3, Area: 8*3 = 24
            val input = listOf(
                "2,5",
                "9,7"
            )
            val result = day9.star1(input)
            assertEquals(24L, result, "Rectangle from (2,5) to (9,7) should have area 24")
        }

        @Test
        fun `should handle large coordinates without overflow`() {
            val input = listOf(
                "0,0",
                "1000,1000"
            )
            val result = day9.star1(input)
            assertEquals(1002001L, result, "1001x1001 rectangle")
        }
    }

    @Nested
    @DisplayName("Star 2 - Largest rectangle with red/green tiles only")
    inner class Star2Tests {

        @Test
        fun `should find largest valid rectangle in example input - area 24`() {
            // Example from problem statement - forms a closed loop
            val input = listOf(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
            )
            val result = day9.star2(input)
            assertEquals(24L, result, "Largest valid rectangle should have area 24")
        }

        @Test
        fun `should handle simple square loop`() {
            // Simple 4-point square
            val input = listOf(
                "0,0",
                "10,0",
                "10,10",
                "0,10"
            )
            val result = day9.star2(input)
            // The entire interior is green, so largest rectangle should be area 121 (11x11)
            assertEquals(121L, result, "Square loop should allow full interior rectangle")
        }

        @Test
        fun `should handle minimal triangle`() {
            val input = listOf(
                "0,0",
                "4,0",
                "2,2"
            )
            val result = day9.star2(input)
            // Should find some valid rectangle inside the triangle
            assert(result > 0L) { "Should find at least one valid rectangle" }
        }

        @Test
        fun `should handle L-shaped boundary`() {
            // L-shaped boundary
            val input = listOf(
                "0,0",
                "5,0",
                "5,3",
                "3,3",
                "3,5",
                "0,5"
            )
            val result = day9.star2(input)
            assert(result > 0L) { "Should find valid rectangle in L-shape" }
        }

        @Test
        fun `should handle single point`() {
            val input = listOf("5,5")
            val result = day9.star2(input)
            assertEquals(0L, result, "Single point cannot form a rectangle")
        }

        @Test
        fun `should handle two points forming degenerate loop`() {
            val input = listOf(
                "0,0",
                "10,10"
            )
            val result = day9.star2(input)
            // With just two points, the "loop" is degenerate
            assert(result >= 0L) { "Should handle two-point case gracefully" }
        }

        @Test
        fun `should verify rectangle from problem - area 15 between 7,3 and 11,1`() {
            // This rectangle should be valid in the example
            val input = listOf(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
            )
            val result = day9.star2(input)
            // The largest is 24, but rectangle of area 15 should be valid
            assert(result >= 15L) { "Should find at least area 15" }
        }

        @Test
        fun `should handle concave polygon`() {
            // Create a concave (non-convex) polygon
            val input = listOf(
                "0,0",
                "8,0",
                "8,4",
                "4,4",
                "4,2",
                "0,2"
            )
            val result = day9.star2(input)
            assert(result > 0L) { "Should handle concave polygons" }
        }

        @Test
        fun `should handle empty input`() {
            val input = emptyList<String>()
            val result = day9.star2(input)
            assertEquals(0L, result, "Empty input should return 0")
        }
    }

    @Nested
    @DisplayName("Integration tests with various shapes")
    inner class IntegrationTests {

        @Test
        fun `should handle rectangular boundary for both star1 and star2`() {
            val input = listOf(
                "0,0",
                "20,0",
                "20,10",
                "0,10"
            )
            val star1Result = day9.star1(input)
            val star2Result = day9.star2(input)

            assertEquals(231L, star1Result, "Star1: 21x11 rectangle")
            assertEquals(231L, star2Result, "Star2: Same area since it's a simple rectangle")
        }

        @Test
        fun `star2 should be less than or equal to star1 for same input`() {
            val input = listOf(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
            )
            val star1Result = day9.star1(input)
            val star2Result = day9.star2(input)

            assert(star2Result <= star1Result) {
                "Star2 result ($star2Result) should be <= Star1 result ($star1Result) " +
                        "since star2 has more constraints"
            }
        }

        @Test
        fun `should handle points with large coordinate gaps`() {
            val input = listOf(
                "0,0",
                "1000,0",
                "1000,1000",
                "0,1000"
            )
            // This tests coordinate compression in star2
            val star2Result = day9.star2(input)
            assert(star2Result > 0L) { "Should handle large coordinate gaps via compression" }
        }

        @Test
        fun `should handle zigzag pattern`() {
            val input = listOf(
                "0,0",
                "2,0",
                "2,2",
                "4,2",
                "4,4",
                "0,4"
            )
            val star1Result = day9.star1(input)
            val star2Result = day9.star2(input)

            assert(star1Result > 0L) { "Star1 should find some rectangle" }
            assert(star2Result >= 0L) { "Star2 should handle zigzag boundary" }
        }
    }

    @Nested
    @DisplayName("Edge cases and boundary conditions")
    inner class EdgeCaseTests {

        @Test
        fun `should handle points in a straight line`() {
            val input = listOf(
                "0,5",
                "5,5",
                "10,5",
                "15,5"
            )
            val result = day9.star1(input)
            assertEquals(0L, result, "Collinear points cannot form valid rectangles")
        }

        @Test
        fun `should handle duplicate points`() {
            val input = listOf(
                "5,5",
                "5,5",
                "10,10"
            )
            // Duplicate points should be treated as separate entries
            val result = day9.star1(input)
            assertEquals(36L, result, "6x6 rectangle despite duplicates")
        }

        @Test
        fun `should handle points with zero coordinates`() {
            val input = listOf(
                "0,0",
                "0,5",
                "5,0",
                "5,5"
            )
            val star1Result = day9.star1(input)
            assertEquals(36L, star1Result, "6x6 rectangle with zero coordinates")
        }

        @Test
        fun `should handle very small rectangle - 1x1`() {
            val input = listOf(
                "5,5",
                "5,6",
                "6,5",
                "6,6"
            )
            val star1Result = day9.star1(input)
            assertEquals(4L, star1Result, "2x2 minimal rectangle")
        }

        @Test
        fun `should handle mixed positive and negative coordinates`() {
            val input = listOf(
                "-10,-10",
                "10,-10",
                "10,10",
                "-10,10"
            )
            val star1Result = day9.star1(input)
            val star2Result = day9.star2(input)

            assertEquals(441L, star1Result, "21x21 rectangle")
            assertEquals(441L, star2Result, "Same area for simple square")
        }
    }
}
