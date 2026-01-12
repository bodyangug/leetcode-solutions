package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeVisitingAllPointsTest {
    private val solution = MinimumTimeVisitingAllPoints()

    @Test
    fun `test example 1 - three points with diagonal and straight moves`() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))
        val expected = 7
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test example 2 - two points`() {
        val points = arrayOf(intArrayOf(3, 2), intArrayOf(-2, 2))
        val expected = 5
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test single point - no movement needed`() {
        val points = arrayOf(intArrayOf(0, 0))
        val expected = 0
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test two adjacent points - one step diagonal`() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))
        val expected = 1
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test horizontal movement only`() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(5, 0))
        val expected = 5
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test vertical movement only`() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 7))
        val expected = 7
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test pure diagonal movement`() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(3, 3))
        val expected = 3
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test L-shaped movement - diagonal then straight`() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(2, 5))
        val expected = 5 // 2 diagonal + 3 vertical
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test multiple points in a line`() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        val expected = 3
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test negative coordinates`() {
        val points = arrayOf(intArrayOf(-5, -5), intArrayOf(-2, -2))
        val expected = 3
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test mixed positive and negative coordinates`() {
        val points = arrayOf(intArrayOf(-3, -2), intArrayOf(3, 2))
        val expected = 6
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test zigzag pattern`() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3)
        )
        val expected = 3 // (0,0)->(1,1)=1, (1,1)->(0,2)=1, (0,2)->(1,3)=1
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test square path`() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 0),
            intArrayOf(0, 0)
        )
        val expected = 4
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test same point twice - no movement between duplicates`() {
        val points = arrayOf(intArrayOf(5, 5), intArrayOf(5, 5))
        val expected = 0
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test large coordinates`() {
        val points = arrayOf(intArrayOf(1000, 1000), intArrayOf(-1000, -1000))
        val expected = 2000
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }

    @Test
    fun `test moving backwards then forwards`() {
        val points = arrayOf(
            intArrayOf(5, 5),
            intArrayOf(0, 0),
            intArrayOf(10, 10)
        )
        val expected = 15 // 5 + 10
        assertEquals(expected, solution.minTimeToVisitAllPoints(points))
    }
}
