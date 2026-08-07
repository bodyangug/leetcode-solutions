package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductIITest {
    private val solution = SmallestDivisibleDigitProductII()

    @Test
    fun smallestNumber_example1_returns1488() {
        // smallest zero-free number >= 1234 with digit product divisible by 256
        assertEquals("1488", solution.smallestNumber("1234", 256))
    }

    @Test
    fun smallestNumber_example2_alreadySatisfies_returns12355() {
        // 1*2*3*5*5 = 150, divisible by 50, and already zero-free
        assertEquals("12355", solution.smallestNumber("12355", 50))
    }

    @Test
    fun smallestNumber_example3_impossible_returnsMinusOne() {
        // 26 = 2 * 13; 13 is not a product of digits 1..9
        assertEquals("-1", solution.smallestNumber("11111", 26))
    }

    @Test
    fun smallestNumber_tIsOne_returnsNumUnchanged() {
        // every digit product is divisible by 1 and num is already zero-free
        assertEquals("123", solution.smallestNumber("123", 1))
    }

    @Test
    fun smallestNumber_zeroDigitForcesRewrite_returns115() {
        // 105 contains a zero; smallest zero-free >= 105 with product divisible by 5
        assertEquals("115", solution.smallestNumber("105", 5))
    }

    @Test
    fun smallestNumber_tIsOneWithZeroDigit_returns111() {
        // 100 has zeros; smallest zero-free >= 100 is 111
        assertEquals("111", solution.smallestNumber("100", 1))
    }

    @Test
    fun smallestNumber_singleDigitIncrement_returns8() {
        // from 7: 7 % 8 != 0, 8 % 8 == 0
        assertEquals("8", solution.smallestNumber("7", 8))
    }

    @Test
    fun smallestNumber_needsLongerNumber_returns18() {
        // no single zero-free digit >= 9 has product divisible by 8; grow to two digits
        assertEquals("18", solution.smallestNumber("9", 8))
    }

    @Test
    fun smallestNumber_primeFactorTooLarge_returnsMinusOne() {
        // 11 cannot be formed from a product of digits 1..9
        assertEquals("-1", solution.smallestNumber("1234", 11))
    }

    @Test
    fun smallestNumber_incrementSameLength_returns1288() {
        // smallest zero-free >= 1234 with digit product divisible by 128
        assertEquals("1288", solution.smallestNumber("1234", 128))
    }
}
