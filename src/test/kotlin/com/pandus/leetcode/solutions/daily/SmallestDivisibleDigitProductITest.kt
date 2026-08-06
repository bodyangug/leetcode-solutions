package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductITest {
    private val solution = SmallestDivisibleDigitProductI()

    @Test
    fun smallestNumber_example1_returns10() {
        // digit product of 10 is 0, divisible by 2
        assertEquals(10, solution.smallestNumber(10, 2))
    }

    @Test
    fun smallestNumber_example2_returns16() {
        // digit product of 16 is 6, divisible by 3
        assertEquals(16, solution.smallestNumber(15, 3))
    }

    @Test
    fun smallestNumber_nAlreadySatisfies_returnsN() {
        // single digit n equal to t: product = n, divisible by t
        assertEquals(5, solution.smallestNumber(5, 5))
    }

    @Test
    fun smallestNumber_tIsOne_returnsN() {
        // every product is divisible by 1
        assertEquals(23, solution.smallestNumber(23, 1))
    }

    @Test
    fun smallestNumber_singleDigitNeedsIncrement_returns8() {
        // from 7: 7%8!=0, 8%8==0
        assertEquals(8, solution.smallestNumber(7, 8))
    }

    @Test
    fun smallestNumber_findsNumberWithZeroDigit_returns20() {
        // from 19: 1*9=9 not div by 5; 20 -> product 0 divisible by 5
        assertEquals(20, solution.smallestNumber(19, 5))
    }

    @Test
    fun smallestNumber_productDivisibleByFour_returns18() {
        // from 17: 1*7=7 not div 4; 18 -> 1*8=8 divisible by 4
        assertEquals(18, solution.smallestNumber(17, 4))
    }

    @Test
    fun smallestNumber_smallInput_returnsSame() {
        assertEquals(1, solution.smallestNumber(1, 1))
    }
}
