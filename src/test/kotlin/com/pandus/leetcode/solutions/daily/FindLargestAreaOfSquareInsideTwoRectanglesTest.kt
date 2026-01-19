package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLargestAreaOfSquareInsideTwoRectanglesTest {
    private val solution = FindLargestAreaOfSquareInsideTwoRectangles()

    @Test
    fun `example 1 - intersecting rectangles with side length 1`() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 1))
        val topRight = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(6, 6))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result)
    }

    @Test
    fun `example 2 - intersecting rectangles with side length 2`() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(1, 5))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(5, 7), intArrayOf(5, 9))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(4L, result)
    }

    @Test
    fun `example 3 - multiple intersections with side length 1`() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(1, 2))
        val topRight = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(3, 4))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result)
    }

    @Test
    fun `example 4 - no intersecting rectangles`() {
        val bottomLeft = arrayOf(intArrayOf(1, 1), intArrayOf(3, 3), intArrayOf(3, 1))
        val topRight = arrayOf(intArrayOf(2, 2), intArrayOf(4, 4), intArrayOf(4, 2))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result)
    }

    @Test
    fun `two identical rectangles - full overlap`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(5, 5))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(25L, result)
    }

    @Test
    fun `two rectangles with partial overlap - wide intersection`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(2, 0))
        val topRight = arrayOf(intArrayOf(10, 3), intArrayOf(8, 4))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(9L, result) // side = 3
    }

    @Test
    fun `two rectangles with partial overlap - narrow intersection`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))
        val topRight = arrayOf(intArrayOf(5, 2), intArrayOf(6, 6))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result) // side = 1
    }

    @Test
    fun `three rectangles with different overlaps`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(5, 5), intArrayOf(10, 0))
        val topRight = arrayOf(intArrayOf(10, 10), intArrayOf(15, 15), intArrayOf(20, 10))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(25L, result) // rectangles 0 and 1 overlap with side = 5
    }

    @Test
    fun `rectangles touching at edges - no area`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(5, 0))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(10, 5))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result)
    }

    @Test
    fun `rectangles with point intersection only`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(5, 5))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(10, 10))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result)
    }

    @Test
    fun `one rectangle inside another`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(2, 2))
        val topRight = arrayOf(intArrayOf(10, 10), intArrayOf(8, 8))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(36L, result) // side = 6
    }

    @Test
    fun `multiple pairs with different intersection sizes`() {
        val bottomLeft = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(5, 5),
            intArrayOf(10, 10),
            intArrayOf(15, 15)
        )
        val topRight = arrayOf(
            intArrayOf(10, 10),
            intArrayOf(15, 15),
            intArrayOf(20, 20),
            intArrayOf(25, 25)
        )

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(25L, result) // multiple 5x5 overlaps
    }

    @Test
    fun `tall and wide rectangles intersection`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(2, 0))
        val topRight = arrayOf(intArrayOf(3, 10), intArrayOf(10, 2))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result) // width = 1, height = 2, side = min(1, 2) = 1
    }

    @Test
    fun `minimum input - two rectangles`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))
        val topRight = arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result)
    }

    @Test
    fun `large coordinates with significant overlap`() {
        val bottomLeft = arrayOf(intArrayOf(1000, 1000), intArrayOf(1050, 1050))
        val topRight = arrayOf(intArrayOf(2000, 2000), intArrayOf(1500, 1500))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(202500L, result) // side = 450
    }

    @Test
    fun `rectangles separated horizontally`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(10, 0))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(15, 5))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result)
    }

    @Test
    fun `rectangles separated vertically`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(0, 10))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(5, 15))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result)
    }

    @Test
    fun `small overlap in corner`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(4, 4))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(10, 10))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(1L, result)
    }

    @Test
    fun `rectangles with negative coordinates`() {
        val bottomLeft = arrayOf(intArrayOf(-5, -5), intArrayOf(-3, -3))
        val topRight = arrayOf(intArrayOf(5, 5), intArrayOf(3, 3))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(36L, result) // side = 6
    }

    @Test
    fun `unit square intersections`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0))
        val topRight = arrayOf(intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 1))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(0L, result) // all adjacent, no overlap
    }

    @Test
    fun `large area with precise overlap`() {
        val bottomLeft = arrayOf(intArrayOf(0, 0), intArrayOf(100, 100))
        val topRight = arrayOf(intArrayOf(200, 200), intArrayOf(300, 300))

        val result = solution.largestSquareArea(bottomLeft, topRight)

        assertEquals(10000L, result) // side = 100
    }
}
