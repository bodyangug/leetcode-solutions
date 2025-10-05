package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CandyTest {

    private val solution = Candy()

    @Test
    fun testExample1() {
        val ratings = intArrayOf(1, 0, 2)
        assertEquals(5, solution.candy(ratings)) // [2,1,2] = 5 candies
    }

    @Test
    fun testExample2() {
        val ratings = intArrayOf(1, 2, 2)
        assertEquals(4, solution.candy(ratings)) // [1,2,1] = 4 candies
    }

    @Test
    fun testIncreasingRatings() {
        val ratings = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(15, solution.candy(ratings)) // [1,2,3,4,5] = 15 candies
    }

    @Test
    fun testDecreasingRatings() {
        val ratings = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(15, solution.candy(ratings)) // [5,4,3,2,1] = 15 candies
    }

    @Test
    fun testAllSameRatings() {
        val ratings = intArrayOf(1, 1, 1, 1)
        assertEquals(4, solution.candy(ratings)) // [1,1,1,1] = 4 candies
    }

    @Test
    fun testSingleChild() {
        val ratings = intArrayOf(1)
        assertEquals(1, solution.candy(ratings))
    }

    @Test
    fun testMountainPattern() {
        val ratings = intArrayOf(1, 3, 2, 2, 1)
        assertEquals(7, solution.candy(ratings)) // [1,2,1,2,1] = 7 candies
    }
}
