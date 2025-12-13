package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CouponCodeValidatorTest {
    private val validator = CouponCodeValidator()

    @Test
    fun `test example 1 - mixed valid and invalid coupons`() {
        val code = arrayOf("SAVE20", "", "PHARMA5", "SAVE@20")
        val businessLine = arrayOf("restaurant", "grocery", "pharmacy", "restaurant")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("PHARMA5", "SAVE20"), result)
    }

    @Test
    fun `test example 2 - inactive and invalid business line`() {
        val code = arrayOf("GROCERY15", "ELECTRONICS_50", "DISCOUNT10")
        val businessLine = arrayOf("grocery", "electronics", "invalid")
        val isActive = booleanArrayOf(false, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("ELECTRONICS_50"), result)
    }

    @Test
    fun `test all valid coupons - sorted by business line rank then code`() {
        val code = arrayOf("SAVE20", "PHARMA5", "GROCERY10", "ELEC15")
        val businessLine = arrayOf("restaurant", "pharmacy", "grocery", "electronics")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        // Expected order: electronics(0), grocery(1), pharmacy(2), restaurant(3)
        assertEquals(listOf("ELEC15", "GROCERY10", "PHARMA5", "SAVE20"), result)
    }

    @Test
    fun `test sorting by code when business lines are the same`() {
        val code = arrayOf("SAVE30", "SAVE10", "SAVE20")
        val businessLine = arrayOf("restaurant", "restaurant", "restaurant")
        val isActive = booleanArrayOf(true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("SAVE10", "SAVE20", "SAVE30"), result)
    }

    @Test
    fun `test empty code is invalid`() {
        val code = arrayOf("", "VALID123")
        val businessLine = arrayOf("grocery", "grocery")
        val isActive = booleanArrayOf(true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("VALID123"), result)
    }

    @Test
    fun `test special characters are invalid`() {
        val code = arrayOf("SAVE@20", "SAVE#20", "SAVE%20", "VALID_CODE")
        val businessLine = arrayOf("grocery", "grocery", "grocery", "grocery")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("VALID_CODE"), result)
    }

    @Test
    fun `test inactive coupons are filtered out`() {
        val code = arrayOf("CODE1", "CODE2", "CODE3")
        val businessLine = arrayOf("grocery", "grocery", "grocery")
        val isActive = booleanArrayOf(false, false, false)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun `test invalid business line is filtered out`() {
        val code = arrayOf("CODE1", "CODE2", "CODE3")
        val businessLine = arrayOf("invalid", "unknown", "test")
        val isActive = booleanArrayOf(true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun `test valid characters - alphanumeric and underscore`() {
        val code = arrayOf("ABC123", "abc123", "Code_123", "123ABC")
        val businessLine = arrayOf("electronics", "grocery", "pharmacy", "restaurant")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("ABC123", "abc123", "Code_123", "123ABC"), result)
    }

    @Test
    fun `test empty input arrays`() {
        val code = arrayOf<String>()
        val businessLine = arrayOf<String>()
        val isActive = booleanArrayOf()

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun `test mismatched array sizes - uses minimum size`() {
        val code = arrayOf("CODE1", "CODE2", "CODE3", "CODE4")
        val businessLine = arrayOf("grocery", "electronics")
        val isActive = booleanArrayOf(true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        // Only first element is processed due to minOf
        assertEquals(listOf("CODE1"), result)
    }

    @Test
    fun `test all business lines represented`() {
        val code = arrayOf("E_CODE", "G_CODE", "P_CODE", "R_CODE")
        val businessLine = arrayOf("electronics", "grocery", "pharmacy", "restaurant")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("E_CODE", "G_CODE", "P_CODE", "R_CODE"), result)
    }

    @Test
    fun `test complex sorting - same rank different codes`() {
        val code = arrayOf("ZZZ", "AAA", "MMM")
        val businessLine = arrayOf("grocery", "grocery", "grocery")
        val isActive = booleanArrayOf(true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("AAA", "MMM", "ZZZ"), result)
    }

    @Test
    fun `test complex sorting - different ranks and codes`() {
        val code = arrayOf("Z_REST", "A_ELEC", "M_GROC", "B_ELEC")
        val businessLine = arrayOf("restaurant", "electronics", "grocery", "electronics")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        // electronics(0): A_ELEC, B_ELEC
        // grocery(1): M_GROC
        // restaurant(3): Z_REST
        assertEquals(listOf("A_ELEC", "B_ELEC", "M_GROC", "Z_REST"), result)
    }

    @Test
    fun `test spaces are invalid`() {
        val code = arrayOf("SAVE 20", "SAVE20")
        val businessLine = arrayOf("grocery", "grocery")
        val isActive = booleanArrayOf(true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("SAVE20"), result)
    }

    @Test
    fun `test hyphens are invalid`() {
        val code = arrayOf("SAVE-20", "SAVE20")
        val businessLine = arrayOf("grocery", "grocery")
        val isActive = booleanArrayOf(true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("SAVE20"), result)
    }

    @Test
    fun `test single character codes are valid`() {
        val code = arrayOf("A", "B", "1", "_")
        val businessLine = arrayOf("electronics", "grocery", "pharmacy", "restaurant")
        val isActive = booleanArrayOf(true, true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("A", "B", "1", "_"), result)
    }

    @Test
    fun `test case sensitivity in codes`() {
        val code = arrayOf("abc", "ABC", "AbC")
        val businessLine = arrayOf("grocery", "grocery", "grocery")
        val isActive = booleanArrayOf(true, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        // Should be sorted lexicographically (uppercase comes before lowercase in ASCII)
        assertEquals(listOf("ABC", "AbC", "abc"), result)
    }

    @Test
    fun `test mixed active and inactive with same codes`() {
        val code = arrayOf("SAVE20", "SAVE20", "SAVE10")
        val businessLine = arrayOf("grocery", "grocery", "grocery")
        val isActive = booleanArrayOf(false, true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("SAVE10", "SAVE20"), result)
    }

    @Test
    fun `test only underscores are valid`() {
        val code = arrayOf("___", "SAVE_20")
        val businessLine = arrayOf("electronics", "electronics")
        val isActive = booleanArrayOf(true, true)

        val result = validator.validateCoupons(code, businessLine, isActive)

        assertEquals(listOf("SAVE_20", "___"), result)
    }
}
